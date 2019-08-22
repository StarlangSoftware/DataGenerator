package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import Dictionary.Word;

public class IsTimeAttribute extends BinaryAttribute {

	/**
	 * Binary attribute for a given word. If the word represents a time form, the attribute will have the
	 * value "true", otherwise "false".
	 * @param surfaceForm Surface form of the word.
	 */
	public IsTimeAttribute(String surfaceForm){
		super(Word.isTime(surfaceForm));
	}
}
