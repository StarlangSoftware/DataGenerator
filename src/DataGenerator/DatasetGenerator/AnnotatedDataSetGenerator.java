package DataGenerator.DatasetGenerator;

import AnnotatedSentence.AnnotatedCorpus;
import AnnotatedSentence.AnnotatedSentence;
import Classification.DataSet.DataSet;
import Classification.Instance.Instance;
import DataGenerator.InstanceGenerator.InstanceGenerator;
import DataGenerator.InstanceGenerator.InstanceNotGenerated;

import java.io.File;

public class AnnotatedDataSetGenerator {
    private AnnotatedCorpus corpus;
    protected InstanceGenerator instanceGenerator;

    public AnnotatedDataSetGenerator(String directory, String pattern, InstanceGenerator instanceGenerator){
        corpus = new AnnotatedCorpus(new File(directory), pattern);
        this.instanceGenerator = instanceGenerator;
    }

    public void setInstanceGenerator(InstanceGenerator instanceGenerator){
        this.instanceGenerator = instanceGenerator;
    }

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
                } catch (InstanceNotGenerated e) {
                    System.out.println(e.toString());
                }
            }
        }
        return dataSet;
    }


}
