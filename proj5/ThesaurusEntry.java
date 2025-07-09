package proj5;

import java.util.Arrays;
/**
 * Allows an entry into a Thesaurus to have both key and data (synonyms) without altering BST Nodes
 *
 * @author Sofia DeCola
 * @version 6/1/23
 * I affirm I have followed the Union College Honor Code and CS Honor Code
 */
public class ThesaurusEntry implements Comparable<ThesaurusEntry> {

    private String key;
    private String[] synonyms;

    /**
     * Non default constructor
     * @param entryKey - entry in thesaurus, keyword
     * @param similarWords - synonyms associated with entryKey
     */
    public ThesaurusEntry(String entryKey, String[] similarWords){
        key = entryKey;
        synonyms = similarWords;
    }

    /**
     * @return random synonym from list of synonyms
     */
    public String getRandomSynonym(){
        int random = (int) (Math.random() * synonyms.length);
        return synonyms[random];
    }

    /**
     * adds synonyms to already existing list of synonyms in thesaurus
     * @param toAdd - list of correlated synonyms to add to an existing entry in thesaurus
     */
    public void addSynonyms(String[] toAdd){
        int synLength = synonyms.length;
        int toAddLength = toAdd.length;
        String[] combined = new String[synLength + toAddLength];
        System.arraycopy(synonyms, 0, combined, 0, synLength);
        System.arraycopy(toAdd, 0, combined, synLength, toAddLength);
        synonyms = combined;
    }

    /**
     * @return entryKey in thesaurus
     */
    public String getKey(){
        return key;
    }

    /**
     * @return thesaurus entry as a printable string.
     * Follows format entryKey - {synonyms}
     */
    public String toString() {
        String helper = Arrays.toString(synonyms);
        helper = helper.replaceAll("\\[", "");
        helper = helper.replaceAll("]", "");
        return key + " - {" + helper + "}\n" ;
    }

    /**
     * @return synonyms in a given thesaurus entry
     */
    public String[] getSynonyms(){
        return synonyms;
    }
    /**
     * Compares two ThesaurusEntries based on entryKey
     * @param o the object to be compared.
     * @return integer relaying comparison (0 if equal, > 0 if greater, < 0 if less than)
     */
    public int compareTo(ThesaurusEntry o) {
        return key.compareTo(o.getKey());
    }


}
