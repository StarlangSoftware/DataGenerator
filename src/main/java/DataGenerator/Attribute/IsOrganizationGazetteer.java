package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import NamedEntityRecognition.Gazetteer;

public class IsOrganizationGazetteer extends BinaryAttribute {
	public static Gazetteer gazetteer = new Gazetteer("ORGANIZATION", "gazetteer-person.txt") {};

	public IsOrganizationGazetteer(String surfaceForm){super(gazetteer.contains(surfaceForm));}
}
