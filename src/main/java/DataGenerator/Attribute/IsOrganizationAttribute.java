package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import Dictionary.Word;

public class IsOrganizationAttribute extends BinaryAttribute {

	public IsOrganizationAttribute(String surfaceForm){
		super(Word.isOrganization(surfaceForm));
    }
}