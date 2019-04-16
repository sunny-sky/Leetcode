package leetcode.medium;

public class No_152 {
    public int maxProduct(int[] nums) {
        // 输入为空
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] f = new int[nums.length]; // 存储最大乘积
        int[] g = new int[nums.length]; // 存储最小乘积，为了考虑两负数相乘为最大情况
        f[0] = nums[0];
        g[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = Math.max(Math.max(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);
            g[i] = Math.min(Math.min(f[i - 1] * nums[i], g[i - 1] * nums[i]), nums[i]);
            res = Math.max(res, f[i]);
        }
        return res;
    }
}
