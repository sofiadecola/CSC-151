package proj5;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * @author Sofia DeCola
 * @version 6/1/23
 *  * I affirm I have followed the Union College Honor Code and CS Honor Code
 */
public class ThesaurusTests {

    @Rule
    public Timeout timeout = Timeout.millis(100);

    private Thesaurus t;

    @Before
    public void setUp() throws Exception {
        t = new Thesaurus("src/proj5/smallThesaurus.txt");
    }

    @After
    public void tearDown() throws Exception {
        t = null;
    }

    @Test
    public void testInsertAndHasEntry(){
        String[] syns = new String[2];
        syns[0] = "great";
        syns[1] = "awesome";
        t.insert("good", syns);
        assertTrue("Testing if thesaurus has newly entered entry", t.hasEntry("good"));
        assertFalse("Testing if entry not inserted and not in file is in thesaurus", t.hasEntry("spectacular"));

    }

    @Test
    public void testDeleteAndHasEntry(){
        assertTrue("Testing if thesaurus has an entry in file before deletion", t.hasEntry("little"));
        t.delete("little");
        assertFalse("Testing if thesaurus has an entry in file after deletion", t.hasEntry("little"));
        assertFalse("Before deleting a nonexistent entry", t.hasEntry("extreme"));
        t.delete("extreme");
        assertFalse("After deleting a nonexistent entry", t.hasEntry("extreme"));
    }







}
