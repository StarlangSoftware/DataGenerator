package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import MorphologicalAnalysis.MorphologicalParse;

public class IsRealAttribute extends BinaryAttribute {

    /**
     * Binary attribute for a given word. If the word is represents a real number (if the morphological parse contains
     * tag REAL), the attribute will have the value "true", otherwise "false".
     * @param parse Morphological parse of the word.
     */
	public IsRealAttribute(MorphologicalParse parse){
        super(parse.isReal());
    }
}
