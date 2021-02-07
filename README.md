## Attributes

1. CaseAttribute:  This is a discrete attribute for a given word. If the last inflectional group of the word contains case information, the attribute will have that case value. Otherwise the attribute will have the value null.
2. IsCapitalLetter: This a binary valued feature. Its value returns true}if the word starts with a capital letter, and  false otherwise. Words starting with a capital letter are proper nouns unless the word is not the first word in the sentence. Being proper noun is important for meaning because proper nouns do not have specific meanings. Being a proper noun can be important for Shallow Parse labeling because, for instance, if it is a name of a person, it is more probable for the word to be the subject or the object, rather than the adverbial clause or the predicate, of the sentence it occurs in. Yet such clues are not always reliable.
3. LastIGContainsPossessiveAttribute: This is a binary attribute for a given word. If the last inflectional group of the word contains possessive information, the attribute will be true, otherwise it will be false.
4. Main POS: This is a discrete valued feature. The value of the feature consists of the main part-of-speech (POS) tag of the word.
5. NerTag: This is a discrete valued feature, which finds the NER (Named Entity Recognition) tag of the word. This is a strong feature especially for detecting subjects and objects in the sentence. For Instance, if the word has a 'PERSON' NER tag, it is generally the subject or the object of the sentence.
6. Root Form: This is a discrete valued feature and stores the word's root as its value. A root is a word without any affixes. A word takes its meaning mainly from the root. Therefore, this features works well for words having different roots. But when it comes to different surface forms created from the same root, it fails. Both the surface form and the root of a word are directly connected to the sense of the word and these features are crucial for WSD.
7. RootPos Attribute: This attribute is a discrete attribute for a given word. It returns the part of speech of the root word.
8. Surface Form: This is a discrete valued feature and stores the word's itself as its value. It is a strong feature because the meaning of a word's root can be modified through affixation. In a word's surface form, the word is considered as a whole with all the affixes attached, and, when it is used as a feature, it matches with the corresponding meaning. 
9. ShallowTag: This is a discrete valued feature, which finds the Shallow Parse tag of the word.
10. IsPercentage: This is a discrete valued feature. It checks each character in the string. If the character equals to `%', it returns true, otherwise false.
11. IsDateAttribute: This is a binary attribute that checks whether a word is written in date format. If the word is in date format, it returns true, otherwise it returns false.
12. IsFractionAttribute: This is a binary attribute that checks whether a word is a fractional number. If the word is a fractional number, it returns true, otherwise it returns false.
13. IsHonorificAttribute: This is a binary attribute. It checks each word in a sentence. If the word equals to one of the titles 'bay', 'bayan', 'sayın', 'dr.', 'prof.' or 'doç.', it returns true, otherwise it returns false.
14. IsMoneyAttribute: This is a binary attribute. It checks whether a word in a sentence denotes a currency. If the word is 'doları', 'lirası' or 'avro', the attribute returns true, otherwise it returns false.
15. IsNumAttribute: This attribute checks whether the word has num (number) tag.
16. IsOrganizationAttribute: This is a binary attribute. It checks a given word and if it equals to 'corp', 'inc.', or 'co.', it returns true, otherwise it returns false.
17. IsPropAttribute: This attribute checks whether the word has prop (proper name) tag.
18. IsRealAttribute: This is a binary attribute that checks whether a word is a real number or not. If the word is a real number, it returns true, otherwise it returns false.
19. IsTimeAttribute: This is a binary attribute that checks whether a word is written in time format. If the word is in time format, it returns true, otherwise it returns false.
20. IsAdjective Attribute: This is a binary valued feature, that shows whether a word used as an adjective or not.
21. IsAuxillaryVerb Attribute: This is a binary valued feature, that checks whether the word is an auxiliary verb. This is another strong feature because it may be useful in identifying the word as (part of) a predicate ("yüklem").
22. IsIndirectObjectMoneyAttribute: This is a binary valued feature for a given word. If the word equals to "artarak" or "azalarak" and the named entity type of the word is "NONE", it returns true, otherwise false.
23. LastMorphTagAttribute: This is a discrete attribute which returns the morphological tag of the last inflectional group.
24. LastSyllable Attribute: This is a discrete valued feature, that finds the last 3 characters of the word, and it can be helpful in detecting suffixes.
25. LastIGContainsTagAblative Attribute: This is a binary valued feature, that checks whether the word is in ablative case or not.
26. LastIGContainsTagAccusative Attribute: This is a binary valued feature, that checks whether the word is in accusative case or not.
27. LastIGContainsTagGenitive Attribute: This is a binary valued feature, that checks whether the word is in genitive case or not.
28. LastIGContainsTagInstrumental Attribute: This is a binary valued feature, that checks whether the word is in instrumental case or not.

## Example Generated DataSet

### Word Sense Disambiguation Task

The following Table shows the sample text represented with sense labels and three possible features, namely the root form of the word, the part of speech (POS) tag of the word, and a boolean feature for checking the capital case.

|Word|Root|Pos|Capital|...|Tag|
|---|---|---|---|---|---|
|Yüzündeki|yüz|Noun|True|...|yüz<sup>3</sup>|
|ketçap|ketçap|Noun|False|...|ketçap<sup>1</sup>|
|lekesi|leke|Noun|False|...|leke<sup>2</sup>|
|yüzdükten|yüz|Verb|False|...|yüz<sup>2</sup>| 
|sonra|sonra|PCAbl|False|...|sonra<sup>1</sup>| 
|çıkmış|çık|Verb|False|...|çık<sup>10</sup>|
|.|.|Punctuation|False|...|.<sup>1</sup>|

### Named Entity Recognition Task

The following Table shows the sample text represented with tag labels and three possible features, namely the root form of the word, the part of speech (POS) tag of the word, and a boolean feature for checking the capital case.

|Word|Root|Pos|Capital|...|Tag|
|---|---|---|---|---|---|
|Türk|Türk|Noun|True|...|ORGANIZATION|
|Hava|Hava|Noun|True|...|ORGANIZATION|
|Yolları|Yol|Noun|True|...|ORGANIZATION|
|bu|bu|Pronoun|False|...|NONE|
|Pazartesi'den|Pazartesi|Noun|True|...|TIME|
|itibaren|itibaren|Adverb|False|...|NONE|
|İstanbul|İstanbul|Noun|True|...|LOCATION|
|Ankara|Ankara|Noun|True|...|LOCATION|
|güzergahı|güzergah|Noun|False|...|NONE|
|için|için|Adverb|False|...|NONE|
|indirimli|indirimli|Adjective|False|...|NONE|
|satışlarını|sat|Noun|False|...|NONE|
|90|90|Number|False|...|MONEY|
|TL'den|TL|Noun|True|...|MONEY|
|başlatacağını|başlat|Noun|False|...|NONE|
|açıkladı|açıkla|Verb|False|...|NONE|
|.|.|Punctuation|False|...|NONE|

### Shallow Parse Task

The following Table shows the sample text represented with chunk labels and three possible features, namely the root form of the word, the part of speech (POS) tag of the word, and a boolean feature for checking the capital case.

|Word|Root|Pos|Capital|...|Tag|
|---|---|---|---|---|---|
|Türk|Türk|Noun|True|...|ÖZNE|
|Hava|Hava|Noun|True|...|ÖZNE|
|Yolları|yol|Noun|True|...|ÖZNE|
|Salı|Salı|Noun|True|...|ZARF TÜMLECİ|
|günü|gün|Noun|False|...|ZARF TÜMLECİ|
|yeni|yeni|Adjective|False|...|NESNE|
|indirimli|indirimli|Adjective|False|...|NESNE|
|fiyatlarını|fiyat|Noun|False|...|NESNE|
|açıkladı|açıkla|Verb|False|...|YÜKLEM|
|.|.|Punctuation|False|...|HİÇBİRİ|

For Developers
============
You can also see [Python](https://github.com/starlangsoftware/DataGenerator-Py), [C++](https://github.com/starlangsoftware/DataGenerator-CPP),  or [C#](https://github.com/starlangsoftware/DataGenerator-CS) repository.

## Requirements

* [Java Development Kit 8 or higher](#java), Open JDK or Oracle JDK
* [Maven](#maven)
* [Git](#git)

### Java 

To check if you have a compatible version of Java installed, use the following command:

    java -version
    
If you don't have a compatible version, you can download either [Oracle JDK](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) or [OpenJDK](https://openjdk.java.net/install/)    

### Maven
To check if you have Maven installed, use the following command:

    mvn --version
    
To install Maven, you can follow the instructions [here](https://maven.apache.org/install.html).      

### Git

Install the [latest version of Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git).

## Download Code

In order to work on code, create a fork from GitHub page. 
Use Git for cloning the code to your local or below line for Ubuntu:

	git clone <your-fork-git-link>

A directory called DataGenerator will be created. Or you can use below link for exploring the code:

	git clone https://github.com/olcaytaner/DataGenerator.git

## Open project with IntelliJ IDEA

Steps for opening the cloned project:

* Start IDE
* Select **File | Open** from main menu
* Choose `DataGenerator/pom.xml` file
* Select open as project option
* Couple of seconds, dependencies with Maven will be downloaded. 


## Compile

**From IDE**

After being done with the downloading and Maven indexing, select **Build Project** option from **Build** menu. After compilation process, user can run DataGenerator.

**From Console**

Go to `DataGenerator` directory and compile with 

     mvn compile 

## Generating jar files

**From IDE**

Use `package` of 'Lifecycle' from maven window on the right and from `DataGenerator` root module.

**From Console**

Use below line to generate jar file:

     mvn install

## Maven Usage

        <dependency>
            <groupId>io.github.starlangsoftware</groupId>
            <artifactId>DataGenerator</artifactId>
            <version>1.0.4</version>
        </dependency>

## Cite
If you use this resource on your research, please cite the following paper: 

```
@article{acikgoz,
  title={All-words word sense disambiguation for {T}urkish},
  author={O. Açıkg{\"o}z and A. T. G{\"u}rkan and B. Ertopçu and O. Topsakal and B. {\"O}zenç and A. B. Kanburoğlu and {\.{I}}. Çam and B. Avar and G. Ercan and O. T. Y{\i}ld{\i}z},
  journal={2017 International Conference on Computer Science and Engineering (UBMK)},
  year={2017},
  pages={490-495}
}
@inproceedings{ertopcu17,  
	author={B. {Ertopçu} and A. B. {Kanburoğlu} and O. {Topsakal} and O. {Açıkgöz} and A. T. {Gürkan} and B. {Özenç} and İ. {Çam} and B. {Avar} and G. {Ercan} and O. T. {Yıldız}},  
	booktitle={2017 International Conference on Computer Science and Engineering (UBMK)},  title={A new approach for named entity recognition},   
	year={2017},  
	pages={474-479}
}
