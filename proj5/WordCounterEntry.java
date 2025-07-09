package proj5;
/**
 * Allows an entry into a WordCounter to have both key and data without altering BST Nodes
 *
 * @author Sofia DeCola
 * @version 6/1/23
 * I affirm I have followed the Union College Honor Code and CS Honor Code
 */
public class WordCounterEntry implements Comparable<WordCounterEntry> {

    private int frequency;
    private String wordEntry;

    /**
     * Non default Constructor. Builds an entry for a word counter based on an inputted word
     * @param word
     */
    public WordCounterEntry(String word){
        wordEntry = word.replaceAll("\\p{P}","" );
        frequency = 1;
    }

    /**
     * Increases frequency if a word is present more than once in a WordCounter
     */
    public void increaseFrequency(){
        frequency++;
    }

    /**
     * @return word associated with a frequency in WordCounter
     */
    public String getWordEntry(){
        return wordEntry;
    }

    /**
     * @return frequency associated with a word in WordCounter
     */
    public int getFrequency(){
        return frequency;
    }

    /**
     * @return String version of a WordCounterEntry. Follows form of
     * <word>: <frequency>
     */
    public String toString(){
        return wordEntry + ": " + Integer.toString(frequency) + "\n";
    }

    /**
     * Compares two WordCounterEntries based on word entry
     * @param o the object to be compared.
     * @return integer relaying comparison (0 if equal, > 0 if greater, < 0 if less than)
     */
    @Override
    public int compareTo(WordCounterEntry o) {
        return wordEntry.compareTo(o.getWordEntry());
    }

}
