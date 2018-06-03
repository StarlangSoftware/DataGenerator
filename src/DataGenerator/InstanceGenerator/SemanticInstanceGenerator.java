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

    public SemanticInstanceGenerator(FsmMorphologicalAnalyzer fsm, WordNet wordNet) {
        this.fsm = fsm;
        this.wordNet = wordNet;
    }

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
