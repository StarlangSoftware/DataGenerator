package DataGenerator.InstanceGenerator;

import AnnotatedSentence.LayerNotExistsException;
import Classification.Instance.Instance;
import Corpus.Sentence;
import Corpus.WordFormat;
import AnnotatedSentence.AnnotatedWord;
import Dictionary.VectorizedDictionary;
import Dictionary.VectorizedWord;

public class VectorizedNerInstanceGenerator extends NerInstanceGenerator{
    private VectorizedDictionary dictionary;
    private WordFormat format;

    public VectorizedNerInstanceGenerator(VectorizedDictionary dictionary, int windowSize, WordFormat format) {
        this.dictionary = dictionary;
        this.windowSize = windowSize;
        this.format = format;
    }

    protected void addAttributesForWords(Instance current, Sentence sentence, int wordIndex) throws WordNotExistsInDictionary, LayerNotExistsException {
        AnnotatedWord word;
        word = (AnnotatedWord) sentence.getWord(wordIndex);
        VectorizedWord vectorizedWord = (VectorizedWord) dictionary.getWord(word.getFormattedString(format));
        if (vectorizedWord != null){
            current.addVectorAttribute(vectorizedWord.getVector());
        } else {
            throw new WordNotExistsInDictionary(word.getName());
        }
    }

    protected void addAttributesForEmptyWords(Instance current, String emptyWord) throws WordNotExistsInDictionary {
        VectorizedWord vectorizedWord = (VectorizedWord) dictionary.getWord(emptyWord);
        if (vectorizedWord != null){
            current.addVectorAttribute(vectorizedWord.getVector());
        } else {
            throw new WordNotExistsInDictionary(emptyWord);
        }
    }
}
