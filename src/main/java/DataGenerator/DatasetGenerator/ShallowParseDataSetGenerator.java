package DataGenerator.DatasetGenerator;

import AnnotatedSentence.*;
import AnnotatedTree.ChunkType;
import Classification.Instance.Instance;
import DataGenerator.InstanceGenerator.ShallowParseInstanceGenerator;
import AnnotatedTree.ParseTreeDrawable;

import java.util.ArrayList;

public class ShallowParseDataSetGenerator extends DataSetGenerator{
    private ChunkType chunkType;

    /**
     * Constructor for the ChunkingDataSetGenerator which takes input the data directory, the pattern for the training files
     * included, chunkType, and an instanceGenerator. The constructor calls the super class, where the punctuation symbols
     * are included. The dataset generator generates the dataset for the given  chunk type.
     * @param directory Directory where the treebank files reside.
     * @param pattern Pattern of the tree files to be included in the treebank. Use "." for all files.
     * @param chunkType THe chunkType for which the chunking dataset is generated.
     * @param shallowParseInstanceGenerator The instance generator used to generate the dataset.
     */
    public ShallowParseDataSetGenerator(String directory, String pattern, ChunkType chunkType, ShallowParseInstanceGenerator shallowParseInstanceGenerator) {
        super(directory, pattern, true, shallowParseInstanceGenerator);
        this.chunkType = chunkType;
    }

    /**
     * Overriden the method that generates a set of instances (an instance from each word in the tree) from
     * a single tree.
     * @param parseTree Parsetree for which a set of instances will be created
     * @return An array of instances.
     */
    protected ArrayList<Instance> generateInstanceListFromTree(ParseTreeDrawable parseTree){
        ArrayList<Instance> instanceList = new ArrayList<Instance>();
        if (!parseTree.layerAll(ViewLayerType.INFLECTIONAL_GROUP))
            return instanceList;
        if (!parseTree.isFullSentence())
            return instanceList;
        parseTree.extractVerbal();
        parseTree.setShallowParseLayer(chunkType);
        return super.generateInstanceListFromTree(parseTree);
    }

}
