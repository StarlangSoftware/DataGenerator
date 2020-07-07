package DataGenerator.DatasetGenerator;

import Classification.DataSet.DataSet;
import DataGenerator.InstanceGenerator.FeaturedDisambiguationInstanceGenerator;
import DataGenerator.InstanceGenerator.FeaturedNerInstanceGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class DisambiguationDataSetGeneratorTest {

    @Test
    public void testGenerate() {
        DisambiguationDataSetGenerator disambiguationDataSetGenerator = new DisambiguationDataSetGenerator("trees/", ".dev", true, new FeaturedDisambiguationInstanceGenerator(1));
        DataSet dataSet = disambiguationDataSetGenerator.generate();
        assertEquals(88, dataSet.sampleSize());
        assertEquals(40, dataSet.classCount());
        assertEquals(4, dataSet.attributeCount());
    }
}