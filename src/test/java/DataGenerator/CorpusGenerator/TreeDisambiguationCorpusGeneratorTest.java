package DataGenerator.CorpusGenerator;

import Corpus.DisambiguationCorpus;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreeDisambiguationCorpusGeneratorTest {

    @Test
    public void testGenerate() {
        TreeDisambiguationCorpusGenerator treeDisambiguationCorpusGenerator = new TreeDisambiguationCorpusGenerator("trees/", ".dev");
        DisambiguationCorpus disambiguationCorpus = treeDisambiguationCorpusGenerator.generate();
        assertEquals(10, disambiguationCorpus.sentenceCount());
        assertEquals(88, disambiguationCorpus.numberOfWords());
        assertEquals(13, disambiguationCorpus.maxSentenceLength());
    }
}