package hwk2;

public class Client {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert("Fred");
        //tree.print();
        tree.insert("Barney");
        //tree.print();
        tree.insert("Wilma");
        //tree.print();
        System.out.println(tree.toString());

        tree = new BinarySearchTree();
        tree.insert("Barney");
        tree.insert("Fred");
        tree.insert("Wilma");
        tree.print();

         tree = new BinarySearchTree();
        tree.insert("Wilma");
        tree.insert("Barney");
        tree.insert("Fred");
        tree.print();

        tree = new BinarySearchTree();
        tree.insert("A");
        tree.insert("B");
        tree.insert("C");
        tree.insert("D");
        tree.insert("E");
        tree.insert("F");
        tree.insert("G");
        tree.print();

        tree = new BinarySearchTree();
        tree.insert("D");
        tree.insert("A");
        tree.insert("C");
        tree.insert("B");
        tree.insert("F");
        tree.insert("E");
        tree.insert("G");
        tree.print();
 
    }
}
