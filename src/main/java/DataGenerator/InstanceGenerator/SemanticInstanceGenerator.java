package DataGenerator.InstanceGenerator;

import AnnotatedSentence.*;
import Classification.Instance.CompositeInstance;
import Classification.Instance.Instance;
import Corpus.Sentence;
import MorphologicalAnalysis.FsmMorphologicalAnalyzer;
import WordNet.*;

import java.util.ArrayList;

public abstract class SemanticInstanceGenerator extends SimpleWindowInstanceGenerator{

    private FsmMorphologicalAnalyzer fsm;
    private WordNet wordNet;

    /**
     * Constructor for the semantic instance generator. Takes morphological analyzer and wordnet as input to set the
     * corresponding variables.
     * @param fsm Morphological analyzer to be used.
     * @param wordNet Wordnet to be used.
     */
    public SemanticInstanceGenerator(FsmMorphologicalAnalyzer fsm, WordNet wordNet) {
        this.fsm = fsm;
        this.wordNet = wordNet;
    }

    /**
     * Generates a single classification instance of the WSD problem for the given word of the given sentence. If the
     * word has not been labeled with sense tag yet, the method returns null. In the WSD problem, the system also
     * generates and stores all possible sense labels for the current instance. In this case, a classification
     * instance will not have all labels in the dataset, but some subset of it.
     * @param sentence Input sentence.
     * @param wordIndex The index of the word in the sentence.
     * @return Classification instance.
     * @throws InstanceNotGenerated
     */
    public Instance generateInstanceFromSentence(Sentence sentence, int wordIndex) throws InstanceNotGenerated {
        try{
            ArrayList<SynSet> possibleSynSets = ((AnnotatedSentence) sentence).constructSynSets(wordNet, fsm, wordIndex);
            AnnotatedWord word = (AnnotatedWord) sentence.getWord(wordIndex);
            String classLabel = word.getSemantic();
            if (classLabel == null || possibleSynSets.size() == 0){
                return null;
            }
            CompositeInstance current = new CompositeInstance(classLabel);
            ArrayList<String> possibleClassLabels = new ArrayList<String>();
            for (SynSet synSet : possibleSynSets) {
                possibleClassLabels.add(synSet.getId());
            }
            current.setPossibleClassLabels(possibleClassLabels);
            addAttributes(current, sentence, wordIndex);
            return current;
        } catch (ParseRequiredException e){
            throw new InstanceNotGenerated(e.getWord());
        }
    }

}
