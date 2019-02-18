package predictive;

public class Sigs2WordsMap {

    /**
     * main method to call the MapDictionary class.
     */
    public static void main(String[] args) {
        Dictionary e = new MapDictionary("src/predictive/words");

        for (String sig: args)
            System.out.println(sig + " : " + e.signatureToWords(sig));
    }
}
