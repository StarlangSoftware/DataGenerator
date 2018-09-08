package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import MorphologicalAnalysis.MorphologicalParse;

public class IsFractionAttribute extends BinaryAttribute {

	public IsFractionAttribute(MorphologicalParse parse){
		super(parse.isFraction());
	}
}
