package DataGenerator.CorpusGenerator;

import MorphologicalDisambiguation.DisambiguationCorpus;
import NamedEntityRecognition.NERCorpus;

public class TestCorpusGenerator {

    private static void disambiguationCorpusGenerate(){
        DisambiguationCorpusGenerator disambiguationCorpusGenerator;
        disambiguationCorpusGenerator = new DisambiguationCorpusGenerator("../Penn-Treebank/Turkish", ".");
        DisambiguationCorpus corpus = disambiguationCorpusGenerator.generate();
        corpus.writeToFile("corpus.txt");
    }

    private static void nerCorpusGenerate(){
        NERCorpusGenerator nerCorpusGenerator;
        nerCorpusGenerator = new NERCorpusGenerator("../Penn-Treebank/Turkish", ".");
        NERCorpus corpus = nerCorpusGenerator.generate();
        corpus.writeToFile("corpus.txt");
    }

    public static void main(String[] args){
        disambiguationCorpusGenerate();
    }
}
