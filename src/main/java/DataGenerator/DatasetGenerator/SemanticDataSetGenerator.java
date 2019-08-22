package DataGenerator.DatasetGenerator;

import DataGenerator.InstanceGenerator.SemanticInstanceGenerator;

public class SemanticDataSetGenerator extends DataSetGenerator{

    /**
     * Constructor for the NerDataSetGenerator which takes input the data directory, the pattern for the training files
     * included, and an instanceGenerator. The constructor calls its super class with these inputs.
     * @param directory Directory where the treebank files reside.
     * @param pattern Pattern of the tree files to be included in the treebank. Use "." for all files.
     * @param semanticInstanceGenerator The instance generator used to generate the dataset.
     */
    public SemanticDataSetGenerator(String directory, String pattern, SemanticInstanceGenerator semanticInstanceGenerator) {
        super(directory, pattern, true, semanticInstanceGenerator);
    }

}
