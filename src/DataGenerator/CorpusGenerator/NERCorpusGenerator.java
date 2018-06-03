package DataGenerator.CorpusGenerator;

import AnnotatedSentence.ViewLayerType;
import Corpus.Sentence;
import NamedEntityRecognition.NERCorpus;
import AnnotatedTree.ParseTreeDrawable;
import AnnotatedTree.TreeBankDrawable;

import java.io.File;

public class NERCorpusGenerator {
    private TreeBankDrawable treeBank;

    public NERCorpusGenerator(String directory, String pattern){
        treeBank = new TreeBankDrawable(new File(directory), pattern);
    }

    public NERCorpus generate(){
        ParseTreeDrawable parseTree;
        Sentence sentence;
        NERCorpus corpus = new NERCorpus();
        for (int i = 0; i < treeBank.size(); i++){
            parseTree = treeBank.get(i);
            if (parseTree.layerAll(ViewLayerType.NER)){
                sentence = parseTree.generateAnnotatedSentence();
                corpus.addSentence(sentence);
            }
        }
        return corpus;
    }

}
