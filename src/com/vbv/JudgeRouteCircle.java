package com.vbv;
/**
 * Date 12 July 2018
 * @author vaibhavjain
 *
 * https://leetcode.com/problems/judge-route-circle/description/
 */
public class JudgeRouteCircle {
    public static void main(String[] args) {
        String moves = "UD";
        JudgeRouteCircle judgeRouteCircle = new JudgeRouteCircle();
        boolean b = judgeRouteCircle.judgeCircle(moves);
        System.out.println(b);
    }

    public boolean judgeCircle(String moves) {
        int[] movementTracker = {0, 0};
        boolean isCircle = true;
        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'U') {
                movementTracker[0]++;
            } else if (c == 'D') {
                movementTracker[0]--;
            } else if (c == 'L') {
                movementTracker[1]--;
            } else if (c == 'R') {
                movementTracker[1]++;
            }
        }
        if (movementTracker[0] != 0 || movementTracker[1] != 0) {
            isCircle = false;
        }
        return isCircle;
    }
}
