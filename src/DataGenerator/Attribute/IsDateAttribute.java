package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import MorphologicalAnalysis.MorphologicalParse;

public class IsDateAttribute extends BinaryAttribute {

    public IsDateAttribute (MorphologicalParse parse){
		super(parse.isDate());
	}
}
