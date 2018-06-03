package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;

public class IsCapitalAttribute extends BinaryAttribute {

    /**
     * Binary attribute for a given word. If the starting letter of the word is capital, the attribute will have
     * the value "true", otherwise "false".
     * @param surfaceForm Surface form of the word.
     */
    public IsCapitalAttribute(String surfaceForm){
        super(Character.isUpperCase(surfaceForm.charAt(0)));
    }
}
