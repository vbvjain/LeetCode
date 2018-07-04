package com.vbv;
/**
 * Date 4 July 2018
 * @author vaibhavjain
 *
 * https://leetcode.com/problems/hamming-distance/description/
 */
public class HammingDistance {
    public static void main(String[] args) {
        int x = 106, y = 219;
        HammingDistance hammingDistance = new HammingDistance();
        int dist = hammingDistance.hammingDistance(x, y);
        System.out.println(dist);
    }
    private int hammingDistance(int x, int y) {
        int hamming = 0;
        int i = x ^ y;
        hamming =  countSetBits( i);
        return hamming;
    }

    private int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }
}
