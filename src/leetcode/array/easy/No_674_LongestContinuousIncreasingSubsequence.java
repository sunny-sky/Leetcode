package leetcode.array.easy;

public class No_674_LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int temp = 1, res = 1;
        if (len == 1) {
            return 1;
        }
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i-1]){
                temp++;
            } else {
                temp = 1;
            }
            res = temp > res ? temp : res;
        }
        return res;
    }
}
