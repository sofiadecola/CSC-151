package proj5;

/**
 * Generic BSTNode Class
 * @author Chris Fernandes
 * modified by Sofia DeCola to be Generic
 * I affirm I have followed the Union College Honor Code and CS Honor Code
 * @version 2/21/18
 */
public class BSTNode<G extends Comparable<G>> {

    public G key;
    public BSTNode<G> llink;
    public BSTNode<G> rlink;

    /**
     * non-default constructor
     * @param newKey string that node will hold
     */
    public BSTNode(G newKey)
    {
        key = newKey;
        llink = null;
        rlink = null;
    }

    /**
     * returns key as printable string
     */
    public String toString()
    {
        return key.toString();
    }


    /**
     *
     * @return true if this node is a leaf, else false
     */
    public boolean isLeaf() {
        return this.llink == null && this.rlink == null;
    }

    /**
     *
     * @return true if this node has a non-null right subtree
     * and a null left subtree, else false
     */
    public boolean hasRightChildOnly() {
        return this.llink == null && this.rlink != null;
    }

    /**
     *
     * @return true if this node has a non-null left subtree
     * and a null right subtree, else false
     */
    public boolean hasLeftChildOnly() {
        return this.llink != null && this.rlink == null;
    }


    /**
     * @return key associated with BSTNode
     */
    public G getKey(){
        return key;
    }

}

