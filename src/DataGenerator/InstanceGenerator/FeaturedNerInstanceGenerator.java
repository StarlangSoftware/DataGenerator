package DataGenerator.InstanceGenerator;

import Classification.Attribute.*;
import Classification.Instance.Instance;
import Corpus.Sentence;
import AnnotatedSentence.AnnotatedWord;
import DataGenerator.Attribute.*;
import MorphologicalAnalysis.MorphologicalParse;

public class FeaturedNerInstanceGenerator extends NerInstanceGenerator{

    public FeaturedNerInstanceGenerator(int windowSize) {
        this.windowSize = windowSize;
    }

    protected void addAttributesForWords(Instance current, Sentence sentence, int wordIndex) throws InstanceNotGenerated {
        MorphologicalParse parse;
        AnnotatedWord word;
        word = (AnnotatedWord) sentence.getWord(wordIndex);
        parse = word.getParse();
        if (parse == null){
            throw new InstanceNotGenerated(word.getName());
        }
        current.addAttribute(new RootPosAttribute(parse));
        current.addAttribute(new MainPosAttribute(parse));
        current.addAttribute(new CaseAttribute(parse));
        current.addAttribute(new LastIGContainsPossessiveAttribute(parse));
        current.addAttribute(new IsCapitalAttribute(word.getName()));
    }

    protected void addAttributesForEmptyWords(Instance current, String emptyWord) {
        current.addAttribute(new DiscreteAttribute("NULL"));
        current.addAttribute(new DiscreteAttribute("NULL"));
        current.addAttribute(new DiscreteAttribute("NULL"));
        current.addAttribute(new BinaryAttribute(false));
        current.addAttribute(new BinaryAttribute(false));
    }

}
