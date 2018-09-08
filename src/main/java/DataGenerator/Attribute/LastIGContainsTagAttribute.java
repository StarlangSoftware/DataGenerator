package DataGenerator.Attribute;

import Classification.Attribute.BinaryAttribute;
import MorphologicalAnalysis.MorphologicalParse;
import MorphologicalAnalysis.MorphologicalTag;

public class LastIGContainsTagAttribute extends BinaryAttribute {

    /**
     * Binary attribute for a given word. If the last inflectional group of the word contains tag,
     * the attribute will be "true", otherwise "false".
     * @param parse Morphological parse of the word.
     * @param tag Tag that is checked in the last inflectional group.
     */
    public LastIGContainsTagAttribute(MorphologicalParse parse, MorphologicalTag tag){
        super(parse.lastIGContainsTag(tag));
    }
}
