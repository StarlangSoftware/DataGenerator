package DataGenerator.DatasetGenerator;

import DataGenerator.InstanceGenerator.DisambiguationInstanceGenerator;

public class DisambiguationDataSetGenerator extends DataSetGenerator{

    public DisambiguationDataSetGenerator(String directory, String pattern, boolean includePunctuation, DisambiguationInstanceGenerator disambiguationInstanceGenerator){
        super(directory, pattern, includePunctuation, disambiguationInstanceGenerator);
    }

}
