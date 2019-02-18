package predictive;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class WorkSheet3Tests {
    ListDictionary d = new ListDictionary("src/predictive/words");
    /*
     * Testing word to Signature method - empty string
     */
    @Test
    public void ex1test1() {
        String word = "";
        String expected = "";
        assertEquals(expected, PredictivePrototype.wordToSignature(word));
    }
    /*
     * Testing word to Signature method - space
     */
    @Test
    public void ex1test2() {
        String word = " ";
        String expected = " ";
        assertEquals(expected, PredictivePrototype.wordToSignature(word));
    }
    /*
     * Testing word to Signature method - expected string lowercase
     */
    @Test
    public void ex1test3() {
        String word = "abcdefghijklmnopqrstuvwxyz";
        String expected = "22233344455566677778889999";
        assertEquals(expected, PredictivePrototype.wordToSignature(word));
    }

    /*
     * Testing word to Signature method - non-/alphabetical mixed
     */
    @Test
    public void ex1test5() {
        String word = "h&m";
        String expected = "4 6";
        assertEquals(expected, PredictivePrototype.wordToSignature(word));
    }


    /*
     * Testing signatureToWords()
     */
    @Test
    public void ex2test1() {
        String sig = "2";
        HashSet<String> expected = new HashSet<String>();
        expected.add("a");
        expected.add("b");
        expected.add("c");
        Set<String> result = PredictivePrototype.signatureToWords(sig);
        assertEquals(expected, result);
    }
    /*
     * Testing signatureToWords()  empty string
     */
    @Test
    public void ex2test2() {
        String sig = "";
        HashSet<String> expected = new HashSet<String>();
        Set<String> result = PredictivePrototype.signatureToWords(sig);
        assertEquals(expected, result);
    }
    /*
     * Testing signatureToWords() invalid signature
     */
    @Test
    public void ex2test3() {
        String sig = "1";
        HashSet<String> expected = new HashSet<String>();
        Set<String> result = PredictivePrototype.signatureToWords(sig);
        assertEquals(expected, result);
    }

    /*
     * Testing Word2SigProto class
     * VISUAL TEST
     */
    @Test
    public void verifyParamsForWords2SigProto() {
        System.out.println("Test: Words2SigProto Class");
        Words2SigProto.main(new String[]{"home", "cat"});
        System.out.println();
    }
    /*
     * Testing Sigs2WordsProto
     * VISUAL TEST
     */
    @Test
    public void verifyParamsForSigs2WordsProto() {
        System.out.println("Test: Sigs2WordsProto Class");
        Sigs2WordsProto.main(new String[]{"4663", "228"});
        System.out.println();
    }


    /**
     * Testing WordSig(String word)
     */
    @Test
    public void WordSigTest1() {
        WordSig test = new WordSig("home","4663");
        String expected = "4663";
        String result = test.getSignature();
        assertEquals(expected, result);
    }

    /**
     * Testing WordSig(String word, String sig) - testing getSignature
     */
    @Test
    public void WordSigTest3() {
        WordSig test = new WordSig("home", "123");
        String expected = "123";
        String result = test.getSignature();
        assertEquals(expected, result);
    }
    /**
     * Testing WordSig(String word, String sig) - testing getWord
     */
    @Test
    public void WordSigTest4() {
        WordSig test = new WordSig("home", "123");
        String expected = "home";
        String result = test.getWords();
        assertEquals(expected, result);
    }


    /**
     * Testing WordSig equals - same word, diff sigs
     */
    @Test
    public void WordSigTest8() {
        WordSig test = new WordSig("home", "2345");
        WordSig test2 = new WordSig("home", "123");
        assertFalse(test.equals(test2));
    }
    /**
     * Testing WordSig compareTo - more than
     */
    @Test
    public void WordSigTest9() {
        WordSig test = new WordSig("home", "2345");
        WordSig test2 = new WordSig("home", "123");
        int result = test.compareTo(test2);
        int expected = 1;
        assertEquals(result, expected);
    }
    /**
     * Testing WordSig compareTo - less than
     */
    @Test
    public void WordSigTest10() {
        WordSig test = new WordSig("home", "23");
        WordSig test2 = new WordSig("home", "123");
        int result = test.compareTo(test2);
        int expected = -1;
        assertEquals(result, expected);
    }
    /**
     * Testing WordSig compareTo - same
     */
    @Test
    public void WordSigTest11() {
        WordSig test = new WordSig("home", "123");
        WordSig test2 = new WordSig("home", "123");
        int result = test.compareTo(test2);
        int expected = 0;
        assertEquals(result, expected);
    }



}