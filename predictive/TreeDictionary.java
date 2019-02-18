package predictive;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class TreeDictionary uses TreeDictionary array and has a set of words or prefixes
 * with an array of 8 subtrees which have their TreeDictionary array to hold letters,
 * prefixes and words at each node. Each subtree have the digits from 2 to 9. The 0th subtree
 * corresponds to the digit 2 and the 8'th to 9.
 * This class returns the set of words or prefixes of words that matches the given signature at each node.
 */
public class TreeDictionary implements Dictionary {

    private Set<String> words;
    private TreeDictionary[] childrenTree;

    /**
     * This is the constructor for MapDictionary class that takes String
     * file path to the dictionary, reads and store it in TreeDictionary
     * @param dictionary is the file path of dictionary
     */
    public TreeDictionary(String dictionary) {
        childrenTree = new TreeDictionary[8];
        words = new TreeSet<String>();

        try {
            Scanner fileScan = new Scanner(new File(dictionary));

            while (fileScan.hasNext()) {
                String word = fileScan.nextLine().toLowerCase();

                if (PredictivePrototype.isValidWord(word)) {

                    insert(PredictivePrototype.wordToSignature(word), word);
                }
            }
            fileScan.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }

    //  A  constructor creates the tree dictionary for leaf node with an empty set of words
    private TreeDictionary() {
        childrenTree = new TreeDictionary[8];
        words = new TreeSet<String>();
    }

    /**
     * This method insert a word that matches a signature into a tree
     * @param signature signature of the word
     * @param word the word that need to be inserted
     */

    private void insert(String signature, String word) {
        if (signature.length() > 0 && PredictivePrototype.isValidWord(word)
                && signature.charAt(0) >= '2' && signature.charAt(0) <= '9') {
            insertHelper(0, signature, word);
        }
    }

    /**
     * This method inserts word that matches the signature in the tree
     * @param nodeCounter counter that keeps track of the current position of signature
     * @param signature signature of the word
     * @param word the word that need to be inserted
     */
    private void insertHelper(int nodeCounter, String signature, String word) {
        signature = signature.trim();
        // if the nodeCounter is the last character in the signature
        // then it will be added to words Set
        if (signature.length() == nodeCounter) {
            words.add(word);
        } else {
            if (signature.charAt(nodeCounter) >= '2' && signature.charAt(nodeCounter) <= '9'){
                // returns the int value that the specified Unicode character represents.
                int numericValue = Character.getNumericValue(signature.charAt(nodeCounter));
                // index of children array is "numericValue -2"
                if (childrenTree[numericValue - 2] == null) {
                    childrenTree[numericValue - 2] = new TreeDictionary();
                }
                // add the word at the root node
                words.add(word);
                // recursive call for the remaining signature
                childrenTree[numericValue - 2].insertHelper(nodeCounter + 1, signature, word);
            }
        }
    }


    /**
     * This methods returns the set of words or prefixes of words that matches the given signature.
     * The length of the returned word or prefixes must be the same as the input signature
     * @param signature signature of the word
     * @return the set of words or prefixes of words that matches the given signature.
     */
    @Override
    public Set<String> signatureToWords(String signature) {
        // to get set of words by findHelper method
        Set<String> findSig = findHelper(0, signature);
        Set<String> result = new TreeSet<String>();

        // The length of the returned word or prefixes must be the same as the input signature
        for(String word:findSig){
            result.add( word.substring(0, signature.length()));
        }
        return result;
    }

    /**
     * This method find the words that matches the signature and returns the set of words or prefixes
     * of words that matches the signature
     * @param nodeCounter counter that keeps track of the current position of signature
     * @param signature signature of the word
     * @return the set of words or prefixes of words that matches the signature
     */
    private Set<String> findHelper( int nodeCounter, String signature) {
        // if the nodeCounter is the last character in the signature
        // then it returns the list of words in this node
        if (signature.length() == nodeCounter) {
            return new TreeSet<String>(words);
        } else {

            if (signature.charAt(nodeCounter) >= '2' && signature.charAt(nodeCounter) <= '9') {
                int numericValue = Character.getNumericValue(signature.charAt(nodeCounter));

                if (childrenTree[numericValue - 2] == null) {
                    // if the signature not in the tree
                    return new TreeSet<String>();
                }
                // recursive call for the remaining signature
                return childrenTree[numericValue - 2].findHelper(nodeCounter + 1, signature);
            }
            return new TreeSet<String>();

        }
    }
    /*
     Testing Main Method
     */

    public static void main(String[] args) throws IOException {
        ListDictionary d = new ListDictionary("src/predictive/words");

        System.out.println(d.signatureToWords("4663"));
        System.out.println(d.signatureToWords("228"));
        System.out.println(d.signatureToWords("55555555"));
        System.out.println(d.signatureToWords("9"));
        System.out.println(d.signatureToWords("92837"));
        System.out.println(d.signatureToWords("237675263"));
        System.out.println(d.signatureToWords(" "));
    }
}



