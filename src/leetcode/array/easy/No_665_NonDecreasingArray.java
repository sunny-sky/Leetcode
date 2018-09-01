package leetcode.array.easy;

import java.util.Arrays;

public class No_665_NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        int i = 1,count = 0;
        for (; i < len; ++i) {
            if (nums[i - 1] > nums[i]) {
                count++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                }
                else{
                    nums[i] = nums[i - 1];
                }
            }
            if (count > 1) {
                return false;
            }
        }
        return count <= 1;
    }
}
