package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import MorphologicalAnalysis.MorphologicalParse;

public class IsDateAttribute extends BinaryAttribute {

	/**
	 * Binary attribute for a given word. If the word represents a date (if the morphological parse contains
	 * tag DATE), the attribute will have the value "true", otherwise "false".
	 * @param parse Morphological parse of the word.
	 */
    public IsDateAttribute(MorphologicalParse parse){
		super(parse.isDate());
	}
}
