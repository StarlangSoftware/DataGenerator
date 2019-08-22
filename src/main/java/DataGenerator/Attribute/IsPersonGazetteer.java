package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import NamedEntityRecognition.Gazetteer;

public class IsPersonGazetteer extends BinaryAttribute {
	public static Gazetteer gazetteer = new Gazetteer("PERSON", "gazetteer-person.txt") {};

	/**
	 * Binary attribute for a given word. If the word is listed in the Person Gazetteer file, the attribute will
	 * have the value "true", otherwise "false".
	 * @param surfaceForm Surface form of the word.
	 */
	public IsPersonGazetteer(String surfaceForm){
		super(gazetteer.contains(surfaceForm));
	}
}
