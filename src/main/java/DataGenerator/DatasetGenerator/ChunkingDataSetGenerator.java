package DataGenerator.DatasetGenerator;

import AnnotatedSentence.*;
import AnnotatedTree.ChunkType;
import Classification.Instance.Instance;
import DataGenerator.InstanceGenerator.ShallowParseInstanceGenerator;
import AnnotatedTree.ParseTreeDrawable;

import java.util.ArrayList;

public class ChunkingDataSetGenerator extends DataSetGenerator{
    private ChunkType chunkType;

    public ChunkingDataSetGenerator(String directory, String pattern, ChunkType chunkType, ShallowParseInstanceGenerator shallowParseInstanceGenerator) {
        super(directory, pattern, true, shallowParseInstanceGenerator);
        this.chunkType = chunkType;
    }

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
