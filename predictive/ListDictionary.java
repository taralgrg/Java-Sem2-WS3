package predictive;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ListDictionary implements Dictionary {

    /**
     * Takes a Dictionary file as an input, reads the words in it and stores it in an array.
     */
    private ArrayList<WordSig> dictionary;

    public ListDictionary(String dictionaryFile) {
        dictionary = new ArrayList<WordSig>();

        try {
            Scanner fileScan = new Scanner(new File(dictionaryFile));
            // Read each line of file
            while (fileScan.hasNext()){
                String line = fileScan.nextLine().toLowerCase();

                if (PredictivePrototype.isValidWord(line)) {
                    String sig = PredictivePrototype.wordToSignature(line);

                    WordSig newWordSig = new WordSig(line, sig);
                    dictionary.add(newWordSig);
                }
            }
            fileScan.close();
        }
        catch (IOException e) {
            System.out.println("File not found");
        }
        Collections.sort(dictionary);
    }


    /**
     * @param signature is the numeric represntation of an alphabet.
     *        Example - the signature of 'a', 'b', 'c' is '2' and the signature of 'd', 'e', 'f' is '3'.
     * @return returns the matching words for signature using binary search
     */
    public Set<String> signatureToWords (String signature) {
        Set<String> result = new TreeSet<String>();

        if(signature.length() == 0) return result;

        WordSig key = new WordSig(null, signature);

        /**
         *   Returns the index of the first matching words for signature
         *   if no matching word is found, the index where the word would be inserted
         *   will be returned
         */
        int index = Collections.binarySearch(dictionary, key);

        if (index >= 0 && dictionary.get(index).getSignature().equals(signature)) {
            result.add(dictionary.get(index).getWords());

            for (int i = index - 1; i >= 0 && dictionary.get(i).getSignature().equals(signature); i--) {
                result.add(dictionary.get(i).getWords());
            }
            for (int i = index + 1; i < dictionary.size() && dictionary.get(i).getSignature().equals(signature); i++) {
                result.add(dictionary.get(i).getWords());
            }
        }
        return result;
    }

    /**
     * main method to run the ListDictionary function which implemenrts the signatureToWords method.
     */
    public static void main(String[] args) throws IOException {
        ListDictionary d = new ListDictionary("src/predictive/words");

        System.out.println(d.signatureToWords("4543"));

    }

}