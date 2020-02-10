package DataGenerator.Attribute;
import MorphologicalAnalysis.MorphologicalParse;
import MorphologicalAnalysis.MorphologicalTag;

public class LastIGContainsTagAblativeAttribute extends LastIGContainsTagAttribute{

    /**
     * Binary attribute for a given word. If the last inflectional group of the word contains ABLATIVE tag,
     * the attribute will be "true", otherwise "false".
     * @param parse Morphological parse of the word.
     */
    public LastIGContainsTagAblativeAttribute(MorphologicalParse parse){
        super(parse, MorphologicalTag.ABLATIVE);
    }
}
