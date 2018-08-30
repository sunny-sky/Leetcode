package leetcode.array.easy;

public class No_643_MaximumAverageSubarray {
    public double findMaxAverage(int[] nums, int k) {
        int len = nums.length;
        int[] sum = new int[len];
        sum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        double res = sum[k - 1] * 1.0 / k;
        for (int i = k; i < len; i++) {
            res = Math.max(res, (sum[i]-sum[i - k]) * 1.0 / k);
        }
        return res;
    }
}
