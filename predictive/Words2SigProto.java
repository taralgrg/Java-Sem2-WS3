package predictive;

public class Words2SigProto {

    /**
     * Method for calling the wordToSignature method.
     */
    public static void main(String[] args) {

        for (String word: args){
            System.out.println(PredictivePrototype.wordToSignature(word) + " ");

        }
    }
}