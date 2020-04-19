# DataGenerator

## Tasks

### Word Sense Disambiguation Task
The task of choosing the correct sense for a word is called word sense disambiguation (WSD). WSD algorithms take an input word *w* in its context with a fixed set of potential word senses S<sub>w</sub> of that input word and produce an output chosen from S<sub>w</sub>. In the isolated WSD task, one usually uses the set of senses from a dictionary or theasurus like WordNet. 

In the literature, there are actually two variants of the generic WSD task. In the lexical sample task, a small selected set of target words is chosen, along with a set of senses for each target word. For each target word *w*, a number of corpus sentences (context sentences) are manually labeled with the correct sense of *w*. In all-words task, systems are given entire sentences and a lexicon with the set of senses for each word in each sentence. Annotators are then asked to disambiguate every word in the text.

In all-words WSD, a classifier is trained to label the words in the text with their set of potential word senses. After giving the sense labels to the words in our training data, the next step is to select a group of features to discriminate different senses for each input word.

The following Table shows an example for the word 'yüz', which can refer to the number '100', to the verb 'swim' or to the noun 'face'.

|Sense|Definition|
|---|---|
|yüz<sup>1</sup> (hundred)|The number coming after ninety nine|
|yüz<sup>2</sup> (swim)|move or float in water|
|yüz<sup>3</sup> (face)|face, visage, countenance|


### Named Entity Recognition Task
In named entity recognition, one tries to find the strings within a text that correspond to proper names (excluding TIME and MONEY) and classify the type of entity denoted by these strings. The problem is difficult partly due to the ambiguity in sentence segmentation; one needs to extract which words belong to a named entity, and which not. Another difficulty occurs when some word may be used as a name of either a person, an organization or a location. For example, Deniz may be used as the name of a person, or - within a compound - it can refer to a location Marmara Denizi 'Marmara Sea', or an organization Deniz Taşımacılık 'Deniz Transportation'.

The standard approach for NER is a word-by-word classification, where the classifier is trained to label the words in the text with tags that indicate the presence of particular kinds of named entities. After giving the class labels (named entity tags) to our training data, the next step is to select a group of features to discriminate different named entities for each input word.

[<sub>ORG</sub> Türk Hava Yolları] bu [<sub>TIME</sub> Pazartesi'den] itibaren [<sub>LOC</sub> İstanbul] [<sub>LOC</sub> Ankara] hattı için indirimli satışlarını [<sub>MONEY</sub> 90 TL'den] başlatacağını açıkladı.

[<sub>ORG</sub> Turkish Airlines] announced that from this [<sub>TIME</sub> Monday] on it will start its discounted fares of [<sub>MONEY</sub> 90TL] for [<sub>LOC</sub> İstanbul] [<sub>LOC</sub> Ankara] route.

See the Table below for typical generic named entity types.

|Tag|Sample Categories|
|---|---|
|PERSON|people, characters|
|ORGANIZATION|companies, teams|
|LOCATION|regions, mountains, seas|
|TIME|time expressions|
|MONEY|monetarial expressions|

### Shallow Parse Task

Many language processing tasks do not require complex parse trees. Instead, a partial parse, or a shallow parse of a sentence is sufficient. Shallow parsing is the process of identifying flat non-overlapping parts of a sentence. These parts typically include Özne, Yüklem, Nesne, Zarf Tümleci, and Dolaylı Tümleç. Since a parsed text does not include a hierarchical structure, a bracketing notation is sufficient to denote the location and the type of shallow parse chunks in a sentence. 

In shallow parsing, one tries to find the strings of text that belong to a chunk and to classify the type of that chunk. Standard approach for shallow parsing is a word-by-word classification, where the classifier is trained to label the words in the text with tags that indicate the presence of particular chunks. After giving the class labels to our training data chunk labels, the next step is to select a group of features to discriminate different chunks for each input word.

[<sub>OZNE</sub> Türk Hava Yolları] [<sub>ZARF TÜMLECİ</sub> Salı günü] [<sub>NESNE</sub> yeni indirimli fiyatlarını] [<sub>YÜKLEM</sub> açıkladı]

[<sub>SUBJECT</sub> Turkish Airlines] [<sub>PREDICATE</sub> announced] [<sub>OBJECT</sub> new discounted fares] [<sub>ADVERBIAL CLAUSE</sub> on Tuesday]  

The Table below shows typical shallow parse tags and the questions asked to the predicate to identify the chunks for those tags.
 
|Tag|Question|
|---|---|
|ÖZNE|Who, What|
|ZARF TÜMLECİ|When, How, Why|
|DOLAYLI TÜMLEÇ|Where, To/From whom|
|NESNE|What, Whom|
|YÜKLEM|Predicate|

### Semantic Role Labeling Task

Semantic Role Labeling (SRL) is a well-defined task where the objective is to analyze propositions expressed by the verb. In SRL, each word that bears a semantic role in the sentence has to be identified. There are different types of arguments (also called ’thematic roles’) such as Agent, Patient, Instrument, and also of adjuncts, such as Locative, Temporal, Manner, and Cause. These arguments and adjuncts represent entities participating in the event and give information about the event characteristics.

In the field of SRL, PropBank is one of the studies widely recognized by the computational linguistics communities. PropBank is the bank of propositions where predicate- argument information of the corpora is annotated, and the semantic roles or arguments that each verb can take are posited.

Each verb has a frame file, which contains arguments applicable to that verb. Frame files may include more than one roleset with respect to the senses of the given verb. In the roleset of a verb sense, argument labels Arg0 to Arg5 are described according to the meaning of the verb. For the example below, the predicate is “announce” from PropBank, Arg0 is “announcer”, Arg1 is “entity announced”, and ArgM- TMP is “time attribute”.

[<sub>ARG0</sub> Türk Hava Yolları] [<sub>ARG1</sub> indirimli satışlarını] [<sub>ARGM-TMP</sub> bu Pazartesi] [<sub>PREDICATE</sub> açıkladı].

[<sub>ARG0</sub> Turkish Airlines] [<sub>PREDICATE</sub> announced] [<sub>ARG1</sub> its discounted fares] [<sub>ARGM-TMP</sub> this Monday].

The following Table shows typical semantic role types. Only Arg0 and Arg1 indicate the same thematic roles across different verbs: Arg0 stands for the Agent or Causer and Arg1 is the Patient or Theme. The rest of the thematic roles can vary across different verbs. They can stand for Instrument, Start point, End point, Beneficiary, or Attribute. Moreover, PropBank uses ArgM’s as modifier labels indicating time, location, temporal, goal, cause etc., where the role is not specific to a single verb group; it generalizes over the entire corpus instead.

|Tag|Meaning|
|---|---|
|Arg0|Agent or Causer|
|ArgM-EXT|Extent|
|Arg1|Patient or Theme|
|ArgM-LOC|Locatives|
|Arg2|Instrument, start point, end point, beneficiary, or attribute|
|ArgM-CAU|Cause|
|ArgM-MNR|Manner|
|ArgM-DIS|Discourse|
|ArgM-ADV|Adverbials|
|ArgM-DIR|Directionals|
|ArgM-PNC|Purpose|
|ArgM-TMP|Temporals|

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


------------------------------------------------

Detailed Description
============
+ [AnnotatedDataSetGenerator](#annotateddatasetgenerator)
+ [InstanceGenerator](#instancegenerator)

## AnnotatedDataSetGenerator

DataSet yaratmak için AnnotatedDataSetGenerator sınıfı önce üretilir.

	AnnotatedDataSetGenerator(String directory, String pattern, InstanceGenerator instanceGenerator)

Ardından generate metodu ile DataSet yaratılır.

	DataSet generate()

## InstanceGenerator

DataGeneratorlerin InstanceGeneratorlere ihtiyacı vardır. Bunlar bir tek kelimeden bir 
Instance yaratan sınıflardır.

	Instance generateInstanceFromSentence(Sentence sentence, int wordIndex)

NER problemi için NerInstanceGenerator, FeaturedNerInstanceGenerator ve 
VectorizedNerInstanceGeneratorsınıfı

ShallowParse problemi için ShallowParseInstanceGenerator, 
FeaturedShallowParseInstanceGenerator ve VectorizedShallowParseInstanceGenerator sınıfı

WSD problemi için SemanticInstanceGenerator, FeaturedSemanticInstanceGenerator ve
VectorizedSemanticInstanceGenerator sınıfı

Morphological Disambiguation problemi için FeaturedDisambiguationInstanceGenerator sınıfı

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
