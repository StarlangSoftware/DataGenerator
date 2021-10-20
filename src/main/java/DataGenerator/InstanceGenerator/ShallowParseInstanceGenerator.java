package DataGenerator.InstanceGenerator;

import Classification.Instance.Instance;
import Corpus.Sentence;
import AnnotatedSentence.AnnotatedWord;

public abstract class ShallowParseInstanceGenerator extends SimpleWindowInstanceGenerator {

    /**
     * Generates a single classification instance of the Shallow Parse problem for the given word of the given sentence.
     * If the  word has not been labeled with shallow parse tag yet, the method returns null.
     * @param sentence Input sentence.
     * @param wordIndex The index of the word in the sentence.
     * @return Classification instance.
     * @throws InstanceNotGenerated If attributes can not be added, throws InstanceNotGenerated.
     */
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
