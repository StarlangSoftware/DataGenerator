package DataGenerator.InstanceGenerator;

public class WordNotExistsInDictionary extends Exception{
    private String word;

    public WordNotExistsInDictionary(String word){
        this.word = word;
    }

    public String getWord(){
        return word;
    }

    public String toString(){
        return "Word " + word + " does not exist in the dictionary";
    }

}
