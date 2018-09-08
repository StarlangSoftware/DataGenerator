package DataGenerator.Attribute;

import Classification.Attribute.DiscreteAttribute;
import MorphologicalAnalysis.MorphologicalParse;

public class MainPosAttribute extends DiscreteAttribute {

    /**
     * Discrete attribute for a given word. Returns the last part of speech (main part of speech) of the word
     * @param parse Morphological parse of the word.
     */
    public MainPosAttribute(MorphologicalParse parse){
        super(parse.getPos());
    }
}
