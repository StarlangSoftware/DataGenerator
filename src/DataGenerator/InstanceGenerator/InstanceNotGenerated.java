package DataGenerator.InstanceGenerator;

import Dictionary.Word;

public class InstanceNotGenerated extends Exception{

    private String word;

    public InstanceNotGenerated(String word){
        this.word = word;
    }

    public String toString(){
        return "Can not generate dataset instance for word " + word;
    }

}
