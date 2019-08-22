package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import Dictionary.Word;

public class IsHonorificAttribute extends BinaryAttribute {

	/**
	 * Binary attribute for a given word. If the word is "bay" or "bayan", the attribute will have the value "true",
	 * otherwise "false".
	 * @param surfaceForm Surface form of the word.
	 */
	public IsHonorificAttribute(String surfaceForm){
		super(Word.isHonorific(surfaceForm));
    }
}
