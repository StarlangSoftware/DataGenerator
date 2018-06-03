package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import MorphologicalAnalysis.MorphologicalParse;

public class IsAuxiliaryVerbAttribute extends BinaryAttribute {

    /**
     * Binary attribute for a given word. If the word is an auxiliary verb, the attribute will have
     * the value "true", otherwise "false".
     * @param parse Morphological parse of the word.
     */
    public IsAuxiliaryVerbAttribute(MorphologicalParse parse){
        super(parse.isAuxiliary() && parse.isVerb());
    }
}
