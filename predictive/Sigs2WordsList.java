package predictive;

public class Sigs2WordsList {

    /**
     * main method to call the ListDictionary class.
     */
    public static void main(String[] args) {
        ListDictionary d = new ListDictionary("src/predictive/words");

        for (String sig : args)
            System.out.println(sig + " : " + d.signatureToWords(sig));
    }


}