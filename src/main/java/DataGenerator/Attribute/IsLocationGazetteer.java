package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import NamedEntityRecognition.Gazetteer;

public class IsLocationGazetteer extends BinaryAttribute {
	public static Gazetteer gazetteer = new Gazetteer("LOCATION", "gazetteer-location.txt") {};

	public IsLocationGazetteer(String surfaceForm){super(gazetteer.contains(surfaceForm));}
}
