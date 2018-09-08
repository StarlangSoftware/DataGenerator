package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import MorphologicalAnalysis.MorphologicalParse;

public class IsProperNounAttribute extends BinaryAttribute {

    public IsProperNounAttribute(MorphologicalParse parse){
        super(parse.isProperNoun());
    }
}
