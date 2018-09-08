package DataGenerator.DatasetGenerator;

import DataGenerator.InstanceGenerator.RootWordInstanceGenerator;

public class RootWordDataSetGenerator extends DataSetGenerator{

    public RootWordDataSetGenerator(String directory, String pattern, boolean includePunctuation, RootWordInstanceGenerator rootWordInstanceGenerator){
        super(directory, pattern, includePunctuation, rootWordInstanceGenerator);
    }

}
