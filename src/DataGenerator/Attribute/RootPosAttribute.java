package DataGenerator.Attribute;

import Classification.Attribute.DiscreteAttribute;
import MorphologicalAnalysis.MorphologicalParse;

public class RootPosAttribute extends DiscreteAttribute {

    /**
     * Discrete attribute for a given word. Returns the part of speech of the root word
     * @param parse Morphological parse of the word.
     */
    public RootPosAttribute(MorphologicalParse parse){
        super(parse.getRootPos());
    }
}
