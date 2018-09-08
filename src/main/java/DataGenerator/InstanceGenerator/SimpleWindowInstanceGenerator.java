package DataGenerator.InstanceGenerator;

import AnnotatedSentence.LayerNotExistsException;
import Classification.Instance.Instance;
import Corpus.Sentence;

public abstract class SimpleWindowInstanceGenerator extends InstanceGenerator{

    protected abstract void addAttributesForWords(Instance current, Sentence sentence, int wordIndex) throws WordNotExistsInDictionary, LayerNotExistsException, InstanceNotGenerated;
    protected abstract void addAttributesForEmptyWords(Instance current, String emptyWord) throws WordNotExistsInDictionary;

    protected void addAttributes(Instance current, Sentence sentence, int wordIndex) throws InstanceNotGenerated {
        try{
            for (int i = 0; i < windowSize; i++){
                if (wordIndex - windowSize + i >= 0){
                    addAttributesForWords(current, sentence, wordIndex - windowSize + i);
                } else {
                    addAttributesForEmptyWords(current, "<s>");
                }
            }
            addAttributesForWords(current, sentence, wordIndex);
            for (int i = 0; i < windowSize; i++){
                if (wordIndex + i + 1 < sentence.wordCount()){
                    addAttributesForWords(current, sentence, wordIndex + i + 1);
                } else {
                    addAttributesForEmptyWords(current, "</s>");
                }
            }
        } catch (WordNotExistsInDictionary e){
            throw new InstanceNotGenerated(e.getWord());
        } catch (LayerNotExistsException e){
            throw new InstanceNotGenerated("Layer not exists");
        }
    }

}
