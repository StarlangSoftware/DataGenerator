package DataGenerator.Attribute;

import Classification.Attribute.DiscreteAttribute;
import MorphologicalAnalysis.MorphologicalParse;

public class CaseAttribute extends DiscreteAttribute {
    /**
     * Discrete attribute for a given word. If the last inflectional group of the word contains case information, the
     * attribute will have that case value. Otherwise the attribute will have the value null.
     * @param parse Morphological parse of the word.
     */
    public CaseAttribute(MorphologicalParse parse){
        super(parse.lastIGContainsCase());
    }
}
