package DataGenerator.CorpusGenerator;

import MorphologicalDisambiguation.DisambiguationCorpus;
import org.junit.Test;

import static org.junit.Assert.*;

public class SentenceDisambiguationCorpusGeneratorTest {

    @Test
    public void testGenerate() {
        SentenceDisambiguationCorpusGenerator sentenceDisambiguationCorpusGenerator = new SentenceDisambiguationCorpusGenerator("sentences/", ".dev");
        DisambiguationCorpus disambiguationCorpus = sentenceDisambiguationCorpusGenerator.generate();
        assertEquals(10, disambiguationCorpus.sentenceCount());
        assertEquals(101, disambiguationCorpus.numberOfWords());
        assertEquals(14, disambiguationCorpus.maxSentenceLength());
    }
}