package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import Dictionary.Word;

public class IsOrganizationAttribute extends BinaryAttribute {

	/**
	 * Binary attribute for a given word. If the word is "corp.", "inc." or "co.", the attribute will have the
	 * value "true", otherwise "false".
	 * @param surfaceForm Surface form of the word.
	 */
	public IsOrganizationAttribute(String surfaceForm){
		super(Word.isOrganization(surfaceForm));
    }
}