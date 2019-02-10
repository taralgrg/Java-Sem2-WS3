package predictive;

public class Sigs2WordsProto {

    /**
     * Method to call the signatureToWords method.
     */
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i] + ": " + PredictivePrototype.signatureToWords(args[i]));
        }
    }
}