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
        current.addAttribute(new IsAdjectiveAttribute(parse));
        current.addAttribute(new IsAuxiliaryVerbAttribute(parse));
        current.addAttribute(new IsCapitalAttribute(word.getName()));
        current.addAttribute(new IsDateAttribute(parse));
        current.addAttribute(new IsFractionAttribute(parse));

        current.addAttribute(new IsHonorificAttribute(word.getName()));
        current.addAttribute(new IsLocationGazetteer(word.getName()));
        current.addAttribute(new IsMoneyAttribute(word.getName()));
        current.addAttribute(new IsNumberAttribute(parse));
        current.addAttribute(new IsOrganizationAttribute(word.getName()));

        current.addAttribute(new IsOrganizationGazetteer(word.getName()));
        current.addAttribute(new IsPersonGazetteer(word.getName()));
        current.addAttribute(new IsProperNounAttribute(parse));
        current.addAttribute(new IsRealAttribute(parse));
        current.addAttribute(new IsTimeAttribute(word.getName()));

        current.addAttribute(new LastIGContainsPossessiveAttribute(parse));
        current.addAttribute(new LastIGContainsTagAblaviateAttribute(parse));
        current.addAttribute(new LastIGContainsTagAccusativeAttribute(parse));
        current.addAttribute(new LastIGContainsTagGenitiveAttribute(parse));
        current.addAttribute(new LastIGContainsTagInstrumentalAttribute(parse));

        current.addAttribute(new MainPosAttribute(parse));
        current.addAttribute(new Predicate(sentence, wordIndex));
        current.addAttribute(new RootPosAttribute(parse));
        current.addAttribute(new RootFormAttribute(parse));
        current.addAttribute(new CaseAttribute(parse));
    }

    protected void addAttributesForEmptyWords(Instance current, String emptyWord) {
        current.addAttribute(new BinaryAttribute(false));
        current.addAttribute(new BinaryAttribute(false));
        current.addAttribute(new BinaryAttribute(false));
        current.addAttribute(new BinaryAttribute(false));
        current.addAttribute(new BinaryAttribute(false));

        current.addAttribute(new BinaryAttribute(false));
        current.addAttribute(new BinaryAttribute(false));
        current.addAttribute(new BinaryAttribute(false));
        current.addAttribute(new BinaryAttribute(false));
        current.addAttribute(new BinaryAttribute(false));

        current.addAttribute(new BinaryAttribute(false));
        current.addAttribute(new BinaryAttribute(false));
        current.addAttribute(new BinaryAttribute(false));
        current.addAttribute(new BinaryAttribute(false));
        current.addAttribute(new BinaryAttribute(false));

        current.addAttribute(new BinaryAttribute(false));
        current.addAttribute(new BinaryAttribute(false));
        current.addAttribute(new BinaryAttribute(false));
        current.addAttribute(new BinaryAttribute(false));
        current.addAttribute(new BinaryAttribute(false));

        current.addAttribute(new DiscreteAttribute("NULL"));
        current.addAttribute(new DiscreteAttribute("NULL"));
        current.addAttribute(new DiscreteAttribute("NULL"));
        current.addAttribute(new DiscreteAttribute("NULL"));
        current.addAttribute(new DiscreteAttribute("NULL"));
    }

}
