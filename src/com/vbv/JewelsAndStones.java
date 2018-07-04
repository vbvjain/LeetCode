package com.vbv;
/**
 * Date 4 July 2018
 * @author vaibhavjain
 *
 * https://leetcode.com/problems/jewels-and-stones/description/
 */
public class JewelsAndStones {
    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        JewelsAndStones JS = new JewelsAndStones();
        int numJewelsInStones = JS.numJewelsInStones(J, S);
        System.out.println(numJewelsInStones);
    }

    private int numJewelsInStones(String J, String S) {
        int numOfJewels = 0;
        for (int i = 0; i < J.length(); i++) {
            char c = J.charAt(i);
             numOfJewels+= count(S,c);
        }
        return numOfJewels;
    }

    private int count(String s, char c) {
        int res = 0;
        for (int i=0; i<s.length(); i++){
            if (s.charAt(i) == c)
                res++;
        }
        return res;
    }
}
