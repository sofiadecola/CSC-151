package proj5;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Sofia DeCola
 * @version 6/1/23
 *  * I affirm I have followed the Union College Honor Code and CS Honor Code
 */
public class ThesaurusEntryTests {

    private ThesaurusEntry t;

    @Before
    public void setUp() throws Exception {
        String[] s = new String[1];
        s[0] = "excited";
        t = new ThesaurusEntry("happy", s);
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Rule
    public Timeout timeout = Timeout.millis(100);


    @Test
    public void testGetRandomSynonymAndGetKey(){
        assertEquals("After constructor is initialized, calling getKey", "happy", t.getKey());
        assertTrue("Making sure getKey returns a string from constructor", t.getKey() != null);
        assertEquals("After constructor is initialized, calling for a random synonym", "excited", t.getRandomSynonym());
    }

    @Test
    public void testAddSynonyms(){
        String[] s1 = new String[2];
        s1[0] = "joyful";
        s1[1] = "ecstatic";
        assertEquals("Synonyms in an entry before adding", 1, t.getSynonyms().length);
        t.addSynonyms(s1);
        assertEquals("Synonyms in an entry after adding", 3, t.getSynonyms().length );

    }

    @Test
    public void testToString(){
        String[] s1 = new String[2];
        s1[0] = "joyful";
        s1[1] = "ecstatic";
        assertEquals("Thesaurus entry toString after constructor", "happy - {excited}\n", t.toString());
        t.addSynonyms(s1);
        assertEquals("After adding two synonyms", "happy - {excited, joyful, ecstatic}\n", t.toString());
    }

    @Test
    public void testCompareTo(){
        String[] s = new String[1];
        s[0] = "excited";
        ThesaurusEntry t1 = new ThesaurusEntry("happy", s);
        String[] s1 = new String[2];
        s1[0] = "upset";
        s1[1] = "depressed";
        ThesaurusEntry t2 = new ThesaurusEntry("sad", s1);
        assertEquals("comparing thesaurus entries based off of entry key", -11, t1.compareTo(t2));
        assertEquals("comparing thesaurus entries based off of entry key", 11, t2.compareTo(t1));

    }
}
