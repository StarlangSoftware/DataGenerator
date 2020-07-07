package DataGenerator.DatasetGenerator;

import Classification.DataSet.DataSet;
import DataGenerator.InstanceGenerator.FeaturedDisambiguationInstanceGenerator;
import DataGenerator.InstanceGenerator.FeaturedNerInstanceGenerator;
import DataGenerator.InstanceGenerator.FeaturedSemanticInstanceGenerator;
import DataGenerator.InstanceGenerator.FeaturedShallowParseInstanceGenerator;
import MorphologicalAnalysis.FsmMorphologicalAnalyzer;
import WordNet.WordNet;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnnotatedDataSetGeneratorTest {

    @Test
    public void testNERGenerate() {
        AnnotatedDataSetGenerator annotatedDataSetGenerator = new AnnotatedDataSetGenerator("sentences/", ".dev", new FeaturedNerInstanceGenerator(1));
        DataSet dataSet = annotatedDataSetGenerator.generate();
        assertEquals(101, dataSet.sampleSize());
        assertEquals(3, dataSet.classCount());
        assertEquals(75, dataSet.attributeCount());
    }

    @Test
    public void testSemanticGenerate() {
        FsmMorphologicalAnalyzer fsmMorphologicalAnalyzer = new FsmMorphologicalAnalyzer();
        WordNet turkish = new WordNet();
        AnnotatedDataSetGenerator annotatedDataSetGenerator = new AnnotatedDataSetGenerator("sentences/", ".dev", new FeaturedSemanticInstanceGenerator(fsmMorphologicalAnalyzer, turkish, 1));
        DataSet dataSet = annotatedDataSetGenerator.generate();
        assertEquals(101, dataSet.sampleSize());
        assertEquals(71, dataSet.classCount());
        assertEquals(66, dataSet.attributeCount());
    }

    @Test
    public void testShallowParseGenerate() {
        AnnotatedDataSetGenerator annotatedDataSetGenerator = new AnnotatedDataSetGenerator("sentences/", ".dev", new FeaturedShallowParseInstanceGenerator(1));
        DataSet dataSet = annotatedDataSetGenerator.generate();
        assertEquals(96, dataSet.sampleSize());
        assertEquals(6, dataSet.classCount());
        assertEquals(66, dataSet.attributeCount());
    }

    @Test
    public void testDisambiguationGenerate() {
        AnnotatedDataSetGenerator annotatedDataSetGenerator = new AnnotatedDataSetGenerator("sentences/", ".dev", new FeaturedDisambiguationInstanceGenerator(1));
        DataSet dataSet = annotatedDataSetGenerator.generate();
        assertEquals(101, dataSet.sampleSize());
        assertEquals(43, dataSet.classCount());
        assertEquals(4, dataSet.attributeCount());
    }

}