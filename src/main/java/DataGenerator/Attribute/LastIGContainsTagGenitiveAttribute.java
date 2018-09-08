package DataGenerator.Attribute;

import MorphologicalAnalysis.MorphologicalParse;
import MorphologicalAnalysis.MorphologicalTag;

public class LastIGContainsTagGenitiveAttribute extends LastIGContainsTagAttribute {

	public LastIGContainsTagGenitiveAttribute(MorphologicalParse parse){
		super(parse, MorphologicalTag.GENITIVE);
	}
}
