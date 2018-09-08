package DataGenerator.Attribute;

import AnnotatedSentence.AnnotatedSentence;
import Classification.Attribute.DiscreteAttribute;
import Corpus.Sentence;

public class Predicate extends DiscreteAttribute {

	public Predicate(Sentence sentence, int index) {
		super(((AnnotatedSentence)sentence).getPredicate(index));
	}

}
