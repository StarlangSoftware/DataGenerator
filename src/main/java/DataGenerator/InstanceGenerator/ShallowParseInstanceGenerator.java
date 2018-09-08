package DataGenerator.InstanceGenerator;

import Classification.Instance.Instance;
import Corpus.Sentence;
import AnnotatedSentence.AnnotatedWord;

public abstract class ShallowParseInstanceGenerator extends SimpleWindowInstanceGenerator {

    public Instance generateInstanceFromSentence(Sentence sentence, int wordIndex) throws InstanceNotGenerated {
        Instance current;
        AnnotatedWord word;
        word = (AnnotatedWord) sentence.getWord(wordIndex);
        String classLabel = word.getShallowParse();
        if (classLabel == null){
            return null;
        }
        current = new Instance(classLabel);
        addAttributes(current, sentence, wordIndex);
        return current;
    }

}
