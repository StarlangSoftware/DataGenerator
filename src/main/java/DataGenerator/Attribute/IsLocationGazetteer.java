package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import NamedEntityRecognition.Gazetteer;

public class IsLocationGazetteer extends BinaryAttribute {
	public static Gazetteer gazetteer = new Gazetteer("LOCATION", "gazetteer-location.txt") {};

	/**
	 * Binary attribute for a given word. If the word is listed in the Location Gazetteer file, the attribute will
	 * have the value "true", otherwise "false".
	 * @param surfaceForm Surface form of the word.
	 */
	public IsLocationGazetteer(String surfaceForm){
		super(gazetteer.contains(surfaceForm));
	}
}
