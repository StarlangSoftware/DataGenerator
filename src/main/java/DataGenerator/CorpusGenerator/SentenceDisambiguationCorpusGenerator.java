package DataGenerator.CorpusGenerator;

import AnnotatedSentence.*;
import Corpus.DisambiguatedWord;
import Corpus.DisambiguationCorpus;

import java.io.File;

public class SentenceDisambiguationCorpusGenerator {
    private AnnotatedCorpus annotatedCorpus;

    /**
     * Constructor for the SentenceDisambiguationCorpusGenerator which takes input the data directory and the pattern for the
     * training files included. The constructor loads the corpus from the given directory including the given files
     * having the given pattern.
     *
     * @param directory Directory where the sentence files reside.
     * @param pattern Pattern of the sentence files to be included in the corpus. Use "." for all files.
     */
    public SentenceDisambiguationCorpusGenerator(String directory, String pattern){
        annotatedCorpus = new AnnotatedCorpus(new File(directory), pattern);
    }

    /**
     * Creates a morphological disambiguation corpus from the corpus.
     *
     * @return Created disambiguation corpus.
     */
    public DisambiguationCorpus generate(){
        AnnotatedSentence sentence, disambiguationSentence;
        DisambiguationCorpus corpus = new DisambiguationCorpus();
        for (int i = 0; i < annotatedCorpus.sentenceCount(); i++){
            sentence = (AnnotatedSentence) annotatedCorpus.getSentence(i);
            disambiguationSentence = new AnnotatedSentence();
            for (int j = 0; j < sentence.wordCount(); j++){
                disambiguationSentence.addWord(new DisambiguatedWord(sentence.getWord(j).getName(), ((AnnotatedWord)sentence.getWord(j)).getParse()));
            }
            corpus.addSentence(disambiguationSentence);
        }
        return corpus;
    }

}
