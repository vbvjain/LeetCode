package com.vbv;

import java.util.Arrays;

public class MaxIncreasetoKeepCitySkyline {
    public static void main(String[] args) {
        MaxIncreasetoKeepCitySkyline m = new MaxIncreasetoKeepCitySkyline();
        int[][] grid = new int[4][4];
        grid[0][0] = 3;
        grid[0][1] = 0;
        grid[0][2] = 8;
        grid[0][3] = 4;
        grid[1][0] = 2;
        grid[1][1] = 4;
        grid[1][2] = 5;
        grid[1][3] = 7;
        grid[2][0] = 9;
        grid[2][1] = 2;
        grid[2][2] = 6;
        grid[2][3] = 3;
        grid[3][0] = 0;
        grid[3][1] = 3;
        grid[3][2] = 1;
        grid[3][3] = 0;
        int i = m.maxIncreaseKeepingSkyline(grid);
        System.out.println(i);
    }
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int diff = 0;
        int[] lrMax = getLRMax(grid);
        int[] tbMax = getTBMax(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int prev = grid[i][j];
                grid[i][j] = Math.min(lrMax[i], tbMax[j]);
                int after = grid[i][j];
                diff += (after - prev);
            }
        }
        return diff;
    }
    private int[] getTBMax(int[][] grid) {
        int[] max = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            max[i] = grid[0][i];
            for (int j = 1; j < grid[0].length; j++) {
                int i1 = grid[j][i];
                if (max[i] < i1) {
                    max[i] = i1;
                }
            }
        }
        return max;
    }

    private int[] getLRMax(int[][] grid) {
        int[] max = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            max[i] = getMax(grid[i]);
        }
        return max;
    }

    private int getMax(int[] ints) {
        int max = ints[0];
        for (int i = 1; i < ints.length; i++) {
            if (max < ints[i]) {
                max = ints[i];
            }
        }
        return max;
    }
}
