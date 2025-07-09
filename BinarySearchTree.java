package proj5;

/**
 * Binary Search Tree (BST) Invariant
 * root (BSTNode) - first BSTNode in tree
 * - the nodes in the left subtree are of lesser value than root and
 *   nodes in the right tree are of a greater value than root
 * - null when no BSTNodes in tree
 * - initialized to null in constructor
 * size (int) - number of BSTNodes in BST
 * - initialized to 0 in constructor
 *
 * I affirm I have followed the Union College Honor Code and CS Honor Code
 * @author Sofia DeCola
 * @version 6/1/23
 */
public class BinarySearchTree<G extends Comparable<G>>
{
    private BSTNode<G> root;
    private int size;

    /**
     * Default constructor
     */
    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    /**
     * inserts recursively.  I include this one so you can
     * make your own trees in your own testing class
     *
     * @param startingNode inserts into subtree rooted at staringNode
     * @param newNode node to insert
     * @return startingNode with newNode already inserted
     */
    private BSTNode<G> recursiveInsert(BSTNode<G> startingNode, BSTNode<G> newNode) {
        if (startingNode == null) {
            return newNode;
        }
        else if (startingNode.key.compareTo(newNode.key) < 0) {
            startingNode.rlink = recursiveInsert(startingNode.rlink,newNode);
            return startingNode;
        }
        else {  // startingNode.key bigger than newNode.key, so newNode goes on left
            startingNode.llink = recursiveInsert(startingNode.llink,newNode);
            return startingNode;
        }
    }

    /**
     * inserts recursively. Use this in your JUnit tests to
     * build a starting tree correctly
     *
     * @param toInsert String to insert
     */
    public void insert(G toInsert){
        BSTNode<G> newNode = new BSTNode<G>(toInsert);
        root = recursiveInsert(root, newNode);
        size++;
    }

    /**
     * Returns the contents of the BST as a string, following an
     * inorder traversal.
     *
     * The string version of the tree uses parentheses to show
     * the subtree structure.  e.g. (( A ) B ( C )) means
     * B is the parent of A (left child) and C (right child).
     *
     * @return the String version
     */
    public String toString()
    {
        return toString(root);
    }

    private String toString(BSTNode<G> subTreeRoot){
        String toReturn = "";
        if (subTreeRoot != null) {     // stop recursing when N is null
            toReturn += toString(subTreeRoot.llink);
            toReturn += subTreeRoot.toString();
            toReturn += toString(subTreeRoot.rlink);
        }
        return toReturn;
    }

    /**
     * Searches for a value in the BST.
     *
     * @param target the value to search for.
     * @return true if and only if 'target' is in the tree
     */
    public boolean contains(G target)
    {
        if (isEmpty()){
            return false;
        } else if (target.compareTo(root.key) == 0){
            return true;
        } else if (target.compareTo(root.key) < 0) {
            return contains(target, root.llink);
        } else {
            return contains(target, root.rlink);
        }

    }

    /**
     * recursively searches if BST contains a BSTNode
     * @param target target to search for in tree
     * @param subTreeRoot root to search from
     * @return boolean if tree contains value
     */
    private boolean contains(G target, BSTNode<G> subTreeRoot) {
        if (subTreeRoot == null) {
            return false;
        }
        int comparison = target.compareTo(subTreeRoot.key);
        if (comparison == 0) {
            return true;
        } else if (comparison < 0){
            return contains(target, subTreeRoot.llink);
        } else {
            return contains(target, subTreeRoot.rlink);
        }


    }
    /**
     * Removes a value from the BST. If the value is not present, does
     * nothing.
     *
     * @param target the value to remove from the tree
     */
    public void delete(G target)
    {
        root = delete(root, target);
        size--;
    }

    /**
     * recursively deletes a node in a tree
     * @param subTreeRoot node to start from
     * @param target data of node to delete
     * @return node to delete
     */
    private BSTNode<G> delete(BSTNode<G> subTreeRoot, G target){
        if (subTreeRoot == null){
            return null;
        }
        int comparison = target.compareTo(subTreeRoot.key);
        if (comparison < 0){
            subTreeRoot.llink = delete(subTreeRoot.llink, target);
        } else if (comparison > 0) {
            subTreeRoot.rlink = delete(subTreeRoot.rlink, target);
        } else {
            if (subTreeRoot.llink == null){
                return subTreeRoot.rlink;
            } else if (subTreeRoot.rlink == null){
                return subTreeRoot.llink;
            }
            subTreeRoot.key = findMinimumKey(subTreeRoot.rlink);
            subTreeRoot.rlink = delete(subTreeRoot.rlink, subTreeRoot.key);
        }
        return subTreeRoot;
    }

    /**
     * Helper to find the BSTNode with the smallest key value in the tree. Used in deleting
     * @param subTreeRoot root to start search from
     * @return key of the least value in BST
     */
    private G findMinimumKey(BSTNode<G> subTreeRoot){
        G minimum = subTreeRoot.key;
        while (subTreeRoot.llink != null){
            subTreeRoot = subTreeRoot.llink;
            minimum = subTreeRoot.key;
        }
        return minimum;
    }
    /**
     * @return the number of elements in the tree
     */
    public int size()
    {
        return size;
    }

    /**
     * @return the height of the tree (i.e. the depth of the deepest node)
     */
    public int height()
    {
        if (isEmpty()){
            return -1;
        } else {
            return findHeight(root);
        }

    }

    /**
     * recursively finds the depth of the deepest node
     * @param subTreeRoot root to check if root has children
     * @return height of the tree
     */
    private int findHeight(BSTNode<G> subTreeRoot){
        if (subTreeRoot == null) {
            return -1;
        } else {
            int leftHeight = findHeight(subTreeRoot.llink);
            int rightHeight = findHeight(subTreeRoot.rlink);

            if (leftHeight > rightHeight){
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }

    }

    /**
     * Searches for an item in the BST
     * @param toFind item to find
     * @return item in tree, null if not in tree
     */
    public G search(G toFind){
        if (contains(toFind)){
            return search(root, toFind);
        } else {
            return null;
        }
    }

    /**
     * Recursively searches for an item in a BST
     * @param subRoot root to start search from
     * @param toFind item to find
     * @return item if in BST
     */
    private G search(BSTNode<G> subRoot, G toFind){
        int comparison = subRoot.key.compareTo(toFind);
        if (comparison == 0){
            return subRoot.key;
        }
        if (comparison < 0){
            return search(subRoot.rlink, toFind);
        } else {
            return search(subRoot.llink, toFind);
        }
    }

    /**
     * @return if BST contains BSTNodes or not
     */
    public boolean isEmpty(){
        return size() == 0;
    }

}

