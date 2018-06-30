package com.vbv;

/**
 * Date 30 June 2018
 * @author vaibhavjain
 *
 * https://leetcode.com/problems/find-pivot-index/description/
 */

public class PivotIndex {
    public static void main(String[] args) {
        int[] input = {-1,-1,0,0,-1,-1};
        PivotIndex pivotIndex = new PivotIndex();
        int pivotElement = pivotIndex.getPivotElement(input);
        System.out.println(pivotElement);
    }

    public int getPivotElement(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
