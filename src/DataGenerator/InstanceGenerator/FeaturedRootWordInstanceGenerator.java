package DataGenerator.InstanceGenerator;

import Classification.Attribute.BinaryAttribute;
import Classification.Attribute.DiscreteAttribute;
import DataGenerator.Attribute.IsCapitalAttribute;
import DataGenerator.Attribute.MainPosAttribute;
import Classification.Instance.Instance;
import Corpus.Sentence;
import AnnotatedSentence.AnnotatedWord;
import MorphologicalAnalysis.MorphologicalParse;

public class FeaturedRootWordInstanceGenerator extends RootWordInstanceGenerator{

    public FeaturedRootWordInstanceGenerator(int windowSize) {
        this.windowSize = windowSize;
    }

    protected void addAttributesForPreviousWords(Instance current, Sentence sentence, int wordIndex) {
        MorphologicalParse parse;
        AnnotatedWord word;
        word = (AnnotatedWord) sentence.getWord(wordIndex);
        parse = word.getParse();
        current.addAttribute(new MainPosAttribute(parse));
        current.addAttribute(new IsCapitalAttribute(word.getName()));
    }

    protected void addAttributesForEmptyWords(Instance current, String emptyWord) {
        current.addAttribute(new DiscreteAttribute("NULL"));
        current.addAttribute(new BinaryAttribute(false));
    }
}
