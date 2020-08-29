package DataGenerator.DatasetGenerator;

import Classification.DataSet.DataSet;
import DataGenerator.InstanceGenerator.FeaturedNerInstanceGenerator;
import DataGenerator.InstanceGenerator.FeaturedSemanticInstanceGenerator;
import MorphologicalAnalysis.FsmMorphologicalAnalyzer;
import WordNet.WordNet;
import org.junit.Test;

import static org.junit.Assert.*;

public class SemanticDataSetGeneratorTest {

    @Test
    public void testGenerate() {
        FsmMorphologicalAnalyzer fsmMorphologicalAnalyzer = new FsmMorphologicalAnalyzer();
        WordNet turkish = new WordNet();
        SemanticDataSetGenerator semanticDataSetGenerator = new SemanticDataSetGenerator("trees/", ".dev", new FeaturedSemanticInstanceGenerator(fsmMorphologicalAnalyzer, turkish, 1));
        DataSet dataSet = semanticDataSetGenerator.generate();
        assertEquals(88, dataSet.sampleSize());
        assertEquals(64, dataSet.classCount());
        assertEquals(66, dataSet.attributeCount());
    }
}