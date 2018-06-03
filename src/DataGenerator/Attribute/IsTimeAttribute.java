package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import Dictionary.Word;

public class IsTimeAttribute extends BinaryAttribute {

	public IsTimeAttribute(String surfaceForm){
		super(Word.isTime(surfaceForm));
	}
}
