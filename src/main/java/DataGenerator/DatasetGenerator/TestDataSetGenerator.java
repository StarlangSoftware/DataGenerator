package DataGenerator.DatasetGenerator;

import Classification.DataSet.DataSet;
import DataGenerator.InstanceGenerator.FeaturedNerInstanceGenerator;
import DataGenerator.InstanceGenerator.FeaturedSemanticInstanceGenerator;
import DataGenerator.InstanceGenerator.FeaturedShallowParseInstanceGenerator;
import DataGenerator.InstanceGenerator.InstanceGenerator;
import MorphologicalAnalysis.FsmMorphologicalAnalyzer;
import WordNet.WordNet;

public class TestDataSetGenerator {

    private static void generateNer(){
        InstanceGenerator instanceGenerator = new FeaturedNerInstanceGenerator(2);
        AnnotatedDataSetGenerator annotatedDataSetGenerator = new AnnotatedDataSetGenerator("../../Penn-Treebank/Turkish-Phrase/", ".", instanceGenerator);
        DataSet dataSet = annotatedDataSetGenerator.generate();
        dataSet.writeToFile("ner.txt");
    }

    private static void generateShallowParse(){
        InstanceGenerator instanceGenerator = new FeaturedShallowParseInstanceGenerator(2);
        AnnotatedDataSetGenerator annotatedDataSetGenerator = new AnnotatedDataSetGenerator("../../Penn-Treebank/Turkish-Phrase/", ".", instanceGenerator);
        DataSet dataSet = annotatedDataSetGenerator.generate();
        dataSet.writeToFile("shallowparse.txt");
    }

    private static void generateSemantic(){
        InstanceGenerator instanceGenerator = new FeaturedSemanticInstanceGenerator(new FsmMorphologicalAnalyzer(), new WordNet(), 2);
        AnnotatedDataSetGenerator annotatedDataSetGenerator = new AnnotatedDataSetGenerator("../../Penn-Treebank/Turkish-Phrase/", ".", instanceGenerator);
        DataSet dataSet = annotatedDataSetGenerator.generate();
        dataSet.writeToFile("semantic.txt");
    }

    public static void main(String[] args){
        generateNer();
    }
}
