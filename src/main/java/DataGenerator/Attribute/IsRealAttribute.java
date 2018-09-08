package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import MorphologicalAnalysis.MorphologicalParse;

public class IsRealAttribute extends BinaryAttribute {

	public IsRealAttribute(MorphologicalParse parse){
        super(parse.isReal());
    }
}
