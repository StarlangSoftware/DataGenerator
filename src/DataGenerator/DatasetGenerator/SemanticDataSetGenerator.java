package DataGenerator.DatasetGenerator;

import DataGenerator.InstanceGenerator.SemanticInstanceGenerator;

public class SemanticDataSetGenerator extends DataSetGenerator{

    public SemanticDataSetGenerator(String directory, String pattern, SemanticInstanceGenerator semanticInstanceGenerator) {
        super(directory, pattern, true, semanticInstanceGenerator);
    }

}
