package DataGenerator.DatasetGenerator;

import Classification.DataSet.DataSet;
import DataGenerator.InstanceGenerator.FeaturedNerInstanceGenerator;
import org.junit.Test;

import static org.junit.Assert.*;

public class NerDataSetGeneratorTest {

    @Test
    public void testGenerate() {
        NerDataSetGenerator nerDataSetGenerator = new NerDataSetGenerator("trees/", ".dev", new FeaturedNerInstanceGenerator(1));
        DataSet dataSet = nerDataSetGenerator.generate();
        assertEquals(88, dataSet.sampleSize());
        assertEquals(3, dataSet.classCount());
        assertEquals(75, dataSet.attributeCount());
    }
}