package DataGenerator.Attribute;
import MorphologicalAnalysis.MorphologicalParse;
import MorphologicalAnalysis.MorphologicalTag;

public class LastIGContainsTagAblaviateAttribute extends LastIGContainsTagAttribute{

	public LastIGContainsTagAblaviateAttribute(MorphologicalParse parse){
		super(parse, MorphologicalTag.ABLATIVE);
	}
}
