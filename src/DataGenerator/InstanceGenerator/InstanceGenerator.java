package DataGenerator.InstanceGenerator;

import Classification.Instance.Instance;
import Corpus.Sentence;

public abstract class InstanceGenerator {
    protected int windowSize;

    public abstract Instance generateInstanceFromSentence(Sentence sentence, int wordIndex) throws InstanceNotGenerated;

}
