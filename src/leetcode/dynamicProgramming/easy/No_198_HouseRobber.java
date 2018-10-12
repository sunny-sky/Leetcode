package leetcode.dynamicProgramming.easy;

public class No_198_HouseRobber {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];
        else if (len == 2)
            return Math.max(nums[0], nums[1]);
        else if (len == 0)
            return 0;
        int[] temp = new int[len];
        temp[0] = nums[0];
        temp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            temp[i] = Math.max(temp[i-1], temp[i-2] + nums[i]);
        }
        return temp[len - 1];
    }
}
