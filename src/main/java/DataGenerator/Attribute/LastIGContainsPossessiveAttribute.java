package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import MorphologicalAnalysis.MorphologicalParse;

public class LastIGContainsPossessiveAttribute extends BinaryAttribute {

    /**
     * Binary attribute for a given word. If the last inflectional group of the word contains POSSESSIVE tag,
     * the attribute will be "true", otherwise "false".
     * @param parse Morphological parse of the word.
     */
    public LastIGContainsPossessiveAttribute(MorphologicalParse parse){
        super(parse.lastIGContainsPossessive());
    }
}
