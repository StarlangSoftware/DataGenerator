package DataGenerator.InstanceGenerator;

import Classification.Instance.Instance;
import Corpus.Sentence;
import AnnotatedSentence.AnnotatedWord;

public abstract class RootWordInstanceGenerator extends InstanceGenerator{

    protected abstract void addAttributesForPreviousWords(Instance current, Sentence sentence, int wordIndex);
    protected abstract void addAttributesForEmptyWords(Instance current, String emptyWord);

    /**
     * Generates a single classification instance of the root word detection problem for the given word of the
     * given sentence. If the word does not have a morphological parse, the method throws InstanceNotGenerated.
     * @param sentence Input sentence.
     * @param wordIndex The index of the word in the sentence.
     * @return Classification instance.
     */
    public Instance generateInstanceFromSentence(Sentence sentence, int wordIndex) throws InstanceNotGenerated{
        Instance current;
        AnnotatedWord word;
        word = (AnnotatedWord) sentence.getWord(wordIndex);
        if (word.getParse() == null){
            throw new InstanceNotGenerated(word.getName());
        }
        current = new Instance(word.getParse().getWord().getName());
        for (int i = 1; i <= windowSize; i++){
            if (wordIndex - windowSize >= 0){
                addAttributesForPreviousWords(current, sentence, wordIndex - windowSize);
            } else {
                addAttributesForEmptyWords(current, "<s>");
            }
        }
        addAttributesForPreviousWords(current, sentence, wordIndex);
        return current;
    }

}
