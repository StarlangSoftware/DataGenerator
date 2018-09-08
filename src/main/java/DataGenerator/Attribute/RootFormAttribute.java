package DataGenerator.Attribute;

import Classification.Attribute.DiscreteAttribute;
import MorphologicalAnalysis.MorphologicalParse;

public class RootFormAttribute extends DiscreteAttribute {

    /**
     * Discrete attribute for a given word. Returns the the root word
     * @param parse Morphological parse of the word.
     */
    public RootFormAttribute(MorphologicalParse parse){
        super(parse.getWord().getName());
    }
}
