package DataGenerator.Attribute;

import MorphologicalAnalysis.MorphologicalParse;
import MorphologicalAnalysis.MorphologicalTag;

public class LastIGContainsTagAccusativeAttribute extends LastIGContainsTagAttribute {

	public LastIGContainsTagAccusativeAttribute(MorphologicalParse parse){
		super(parse, MorphologicalTag.ACCUSATIVE);
	}
}
