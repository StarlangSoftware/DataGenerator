package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import NamedEntityRecognition.Gazetteer;

public class IsOrganizationGazetteer extends BinaryAttribute {
	public static Gazetteer gazetteer = new Gazetteer("ORGANIZATION", "gazetteer-organization.txt") {};

	/**
	 * Binary attribute for a given word. If the word is listed in the Organization Gazetteer file, the attribute will
	 * have the value "true", otherwise "false".
	 * @param surfaceForm Surface form of the word.
	 */
	public IsOrganizationGazetteer(String surfaceForm){
		super(gazetteer.contains(surfaceForm));
	}
}
