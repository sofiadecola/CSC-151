package hwk2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * @author (your name)
 * @version (a version number or a date)
 */
public class BSTTests {


    @Rule
    public Timeout timeout = Timeout.millis(100);

    private BinarySearchTree tree;

    @Before
    public void setUp() throws Exception {
        tree = new BinarySearchTree();
    }

    @After
    public void tearDown() throws Exception {
        tree = null;
    }

    @Test
    public void testTreeConstructor_toString() {
        assertEquals("An empty BST.", "", tree.toString());
    }

    @Test
    public void testTreeConstructor_size() {
        assertEquals("An empty BST, size should be 0", 0, tree.size());
    }

    @Test
    public void testTreeConstructor_height() {
        assertEquals("An empty BST, height should be -1", -1, tree.height());
    }

    @Test
    public void testTreeInsertOnce() {
        tree.insert("Fred");
        assertEquals("A tree with just one node", "(  Fred  )", tree.toString());
        assertEquals("A tree with just one node, size = 1", 1, tree.size());
        assertEquals("A tree with just one node, height = 0", 0, tree.height());
    }
}
