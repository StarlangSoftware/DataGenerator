package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import Dictionary.Word;

public class IsHonorificAttribute extends BinaryAttribute {

	public IsHonorificAttribute(String surfaceForm){
		super(Word.isHonorific(surfaceForm));
    }
}
