package DataGenerator.CorpusGenerator;

import AnnotatedSentence.ViewLayerType;
import Corpus.Sentence;
import MorphologicalDisambiguation.DisambiguationCorpus;
import AnnotatedTree.ParseTreeDrawable;
import AnnotatedTree.TreeBankDrawable;
import java.io.File;

public class DisambiguationCorpusGenerator {
    private TreeBankDrawable treeBank;

    /**
     * Constructor for the DisambiguationCorpusGenerator which takes input the data directory and the pattern for the
     * training files included. The constructor loads the treebank from the given directory including the given files
     * having the given pattern.
     *
     * @param directory Directory where the treebank files reside.
     * @param pattern Pattern of the tree files to be included in the treebank. Use "." for all files.
     */
    public DisambiguationCorpusGenerator(String directory, String pattern){
        treeBank = new TreeBankDrawable(new File(directory), pattern);
    }

    /**
     * Creates a morphological disambiguation corpus from the treeBank. Calls generateAnnotatedSentence for each parse
     * tree in the treebank.
     *
     * @return Created disambiguation corpus.
     */
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
