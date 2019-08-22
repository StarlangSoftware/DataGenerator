package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import MorphologicalAnalysis.MorphologicalParse;

public class IsNumberAttribute extends BinaryAttribute {

    /**
     * Binary attribute for a given word. If the word is represents a number (if the morphological parse contains
     * tag REAL or CARDINAL), the attribute will have the value "true", otherwise "false".
     * @param parse Morphological parse of the word.
     */
    public IsNumberAttribute(MorphologicalParse parse){
        super(parse.isNumber());
    }
}
