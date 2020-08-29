package DataGenerator.DatasetGenerator;

import AnnotatedTree.ChunkType;
import Classification.DataSet.DataSet;
import DataGenerator.InstanceGenerator.FeaturedShallowParseInstanceGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShallowParseDataSetGeneratorTest {

    @Test
    public void testGenerate() {
        ShallowParseDataSetGenerator shallowParseDataSetGenerator = new ShallowParseDataSetGenerator("trees/", ".dev", ChunkType.NORMAL, new FeaturedShallowParseInstanceGenerator(1));
        DataSet dataSet = shallowParseDataSetGenerator.generate();
        assertEquals(85, dataSet.sampleSize());
        assertEquals(11, dataSet.classCount());
        assertEquals(66, dataSet.attributeCount());
        shallowParseDataSetGenerator = new ShallowParseDataSetGenerator("trees/", ".dev", ChunkType.EXISTS, new FeaturedShallowParseInstanceGenerator(1));
        dataSet = shallowParseDataSetGenerator.generate();
        assertEquals(85, dataSet.sampleSize());
        assertEquals(2, dataSet.classCount());
        assertEquals(66, dataSet.attributeCount());
    }
}