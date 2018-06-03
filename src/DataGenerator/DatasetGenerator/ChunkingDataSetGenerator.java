package DataGenerator.DatasetGenerator;

import AnnotatedSentence.*;
import AnnotatedTree.ChunkType;
import Classification.Instance.Instance;
import DataGenerator.InstanceGenerator.ShallowParseInstanceGenerator;
import DataGenerator.InstanceGenerator.InstanceNotGenerated;
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
        AnnotatedSentence annotatedSentence = parseTree.generateAnnotatedSentence();
        for (int i = 0; i < annotatedSentence.wordCount(); i++){
            try {
                Instance generatedInstance = instanceGenerator.generateInstanceFromSentence(annotatedSentence, i);
                if (generatedInstance != null){
                    instanceList.add(generatedInstance);
                }
            } catch (InstanceNotGenerated e) {
                System.out.println(e.toString());
            }
        }
        return instanceList;
    }

}
