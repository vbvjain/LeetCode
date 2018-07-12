package com.vbv;

import java.util.HashMap;
/**
 * Date 12 July 2018
 * @author vaibhavjain
 *
 * https://leetcode.com/problems/find-anagram-mappings/description/
 */

public class FindAnagramMappings {
    public static void main(String[] args) {
        int[] a = {12, 28, 46, 32, 50};
        int[] b = {50, 12, 32, 46, 28};
        FindAnagramMappings findAnagramMappings = new FindAnagramMappings();
        int[] mapping = findAnagramMappings.anagramMapping(a, b);
        for (int i = 0; i < mapping.length; i++) {
            System.out.println(mapping[i]);
        }

    }
    private int[] anagramMapping(int[] x, int[] y) {
        int[] mapping = new int[x.length];
        HashMap<Integer,Integer> position = new HashMap<>();
        for (int i = 0; i < y.length; i++) {
            position.put(y[i],i);
        }
        for (int i = 0; i < x.length; i++) {
            mapping[i] =  position.get(x[i]);
        }
        return mapping;
    }

}
