package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import NamedEntityRecognition.Gazetteer;

public class IsPersonGazetteer extends BinaryAttribute {
	public static Gazetteer gazetteer = new Gazetteer("PERSON", "gazetteer-person.txt") {};

	public IsPersonGazetteer(String surfaceForm){super(gazetteer.contains(surfaceForm));}
}
