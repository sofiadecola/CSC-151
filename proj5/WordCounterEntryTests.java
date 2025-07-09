package proj5;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * @author Sofia DeCola
 * @version 6/1/23
 * I affirm I have followed the Union College Honor Code and CS Honor Code
 */
public class WordCounterEntryTests {
    @Rule
    public Timeout timeout = Timeout.millis(100);

    @Test
    public void testGetWordEntryAndFrequencyFromConstructor(){
        WordCounterEntry w = new WordCounterEntry("hello");
        assertEquals("Constructor created, initialized key to \"hello\"", "hello", w.getWordEntry());
        assertEquals("Constructor created, checking initial frequency", 1, w.getFrequency());
    }

    @Test
    public void testIncreaseFrequency(){
        WordCounterEntry w = new WordCounterEntry("hello");
        assertEquals("Constructor created, checking initial frequency", 1, w.getFrequency());
        w.increaseFrequency();
        assertEquals("Increased frequency one time", 2, w.getFrequency());
    }


    @Test
    public void testToString(){
        WordCounterEntry w = new WordCounterEntry("hello");
        assertEquals("Constructor created, testing toString", "hello: 1\n", w.toString());
        w.increaseFrequency();
        assertEquals("Increased frequency once", "hello: 2\n", w.toString());
    }

    @Test
    public void testCompareTo(){
        WordCounterEntry w1 = new WordCounterEntry("alpha");
        WordCounterEntry w2 = new WordCounterEntry("bravo");
        assertEquals("Two different WordCounterEntries, alpha compared to bravo, compared lexicographically", -1, w1.compareTo(w2));
        assertEquals("Two different WordCounterEntries, bravo compared to alpha, compared lexicographically", 1, w2.compareTo(w1));
        WordCounterEntry w3 = new WordCounterEntry("hello");
        WordCounterEntry w4 = new WordCounterEntry("hello");
        assertEquals("Two different WordCounterEntries with same word", 0, w3.compareTo(w4));
        assertEquals("One WordCounterEntry compared to itself", 0, w3.compareTo(w3));
    }



}
