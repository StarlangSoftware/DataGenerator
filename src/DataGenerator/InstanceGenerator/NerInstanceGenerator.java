package DataGenerator.InstanceGenerator;

import Classification.Instance.Instance;
import Corpus.Sentence;
import AnnotatedSentence.AnnotatedWord;
import NamedEntityRecognition.NamedEntityType;

public abstract class NerInstanceGenerator extends SimpleWindowInstanceGenerator{

    public Instance generateInstanceFromSentence(Sentence sentence, int wordIndex) throws InstanceNotGenerated {
        Instance current;
        AnnotatedWord word;
        word = (AnnotatedWord) sentence.getWord(wordIndex);
        String classLabel = NamedEntityType.getNamedEntityType(word.getNamedEntityType());
        if (classLabel == null){
            return null;
        }
        current = new Instance(classLabel);
        addAttributes(current, sentence, wordIndex);
        return current;
    }

}
