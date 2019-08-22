package DataGenerator.InstanceGenerator;

import Classification.Attribute.*;
import Classification.Instance.Instance;
import Corpus.Sentence;
import AnnotatedSentence.AnnotatedWord;
import DataGenerator.Attribute.*;
import MorphologicalAnalysis.FsmMorphologicalAnalyzer;
import MorphologicalAnalysis.MorphologicalParse;
import WordNet.*;

public class FeaturedSemanticInstanceGenerator extends SemanticInstanceGenerator{

    /**
     * Constructor method. Gets input window size and sets the corresponding variable.
     * @param fsm Morphological analyzer to be used.
     * @param wordNet Wordnet to be used.
     * @param windowSize Number of previous (next) words to be considered in adding attributes.
     */
    public FeaturedSemanticInstanceGenerator(FsmMorphologicalAnalyzer fsm, WordNet wordNet, int windowSize) {
        super(fsm, wordNet);
        this.windowSize = windowSize;
    }

    /**
     * Abstract function for adding attributes to the word sense disambiguation problem. Depending on your design
     * you can add as many attributes as possible. The number of attributes in this function should be equal to the
     * number of attributes in the function addAttributesForEmptyWords.
     * @param current Current classification instance
     * @param sentence Input sentence.
     * @param wordIndex The index of the word in the sentence.
     */
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
        current.addAttribute(new IsMoneyAttribute(word.getName()));
        current.addAttribute(new IsNumberAttribute(parse));
        current.addAttribute(new IsOrganizationAttribute(word.getName()));

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

    /**
     * Abstract function for adding attributes for empty words to the word sense disambiguation problem. The number of
     * attributes in this function should be equal to the number of attributes in the function
     * addAttributesForWords.
     * @param current Current classification instance
     * @param emptyWord String form to place for empty words.
     */
    protected void addAttributesForEmptyWords(Instance current, String emptyWord){
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
