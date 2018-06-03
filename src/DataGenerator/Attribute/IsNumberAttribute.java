package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import MorphologicalAnalysis.MorphologicalParse;

public class IsNumberAttribute extends BinaryAttribute {

    public IsNumberAttribute(MorphologicalParse parse){
        super(parse.isNumber());
    }
}
