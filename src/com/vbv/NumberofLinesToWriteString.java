package com.vbv;

public class NumberofLinesToWriteString {
    public static void main(String[] args) {
        NumberofLinesToWriteString numberofLinesToWriteString = new NumberofLinesToWriteString();
        String s = "bbbcccdddaaa";
        int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        numberofLinesToWriteString.numberOfLines(widths, s);

    }
    public int[] numberOfLines(int[] widths, String s) {
        int numLines = 1;
        int acc = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int width = widths [c-'a'];
            acc = acc+width;
            if (acc>100){
                i--;
                numLines++;
                acc=0;
            }
        }
        int[] returnVal = {numLines,acc};
        return returnVal;
    }
}
