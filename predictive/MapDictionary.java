package predictive;

import java.io.File;
import java.io.IOException;
import java.util.*;


/**
 * This class implements the Dictionary interface using a Map data Structure.
 */
public class MapDictionary implements Dictionary {

    private Map<String, Set<String>> dictionary;

    /**
     * This is the constructor for MapDictionary class that takes a String
     * file path, reads and stores it in HashMap.
     * @param dictionaryFile is the path of the dictionary file.
     */
    public MapDictionary (String dictionaryFile) {
        dictionary = new HashMap<String, Set<String>>();

        try {
            Scanner filescan = new Scanner(new File(dictionaryFile));

            while (filescan.hasNext()) {
                String word = filescan.nextLine().toLowerCase();

                if (PredictivePrototype.isValidWord(word)) {
                    this.addWord(word);
                }
            }
            filescan.close();
        }
        catch (IOException e) {
            System.out.println("File not found");
        }
    }

    /**
     * @param word if the signature is present in the hash map, the word will be
     * added to the set, else a new TreeSet is created and word will be added to it.
     */
    public void addWord (String word) {

        Set<String> words = dictionary.get(PredictivePrototype.wordToSignature(word));

        if (words != null) {
            words.add(word);
        }
        else {
            words = new TreeSet<String>();
            words.add(word);

            dictionary.put(PredictivePrototype.wordToSignature(word), words);
        }
    }

    /**
     * @param signature is the numeric value of the word.
     * @return returns the possible words outcome that correspond to the given signature.
     */
    @Override
    public Set<String> signatureToWords(String signature) {

        if (dictionary.containsKey(signature)) {
            return dictionary.get(signature);
        } else {
            return new TreeSet<String>();
        }
    }


    /**
     * Testing the main method.
     */
    public static void main (String[] args) throws IOException {
        MapDictionary d = new MapDictionary("src/predictive/words");

        System.out.println(d.signatureToWords("437"));

    }
}
