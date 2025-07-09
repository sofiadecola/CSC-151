package proj5;
/**
 * @author Sofia DeCola
 * @version 6/1/23
 *
 * I affirm I have followed the Union College Honor Code and CS Honor Code
 */

import static java.lang.Character.isLetter;

/**
 * Uses a thesaurus and word frequencies to replace overused words in a text document with random synonyms.
 */
public class GrammarChecker {
    private WordCounter wordCounter;
    private Thesaurus thesaurus;
    private int maxFrequency;

    /**
     * Non-default constructor. Builds a thesaurus out of the given comma-separated file and sets the
     * threshold for overused words
     *
     * @param thesaurusFile - path to comma-separated file used to build a thesaurus
     * @param threshold     - a word is considered "overused" if it appears more than (but not equal to)
     *                      this many times in a text document
     */
    public GrammarChecker(String thesaurusFile, int threshold) {
        thesaurus = new Thesaurus(thesaurusFile);
        maxFrequency = threshold;
        wordCounter = new WordCounter();
    }

    /**
     * Given a text file, replaces overused words with synonyms. Finished text is printed to the console.
     *
     * @param textfile - file with original text
     */
    public void improveGrammar(String textfile) {
        wordCounter.findFrequencies(textfile);
        LineReader file = new LineReader(textfile, " ");
        String[] line = file.getNextLine();
        while (line != null) {
            for (String s : line) {
                String noPunctString = s.replaceAll("\\p{P}", "");
                if (wordCounter.getFrequency(noPunctString) > maxFrequency) {
                    if (!thesaurus.hasEntry(noPunctString)) {
                        System.out.print(s + " ");
                    } else {
                        String synonym = thesaurus.getSynonymFor(noPunctString);
                        punctuationHelper(s, synonym);
                    }
                } else {
                    System.out.print(s + " ");
                }
            }
            System.out.println();
            line = file.getNextLine();
        }
        file.close();
    }

    /**
     * Deals with printing out punctuation if applicable to the word being replaced with a synonym
     * @param s String with possible punctuation
     * @param synonym synonym for word that is being replaced
     */
    private void punctuationHelper(String s, String synonym){
        char punctuation = s.charAt(s.length() - 1);
        boolean isPunct = !isLetter(punctuation);
        if (isPunct){
            System.out.print(synonym + punctuation + " ");
        } else {
            System.out.print(synonym + " ");
        }
    }


    public static void main(String[] args) {
        GrammarChecker g = new GrammarChecker("src/proj5/bigThesaurus.txt", 2);
        g.improveGrammar("src/proj5/apartment.txt");
    }
}
