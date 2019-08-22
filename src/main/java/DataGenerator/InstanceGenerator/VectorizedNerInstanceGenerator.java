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

    /**
     * Constructor of VectorizedNerInstanceGenerator which takes input a {@link VectorizedDictionary}, a window size
     * and a word format and sets corresponding attributes with these inputs.
     * @param dictionary Dictionary in the vector form. Each word is stored in vector form in this dictionary.
     * @param windowSize Number of previous (next) words to be considered in adding attributes.
     * @param format Word vector format.
     */
    public VectorizedNerInstanceGenerator(VectorizedDictionary dictionary, int windowSize, WordFormat format) {
        this.dictionary = dictionary;
        this.windowSize = windowSize;
        this.format = format;
    }

    /**
     * Abstract function for adding vectorized attributes to the named entity recognition problem. The number of
     * attributes in this function should be equal to the number of attributes in the function addAttributesForEmptyWords.
     * @param current Current classification instance
     * @param sentence Input sentence.
     * @param wordIndex The index of the word in the sentence.
     */
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

    /**
     * Abstract function for adding attributes for empty words to the named entity recognition problem. The number of
     * attributes in this function should be equal to the number of attributes in the function
     * addAttributesForWords.
     * @param current Current classification instance
     * @param emptyWord String form to place for empty words.
     */
    protected void addAttributesForEmptyWords(Instance current, String emptyWord) throws WordNotExistsInDictionary {
        VectorizedWord vectorizedWord = (VectorizedWord) dictionary.getWord(emptyWord);
        if (vectorizedWord != null){
            current.addVectorAttribute(vectorizedWord.getVector());
        } else {
            throw new WordNotExistsInDictionary(emptyWord);
        }
    }
}
