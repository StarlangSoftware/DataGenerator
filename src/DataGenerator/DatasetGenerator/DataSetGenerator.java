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
    private TreeBankDrawable treeBank;
    protected InstanceGenerator instanceGenerator;

    public DataSetGenerator(String directory, String pattern, boolean includePunctuation, InstanceGenerator instanceGenerator){
        treeBank = new TreeBankDrawable(new File(directory), pattern);
        this.instanceGenerator = instanceGenerator;
        if (!includePunctuation)
            treeBank.stripPunctuation();
    }

    protected ArrayList<Instance> generateInstanceListFromTree(ParseTreeDrawable parseTree) {
        ArrayList<Instance> instanceList = new ArrayList<Instance>();
        AnnotatedSentence annotatedSentence = parseTree.generateAnnotatedSentence();
        for (int i = 0; i < annotatedSentence.wordCount(); i++){
            try {
                Instance generatedInstance = instanceGenerator.generateInstanceFromSentence(annotatedSentence, i);
                if (generatedInstance != null){
                    instanceList.add(generatedInstance);
                }
            } catch (InstanceNotGenerated e) {
                System.out.println(e.toString());
            }
        }
        return instanceList;
    }

    public void setInstanceGenerator(InstanceGenerator instanceGenerator){
        this.instanceGenerator = instanceGenerator;
    }

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
