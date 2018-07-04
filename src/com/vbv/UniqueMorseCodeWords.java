package com.vbv;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Date 4 July 2018
 * @author vaibhavjain
 *
 * https://leetcode.com/problems/unique-morse-code-words/description/
 */
public class UniqueMorseCodeWords {
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        UniqueMorseCodeWords uniqueMorseCodeWords = new UniqueMorseCodeWords();
        int uniqueRepr = uniqueMorseCodeWords.uniqueMorseRepresentations(words);
        System.out.println(uniqueRepr);
    }
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes =  {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        String[] decodedMorseCodes = new String[words.length];
        String alphabet="abcdefghijklmnopqrstuvwxyz";
        int uniqueRepr;
        for (int i = 0; i < words.length; i++) {
            String decodedMorseString = "";
            String word = words[i];
            for (int h = 0; h < word.length(); h++) {
                char c = word.charAt(h);
                String morseCode = morseCodes[alphabet.indexOf(c)];
                decodedMorseString = decodedMorseString+morseCode;
            }
            decodedMorseCodes[i] = decodedMorseString;
        }

        Set<String> temp = new LinkedHashSet<String>( Arrays.asList( decodedMorseCodes ) );
        String[] result = temp.toArray( new String[temp.size()] );
        uniqueRepr = result.length;
        return  uniqueRepr;
    }
}
