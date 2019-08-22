package DataGenerator.InstanceGenerator;

import Classification.Instance.Instance;
import Corpus.Sentence;
import AnnotatedSentence.AnnotatedWord;
import NamedEntityRecognition.NamedEntityType;

public abstract class NerInstanceGenerator extends SimpleWindowInstanceGenerator{

    /**
     * Generates a single classification instance of the NER problem for the given word of the given sentence. If the
     * word has not been labeled with NER tag yet, the method returns null.
     * @param sentence Input sentence.
     * @param wordIndex The index of the word in the sentence.
     * @return Classification instance.
     * @throws InstanceNotGenerated
     */
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
