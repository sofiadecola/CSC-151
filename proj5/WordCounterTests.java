package proj5;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;

/**
 * @author Sofia DeCola
 * @version 6/1/23
 * I affirm I have followed the Union College Honor Code and CS Honor Code
 */
public class WordCounterTests {
    @Rule
    public Timeout timeout = Timeout.millis(100);
    private WordCounter w;

    @Before
    public void setUp() throws Exception {
        w = new WordCounter();
    }

    @After
    public void tearDown() throws Exception {
        w = null;
    }

    @Test
    public void testFindFrequenciesAndGetFrequencies(){
        w.findFrequencies("src/proj5/lamb.txt");
        assertEquals("Testing frequency of Mary", 6, w.getFrequency("Mary"));
        assertEquals("Frequency of lamb", 5, w.getFrequency("lamb"));
        assertEquals("Frequency of word not in file", 0, w.getFrequency("crazy"));
    }



}
