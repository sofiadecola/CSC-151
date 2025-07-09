package hwk2;
/** This is the BST ADT.  It should contain methods that allow it to
 *  insert new nodes, delete nodes, search, etc.  You'll be adding
 *  code to this class for this hwk.
 * 
 * @author Sofia DeCola
 * @version (a version number or a date)
 */
public class BinarySearchTree
{
     private BSTNode root;
     private int size;
          
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
     private BSTNode recursiveInsert(BSTNode startingNode, BSTNode newNode) {
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
      * @param newString String to insert
      */
     public void insert(String newString){
    	 BSTNode newNode = new BSTNode(newString);
    	 root = recursiveInsert(root, newNode);
         size++;
     }
     
     
     /**
      * WARNING: CRAPPY METHOD!  I wish I had toString...
      * 
      * Recursive helper method of print.
      * Uses inorder tree traversal algorithm.
      * @param N subroot of tree to print
      */
     private void print(BSTNode N) 
     {   
         if (N != null) {     // stop recursing when N is null       
           System.out.print("(");
           print(N.llink);
           System.out.print("  " + N + "  ");
           print(N.rlink);
           System.out.print(")");
         }
     }
     
     
     /**
      *  WARNING: CRAPPY METHOD!  I wish I had toString...
      *  
      *  prints a parenthesized version of the tree that shows
      *  the subtree structure.  Example: (( A ) B ( C )) means
      *  B is the parent of A (left child) and C (right child).
      */
     public void print() 
     {
         print(root);
         System.out.println();
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

    private String toString(BSTNode subTreeRoot){
        String toReturn = "";
        if (subTreeRoot != null) {     // stop recursing when N is null
            toReturn += "(";
            toReturn += toString(subTreeRoot.llink);
            toReturn += "  " + subTreeRoot + "  ";
            toReturn += toString(subTreeRoot.rlink);
            toReturn += ")";
        }
        return toReturn;
    }

    /**
     * Searches for a value in the BST.
     *
     * @param target the value to search for.
     * @return true if and only if 'target' is in the tree
     */
    public boolean contains(String target)
    {
        if (isEmpty()){
            return false;
        } else if (target.equals(root.key)){
            return true;
        } else if (target.compareTo(root.key) < 0) {
            return contains(target, root.llink);
        } else {
            return contains(target, root.rlink);
        }

    }

    private boolean contains(String target, BSTNode subTreeRoot) {
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
    public void delete(String target)
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
    private BSTNode delete(BSTNode subTreeRoot, String target){
        if (subTreeRoot == null){
            return subTreeRoot;
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


    private static String findMinimumKey(BSTNode subTreeRoot){
        String minimum = subTreeRoot.key;
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
    private int findHeight(BSTNode subTreeRoot){
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

    public boolean isEmpty(){
        return size() == 0;
    }
}
