package com.vbv;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAndReplacePattern {
    public static void main(String[] args) {
        String[] words = new String[]{"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        FindAndReplacePattern findAnagramMappings = new FindAndReplacePattern();
        List<String> qualifiedWords = findAnagramMappings.findAndReplacePattern(words, pattern);
        System.out.println(qualifiedWords);

    }
    private List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> qualified = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean isQ =  isQualified(word,pattern);
            if (isQ) qualified.add(word);
        }
        return qualified;
    }

    private boolean isQualified(String word, String pattern) {
        if (word.length()!=pattern.length()) return false;
        HashMap<Character,Character> p2w = new HashMap<>();
        HashMap<Character,Character> w2p = new HashMap<>();
        int wIndex = 0;
        while (wIndex!=word.length()){
            char w = word.charAt(wIndex);
            char p = pattern.charAt(wIndex);
            boolean isM1 = isP2W(p2w,p,w);
            boolean isM2 = isP2W(w2p,w,p);
            if (!isM1||!isM2){
                return false;
            }
            wIndex++;
        }
        return true;
    }

    private boolean isP2W(HashMap<Character, Character> p2w, char p, char w) {
        if (p2w.containsKey(p)) {
            Character character = p2w.get(p);
            if (character!=w){
                return false;
            }else return true;
        }
        else {
            p2w.put(p, w);
            return true;
        }
    }
}
