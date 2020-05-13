package DataGenerator.CorpusGenerator;

import MorphologicalDisambiguation.DisambiguationCorpus;
import NamedEntityRecognition.NERCorpus;

public class TestCorpusGenerator {

    private static void treeDisambiguationCorpusGenerate(){
        TreeDisambiguationCorpusGenerator treeDisambiguationCorpusGenerator;
        treeDisambiguationCorpusGenerator = new TreeDisambiguationCorpusGenerator("../../Penn-Treebank/Turkish", ".");
        DisambiguationCorpus corpus = treeDisambiguationCorpusGenerator.generate();
        corpus.writeToFile("corpus1.txt");
    }

    private static void sentenceDisambiguationCorpusGenerate(){
        SentenceDisambiguationCorpusGenerator sentenceDisambiguationCorpusGenerator;
        sentenceDisambiguationCorpusGenerator = new SentenceDisambiguationCorpusGenerator("../../Penn-Treebank/Turkish-Phrase", ".");
        DisambiguationCorpus corpus = sentenceDisambiguationCorpusGenerator.generate();
        corpus.writeToFile("corpus2.txt");
    }

    private static void nerCorpusGenerate(){
        NERCorpusGenerator nerCorpusGenerator;
        nerCorpusGenerator = new NERCorpusGenerator("../Penn-Treebank/Turkish", ".");
        NERCorpus corpus = nerCorpusGenerator.generate();
        corpus.writeToFile("corpus.txt");
    }

    public static void main(String[] args){
        sentenceDisambiguationCorpusGenerate();
    }
}
