package DataGenerator.DatasetGenerator;

import AnnotatedSentence.AnnotatedSentence;
import Classification.DataSet.DataSet;
import Classification.Instance.Instance;
import AnnotatedTree.*;
import DataGenerator.InstanceGenerator.InstanceGenerator;
import DataGenerator.InstanceGenerator.InstanceNotGenerated;
import AnnotatedTree.TreeBankDrawable;
import java.io.File;
import java.util.ArrayList;

public class DataSetGenerator {
    private final TreeBankDrawable treeBank;
    protected InstanceGenerator instanceGenerator;

    /**
     * Constructor for the DataSetGenerator which takes input the data directory, the pattern for the training files
     * included, includepunctuation, and an instanceGenerator. The constructor loads the treebank from the given directory
     * including the given files having the given pattern. If punctuations are not included, they are removed from
     * the data.
     * @param directory Directory where the treebank files reside.
     * @param pattern Pattern of the tree files to be included in the treebank. Use "." for all files.
     * @param includePunctuation If true, punctuation symbols are also included in the dataset, false otherwise.
     * @param instanceGenerator The instance generator used to generate the dataset.
     */
    public DataSetGenerator(String directory, String pattern, boolean includePunctuation, InstanceGenerator instanceGenerator){
        treeBank = new TreeBankDrawable(new File(directory), pattern);
        this.instanceGenerator = instanceGenerator;
        if (!includePunctuation)
            treeBank.stripPunctuation();
    }

    /**
     * The method generates a set of instances (an instance from each word in the tree) from a single tree. The method
     * calls the instanceGenerator for each word in the sentence.
     * @param parseTree Parsetree for which a set of instances will be created
     * @return An array of instances.
     */
    protected ArrayList<Instance> generateInstanceListFromTree(ParseTreeDrawable parseTree) {
        ArrayList<Instance> instanceList = new ArrayList<>();
        AnnotatedSentence annotatedSentence = parseTree.generateAnnotatedSentence();
        for (int i = 0; i < annotatedSentence.wordCount(); i++){
            try {
                Instance generatedInstance = instanceGenerator.generateInstanceFromSentence(annotatedSentence, i);
                if (generatedInstance != null){
                    instanceList.add(generatedInstance);
                }
            } catch (InstanceNotGenerated ignored) {
            }
        }
        return instanceList;
    }

    /**
     * Mutator for the instanceGenerator attribute.
     * @param instanceGenerator Input instanceGenerator
     */
    public void setInstanceGenerator(InstanceGenerator instanceGenerator){
        this.instanceGenerator = instanceGenerator;
    }

    /**
     * Creates a dataset from the treeBank. Calls generateInstanceListFromTree for each parse tree in the treebank.
     * @return Created dataset.
     */
    public DataSet generate(){
        ParseTreeDrawable parseTree;
        DataSet dataSet = new DataSet();
        for (int i = 0; i < treeBank.size(); i++){
            parseTree = treeBank.get(i);
            dataSet.addInstanceList(generateInstanceListFromTree(parseTree));
        }
        return dataSet;
    }

}
