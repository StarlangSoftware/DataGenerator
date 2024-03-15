package DataGenerator.DatasetGenerator;

import AnnotatedSentence.AnnotatedCorpus;
import AnnotatedSentence.AnnotatedSentence;
import Classification.DataSet.DataSet;
import Classification.Instance.Instance;
import DataGenerator.InstanceGenerator.InstanceGenerator;
import DataGenerator.InstanceGenerator.InstanceNotGenerated;

import java.io.File;

public class AnnotatedDataSetGenerator {
    private final AnnotatedCorpus corpus;
    protected InstanceGenerator instanceGenerator;

    /**
     * Constructor for the AnnotatedDataSetGenerator which takes input the data directory, the pattern for the
     * training files included, and an instanceGenerator. The constructor loads the sentence corpus from the given
     * directory including the given files having the given pattern.
     * @param directory Directory where the corpus files reside.
     * @param pattern Pattern of the tree files to be included in the treebank. Use "." for all files.
     * @param instanceGenerator The instance generator used to generate the dataset.
     */
    public AnnotatedDataSetGenerator(String directory, String pattern, InstanceGenerator instanceGenerator){
        corpus = new AnnotatedCorpus(new File(directory), pattern);
        this.instanceGenerator = instanceGenerator;
    }

    /**
     * Mutator for the instanceGenerator attribute.
     * @param instanceGenerator Input instanceGenerator
     */
    public void setInstanceGenerator(InstanceGenerator instanceGenerator){
        this.instanceGenerator = instanceGenerator;
    }

    /**
     * Creates a dataset from the corpus. Calls generateInstanceFromSentence for each parse sentence in the corpus.
     * @return Created dataset.
     */
    public DataSet generate(){
        AnnotatedSentence sentence;
        DataSet dataSet = new DataSet();
        for (int i = 0; i < corpus.sentenceCount(); i++){
            sentence = (AnnotatedSentence) corpus.getSentence(i);
            for (int j = 0; j < sentence.wordCount(); j++){
                try {
                    Instance generatedInstance = instanceGenerator.generateInstanceFromSentence(sentence, j);
                    if (generatedInstance != null){
                        dataSet.addInstance(generatedInstance);
                    }
                } catch (InstanceNotGenerated ignored) {
                }
            }
        }
        return dataSet;
    }


}
