package leetcode.dynamicProgramming.easy;

public class No_070_ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] temp = new int[n + 1];
        temp[1] = 1;
        temp[2] = 2;
        for (int i = 3; i < n + 1; ++i) {
            temp[i] = temp[i-2] + temp[i-1];
        }
        return temp[n];
    }
}
