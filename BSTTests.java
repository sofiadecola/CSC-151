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
public class BSTTests {


    @Rule
    public Timeout timeout = Timeout.millis(100);

    private BinarySearchTree<String> tree;

    @Before
    public void setUp() throws Exception {
        tree = new BinarySearchTree<String>();
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
        assertEquals("A tree with just one node", "Fred", tree.toString());
        assertEquals("A tree with just one node, size = 1", 1, tree.size());
        assertEquals("A tree with just one node, height = 0", 0, tree.height());
    }

    @Test
    public void testTreeSearch(){
        tree.insert("hello");
        tree.insert("greetings");
        assertEquals("Tree with two nodes", 2, tree.size());
    }

    @Test
    public void testTreeContains(){
        tree.insert("hello");
        assertTrue("A tree with one node, \" hello \"", tree.contains("hello"));
        tree.insert("goodbye");
        assertFalse("Checking if in tree, misspelled word, but word is in tree", tree.contains("goodbyw"));
        assertTrue("Added a node, checking if contained", tree.contains("goodbye"));
        assertFalse("Checking for nonexistent word", tree.contains("slay"));
    }

    @Test
    public void testTreeHeight(){
    tree.insert("b");
    tree.insert("a");
    tree.insert("c");
    assertEquals("Balanced tree, checking height", 1, tree.height());
    tree.insert("d");
    tree.insert("z");
    assertEquals("Unbalanced tree, checking new height of longest branch", 3, tree.height());

    }
    @Test
    public void testTreeDelete(){
        tree.insert("b");
        tree.insert("a");
        tree.insert("c");
        assertTrue("Seeing if tree contains \"a\"", tree.contains("a"));
        tree.delete("a");
        assertFalse("Seeing if tree contains \"a\" after deleting", tree.contains("a"));
    }
}
