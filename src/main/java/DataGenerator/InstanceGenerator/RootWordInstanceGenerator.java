package DataGenerator.InstanceGenerator;

import Classification.Instance.Instance;
import Corpus.Sentence;
import AnnotatedSentence.AnnotatedWord;

public abstract class RootWordInstanceGenerator extends InstanceGenerator{

    protected abstract void addAttributesForPreviousWords(Instance current, Sentence sentence, int wordIndex);
    protected abstract void addAttributesForEmptyWords(Instance current, String emptyWord);

    public Instance generateInstanceFromSentence(Sentence sentence, int wordIndex){
        Instance current;
        AnnotatedWord word;
        word = (AnnotatedWord) sentence.getWord(wordIndex);
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
