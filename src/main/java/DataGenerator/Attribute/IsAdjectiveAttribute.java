package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import MorphologicalAnalysis.MorphologicalParse;

public class IsAdjectiveAttribute extends BinaryAttribute {

    /**
     * Binary attribute for a given word. If the word is an adjective, the attribute will have
     * the value "true", otherwise "false".
     * @param parse Morphological parse of the word.
     */
    public IsAdjectiveAttribute(MorphologicalParse parse){
        super(parse.isAdjective());
    }
}
