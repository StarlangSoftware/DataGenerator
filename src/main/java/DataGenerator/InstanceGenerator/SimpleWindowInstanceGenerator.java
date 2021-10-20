package DataGenerator.InstanceGenerator;

import AnnotatedSentence.LayerNotExistsException;
import Classification.Instance.Instance;
import Corpus.Sentence;

public abstract class SimpleWindowInstanceGenerator extends InstanceGenerator{

    protected abstract void addAttributesForWords(Instance current, Sentence sentence, int wordIndex) throws WordNotExistsInDictionary, LayerNotExistsException, InstanceNotGenerated;
    protected abstract void addAttributesForEmptyWords(Instance current, String emptyWord) throws WordNotExistsInDictionary;

    /**
     * addAttributes adds all attributes of the previous words, the current wordn, and next words of the given word
     * to the given instance. If the previous or next words does not exists, the method calls
     * addAttributesForEmptyWords method. If the word does not exists in the dictionary or the required annotation layer
     * does not exists in the annotated word, the method throws InstanceNotGenerated. The window size determines the
     * number of previous and next words.
     * @param current Current classification instance to which attributes will be added.
     * @param sentence Input sentence.
     * @param wordIndex The index of the word in the sentence.
     * @throws InstanceNotGenerated If attributes can not be added, throws InstanceNotGenerated.
     */
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
