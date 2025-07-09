package proj5;
/**
 * Representation of a Word Counter using a BST
 *
 * @author Sofia DeCola
 * @version 6/1/23
 * I affirm I have followed the Union College Honor Code and CS Honor Code
 */
public class WordCounter {

    private BinarySearchTree<WordCounterEntry> wordCounterBST;
    /**
     * Default constructor
     */
    public WordCounter(){
        wordCounterBST = new BinarySearchTree<WordCounterEntry>();
    }

    /**
     * Computes frequency of each word in given file
     * @param file - path to file, such as "src/input.txt"
     */
    public void findFrequencies(String file){
       LineReader fileReader = new LineReader(file, " ");
       String[] n = fileReader.getNextLine();
       while (n != null){
           for (String s : n) {
               WordCounterEntry wordEntry = new WordCounterEntry(s);
               if (!wordCounterBST.contains(wordEntry)){
                   wordCounterBST.insert(wordEntry);
               } else {
                   wordCounterBST.search(wordEntry).increaseFrequency();
               }

           }
           n = fileReader.getNextLine();
       }
       fileReader.close();
    }


    /**
     * returns the frequency of the given word
     * @param word - string to get the frequency of
     * @return - the number of times word appears in the input file
     */
    public int getFrequency(String word){
       WordCounterEntry wordEntry = new WordCounterEntry(word);
       if (wordCounterBST.contains(wordEntry)){
         wordEntry = wordCounterBST.search(wordEntry);
         return wordEntry.getFrequency();
       } else {
         return 0;
       }

    }

    /**
     * returns words and their frequencies as a printable String. Each word/frequency pair should be on a separate line, and the format of each line should be <word>: <frequency>
     * For example,
     * are: 3
     * bacon: 2
     * Words should be in alphabetical order.
     */
    public String toString(){
        return wordCounterBST.toString();
    }


}
