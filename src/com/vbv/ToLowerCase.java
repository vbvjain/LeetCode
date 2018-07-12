package com.vbv;
/**
 * Date 12 July 2018
 * @author vaibhavjain
 *
 * https://leetcode.com/problems/to-lower-case/description/
 */

public class ToLowerCase {
    public static void main(String[] args) {
        String str = "ABC";
        ToLowerCase lowerCase = new ToLowerCase();
        String s = lowerCase.toLowerCase(str);
        System.out.println(s);
    }

    public String toLowerCase(String str) {
        StringBuilder lc = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char b = str.charAt(i);
            if (Character.isUpperCase(b)) {
                b = (char) ((int) b + 32);
            }
            lc.append(b);
        }
        return lc.toString();
    }
}
