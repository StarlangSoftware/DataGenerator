package DataGenerator.CorpusGenerator;

import AnnotatedSentence.ViewLayerType;
import Corpus.Sentence;
import MorphologicalDisambiguation.DisambiguationCorpus;
import AnnotatedTree.ParseTreeDrawable;
import AnnotatedTree.TreeBankDrawable;
import java.io.File;

public class DisambiguationCorpusGenerator {
    private TreeBankDrawable treeBank;

    public DisambiguationCorpusGenerator(String directory, String pattern){
        treeBank = new TreeBankDrawable(new File(directory), pattern);
    }

    public DisambiguationCorpus generate(){
        ParseTreeDrawable parseTree;
        Sentence sentence;
        DisambiguationCorpus corpus = new DisambiguationCorpus();
        for (int i = 0; i < treeBank.size(); i++){
            parseTree = treeBank.get(i);
            if (parseTree.layerAll(ViewLayerType.INFLECTIONAL_GROUP)){
                sentence = parseTree.generateAnnotatedSentence();
                corpus.addSentence(sentence);
            }
        }
        return corpus;
    }

}
