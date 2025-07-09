package proj5;

import java.util.Arrays;

/**
 * Representation of a Thesaurus using a binary search tree
 * @author Sofia DeCola
 * @version 6/1/23
 * I affirm I have followed the Union College Honor Code and CS Honor Code
 */

public class Thesaurus {

    private static final int KEY_INDEX = 0;
    private static final int FIRST_SYNONYM = 1;
    private BinarySearchTree<ThesaurusEntry> thesaurus;
    /**
     * Default constructor. Creates an empty thesaurus.
     */
    public Thesaurus() {
        thesaurus = new BinarySearchTree<ThesaurusEntry>();
    }

    /**
     * Builds a thesaurus from a text file. Each line of the text file is a comma-separated list of synonymous words.
     * The first word in each line should be the thesaurus entry. The remaining words on that line are the
     * list of synonyms for the entry.
     * @param file - path to comma-delimited text file
     */
    public Thesaurus(String file){
        thesaurus = new BinarySearchTree<ThesaurusEntry>();
        LineReader textFile = new LineReader(file, ",");
        String[] nextLine = textFile.getNextLine();
        while (nextLine != null){
            String[] helper = Arrays.copyOfRange(nextLine, FIRST_SYNONYM, nextLine.length);
            ThesaurusEntry newEntry = new ThesaurusEntry(nextLine[KEY_INDEX], helper);
            thesaurus.insert(newEntry);
            nextLine = textFile.getNextLine();
        }
        textFile.close();
    }


    /**
     * inserts entry and synonyms into thesaurus. If entry does not exist, it creates one. If it does exist,
     * it adds the given synonyms to the entry's synonym list
     * @param entry - keyword to be added
     * @param syns - array of synonyms for keyword entry
     */
    public void insert(String entry, String[] syns){
        ThesaurusEntry newEntry = new ThesaurusEntry(entry, syns);
        if (!thesaurus.contains(newEntry)){
            thesaurus.insert(newEntry);
        } else {
            thesaurus.search(newEntry).addSynonyms(syns);
        }

    }

    /**
     * removes entry (and its associated synonym list) from this thesaurus. If entry does not exist, do nothing.
     * @param entry - word to remove
     */
    public void delete(String entry){
        String[] filler = new String[2];
        ThesaurusEntry newEntry = new ThesaurusEntry(entry, filler);
        if (thesaurus.contains(newEntry)){
            thesaurus.delete(thesaurus.search(newEntry));
        }
    }

    /**
     * Gets a random synonym for the given keyword. If keyword does not exist, return the empty string.
     * @param keyword - word to find a synonym for
     * @return - a random synonym from the synonym list of that word, or empty string if keyword doesn't exist.
     */
    public String getSynonymFor(String keyword){
        String[] filler = new String[1];
        ThesaurusEntry t = new ThesaurusEntry (keyword, filler);
        if (thesaurus.contains(t)){
            t = thesaurus.search(t);
            return t.getRandomSynonym();
        } else {
            return "";
        }
    }

    /**
     * @param keyword possible entry in thesaurus
     * @return if thesaurus has an entry for a given word
     */
    public boolean hasEntry(String keyword){
        String[] filler = new String[1];
        ThesaurusEntry t = new ThesaurusEntry (keyword, filler);
        return thesaurus.contains(t);
    }





    /**
     * return this thesaurus as a printable string. Each keyword and synonym list should be on its own line.
     * The format of each line is: <keyword> - {<syn1>, <syn2>, ..., <synN>}
     * For example,
     * happy - {glad, content, joyful}
     * jump - {leap, bound}
     *
     * The thesaurus keywords will be in alphabetical order. The order of the synonym list words is arbitrary.
     */
    public String toString(){
        return thesaurus.toString();
    }

}
