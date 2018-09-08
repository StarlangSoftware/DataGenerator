package DataGenerator.DatasetGenerator;

import DataGenerator.InstanceGenerator.NerInstanceGenerator;

public class NerDataSetGenerator extends DataSetGenerator{

    public NerDataSetGenerator(String directory, String pattern, NerInstanceGenerator nerInstanceGenerator) {
        super(directory, pattern, true, nerInstanceGenerator);
    }

}
