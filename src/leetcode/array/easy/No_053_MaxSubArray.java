package leetcode.array.easy;

public class No_053_MaxSubArray {
    public int maxSubArray(int[] nums) {
        int sum;
        sum = nums[0];
        for(int i = 0; i < nums.length; i++) {
            int temp = 0;
            for(int j = i; j < nums.length; j++){
                temp += nums[j];
                if(temp > sum) {
                    sum = temp;
                }
            }
        }
        return sum;
    }
    public int maxSubArray2(int[] nums) {
        int cur = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++){
            cur = Math.max(nums[i], cur + nums[i]);
            res = Math.max(res, cur);
        }
        return res;
    }
}
