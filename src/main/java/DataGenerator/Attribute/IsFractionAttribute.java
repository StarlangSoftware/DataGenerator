package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import MorphologicalAnalysis.MorphologicalParse;

public class IsFractionAttribute extends BinaryAttribute {

	/**
	 * Binary attribute for a given word. If the word is represents a fraction (if the morphological parse contains
	 * tag FRACTION), the attribute will have the value "true", otherwise "false".
	 * @param parse Morphological parse of the word.
	 */
	public IsFractionAttribute(MorphologicalParse parse){
		super(parse.isFraction());
	}
}
