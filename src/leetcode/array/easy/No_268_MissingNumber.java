package leetcode.array.easy;

public class No_268_MissingNumber {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int sum = 0,result;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        result = (0 + len) * (len + 1)/ 2 - sum;
        return result;
    }
}
