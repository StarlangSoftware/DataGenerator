package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import Dictionary.Word;

public class IsMoneyAttribute extends BinaryAttribute {

	public IsMoneyAttribute(String surfaceForm){
        super(Word.isMoney(surfaceForm));
    }
}
