package predictive;

/**
 * main method to call the TreeDictionary class.
 */
public class Sigs2WordsTree {

    public static void main(String[] args) {

        Dictionary dict = new TreeDictionary("src/predictive/words");

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i] + ": " + dict.signatureToWords(args[i]));
        }
    }
}

