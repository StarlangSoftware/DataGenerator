package DataGenerator.Attribute;

import AnnotatedSentence.AnnotatedSentence;
import Classification.Attribute.DiscreteAttribute;
import Corpus.Sentence;

public class Predicate extends DiscreteAttribute {

	/**
	 * Discrete attribute for a given word. Returns the nearest predicate word to the given word
	 * @param sentence Sentence where current word is in.
	 * @param index Position of the current word in the sentence
	 */
	public Predicate(Sentence sentence, int index) {
		super(((AnnotatedSentence)sentence).getPredicate(index));
	}

}
