package com.vbv;

import java.util.ArrayList;

public class ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
        int[][] A = {{0,0,0},{0,0,0},{1,0,1},{0,1,0},{0,1,0},{0,0,1},{1,1,1}};
        ScoreAfterFlippingMatrix scoreAfterFlippingMatrix = new ScoreAfterFlippingMatrix();
        int score = scoreAfterFlippingMatrix.matrixScore(A);
        System.out.println(score);
    }

    public int matrixScore(int[][] A) {
        int score = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] == 0) {
                invertRow(A[i]);
            }
        }
        int numOfCols = A[0].length;
        for (int i = 1; i < numOfCols; i++) {
            int[] ithColum = getIthColum(A, i);
            int numOfZeros = numOfZeros(ithColum);
            int numOfOnes = numOfOnes(ithColum);
            if (numOfOnes<numOfZeros){
                invertCol(A,i);
            }
        }
        for (int i = 0; i < A.length; i++) {
            score += arrToBin(A[i]);
        }
        return score;
    }

//    public int matrixScore(int[][] A) {
//        int score = 0;
//        int numOfCols = A[0].length;
//        for (int i = 0; i < numOfCols; i++) {
//            int[] ithColum = getIthColum(A, i);
//            int numOfZeros = numOfZeros(ithColum);
//            int numOfOnes = numOfOnes(ithColum);
//            if (numOfOnes<numOfZeros){
//                invertCol(A,i);
//            }else{
//                ArrayList<Integer> rows =  findRowsHavingZeros(A,i);
//                for (int k = 0; k <rows.size(); k++) {
//                    boolean shouldInvert =  shouldInvertRow(A,rows.get(k));
//                    if (!shouldInvert){
//                        invertRow(A[rows.get(k)]);
//                    }
//                }
//                int[] newIth = getIthColum(A, i);
//                int nz = numOfZeros(newIth);
//                int no = numOfOnes(newIth);
//                if (no<nz){
//                    invertCol(A,i);
//                }
//            }
//        }
//        for (int i = 0; i < A.length; i++) {
//            score+= arrToBin(A[i]);
//        }
//
//
//        return score;
//    }

    private boolean shouldInvertRow(int[][] a, int k) {
        int binVal = arrToBin(a[k]);
        int invertedBinVal = arrToBin(invertRow(a[k]));
        if (binVal>invertedBinVal){
            return false;
        }else {
            return true;
        }


    }

    private ArrayList<Integer> findRowsHavingZeros(int[][] A, int colIndex) {
        ArrayList<Integer> rows = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
                rows.add(i);
        }
        return rows;
    }

    private void invertCol(int[][] A, int colIndex) {
        for (int i = 0; i < A.length; i++) {
            if (A[i][colIndex]==0) {
                A[i][colIndex]=1;
            }else {
                A[i][colIndex]=0;
            }
        }
    }

    private int[] invertRow(int[] A){
        for (int i = 0; i < A.length; i++) {
            if (A[i]==0){
                A[i]=1;
            }else{
                A[i]=0;
            }
        }
        return A;
    }

    private int[] getIthColum(int[][] A, int i) {
        int[] col = new int[A.length];
        for (int k = 0; k < A.length; k++) {
            col[k] = A[k][i];
        }
        return col;
    }

    private int arrToBin(int[] arr) {
        int pow = 1;
        int sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum = sum + arr[i] * pow;
            pow *= 2;
        }
        return sum;
    }

    private int numOfZeros(int[] arr) {
        int numZ = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                numZ++;
            }
        }
        return numZ;
    }

    private int numOfOnes(int[] arr) {
        int numOnes = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                numOnes++;
            }
        }
        return numOnes;
    }


}
