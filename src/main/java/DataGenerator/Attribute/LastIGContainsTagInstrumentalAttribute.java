package DataGenerator.Attribute;

import MorphologicalAnalysis.MorphologicalParse;
import MorphologicalAnalysis.MorphologicalTag;

public class LastIGContainsTagInstrumentalAttribute extends LastIGContainsTagAttribute {

	public LastIGContainsTagInstrumentalAttribute(MorphologicalParse parse){
		super(parse, MorphologicalTag.INSTRUMENTAL);
	}
}
