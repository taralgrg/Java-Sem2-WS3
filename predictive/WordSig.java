package predictive;

/**
 * Wordsig method pairs words and signatures
 */
public class WordSig implements Comparable <WordSig> {
    private String words;
    private String signature;


    /**
     * @param words is the words that is input by using the number keypad.
     * @param signature is the numerical representation of the word. Example -
     *          the signature of 'a', 'b', 'c' is '2' and the signature of 'd', 'e', 'f' is '3'.
     */
    public WordSig(String words, String signature) {
        this.words = words;
        this.signature = signature;

    }

    /**
     * @return returns the word that is input.
     */
    public String getWords() {
        return words;
    }

    /**
     * @return returns the signature of the word.
     */
    public String getSignature() {
        return signature;
    }

    /**
     * @param o is the element of  WordSig Object.
     * @return returns integer value after comparing the signature of WordSig class and WordSig Object.
     */
    public int compareTo(WordSig o){
        if(this.signature.length() > o.signature.length()) {
            return 1;
        }
        if(this.signature.length() < o.signature.length()) {
            return -1;
        }

        //if (this.signature.length()==other.signature.length())
        return this.signature.compareTo(o.signature);
    }

    /**
     * @return the to string method to return the words and signature.
     */
    public String toString() {
        return "Signature : " + signature + " Words: "+ words;
    }

}