package predictive;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PredictivePrototype {


    /**
     * It was better to use StringBuffer as String are immutable, whereas
     * are not and given we need to constantly append it was
     * better to use StringBuffer.
     *
     *
     * This methods converts words to signature, it is better to use StringBuffer because it is
     * faster  to make more modifications to Strings of characters and Strings
     * @param word is the word input by the user.
     * @return returns the signature of the words.
     */
    public static String wordToSignature(String word) {

        StringBuffer sBuffer = new StringBuffer();

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'b' || word.charAt(i) == 'c') {
                sBuffer.append(2);
            } else if (word.charAt(i) == 'd' || word.charAt(i) == 'e' || word.charAt(i) == 'f') {
                sBuffer.append(3);
            } else if (word.charAt(i) == 'g' || word.charAt(i) == 'h' || word.charAt(i) == 'i') {
                sBuffer.append(4);
            } else if (word.charAt(i) == 'j' || word.charAt(i) == 'k' || word.charAt(i) == 'l') {
                sBuffer.append(5);
            } else if (word.charAt(i) == 'm' || word.charAt(i) == 'n' || word.charAt(i) == 'o') {
                sBuffer.append(6);
            } else if (word.charAt(i) == 'p' || word.charAt(i) == 'q' || word.charAt(i) == 'r' || word.charAt(i) == 's') {
                sBuffer.append(7);
            } else if (word.charAt(i) == 't' || word.charAt(i) == 'u' || word.charAt(i) == 'v') {
                sBuffer.append(8);
            } else if (word.charAt(i) == 'w' || word.charAt(i) == 'x' || word.charAt(i) == 'y' || word.charAt(i) == 'z') {
                sBuffer.append(9);
            } else {
                sBuffer.append(' ');
            }
        }
        return sBuffer.toString();

    }

    /**
     * @param word is the input of the word thats being passed through the function
     * @return returns true if the characters of the word is valid and is incuded in our collection of alphabets.
     */
    public static boolean isValidWord(String word) {

        if (word.charAt(0) == 'a' || word.charAt(0) == 'b' || word.charAt(0) == 'c' ||
                word.charAt(0) == 'd' || word.charAt(0) == 'e' || word.charAt(0) == 'f' ||
                word.charAt(0) == 'g' || word.charAt(0) == 'h' || word.charAt(0) == 'i' ||
                word.charAt(0) == 'j' || word.charAt(0) == 'k' || word.charAt(0) == 'l' ||
                word.charAt(0) == 'm' || word.charAt(0) == 'n' || word.charAt(0) == 'o' ||
                word.charAt(0) == 'p' || word.charAt(0) == 'q' || word.charAt(0) == 'r' || word.charAt(0) == 's' ||
                word.charAt(0) == 't' || word.charAt(0) == 'u' || word.charAt(0) == 'v' ||
                word.charAt(0) == 'w' || word.charAt(0) == 'x' || word.charAt(0) == 'y' || word.charAt(0) == 'z')
        {
            return true;
        }
        {
            return false;
        }
    }

    /**
     * @param signature is the numeric representation of the characters in the word.
     * @return returns the possible converted words thats being converted from the signature.
     */
    public static Set<String> signatureToWords(String signature) {

        Set<String> set = new HashSet<String>();

        try {
            Scanner scan = new Scanner(Paths.get("src/predictive/words"));

            while (scan.hasNext()) {

                String nextWord = scan.nextLine().toLowerCase();
                String returnedString = wordToSignature(nextWord);

                if (isValidWord(nextWord) && returnedString.equals(signature)) {
                    set.add(nextWord);
                }
            }
            scan.close();
        } catch (IOException e) {
            System.out.println("File Not Found");
        }
        return set;
    }


    /**
     * Method to test the signatureToWords Method.
     */
    public static void main(String[] args) {
        System.out.println(signatureToWords("4663"));
//        System.out.println(signatureToWords("23"));
//        System.out.println(signatureToWords("9753"));
//        System.out.println(signatureToWords("111111"));
//        System.out.println(signatureToWords("2"));
//        System.out.println(signatureToWords(""));

    }
}


