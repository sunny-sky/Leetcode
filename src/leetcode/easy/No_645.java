package leetcode.easy;

import java.util.Arrays;

/**
 * @Author: Liang
 * @Description: 错误的集合
 * @Date: Created in 19:23 2019/1/29
 */
public class No_645 {
    /**
     * @Description 错误的集合
     * @Auther Liang
     * @date 19:23 2019/1/29
     * @param nums 输入数组
     * @return int[]
     */
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return new int[0];
        }
        Arrays.sort(nums);
        int target = 0;
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] == nums[i - 1]) {
                // 记录重复数
                target = nums[i];
            }
        }
        return new int[] {target, (1 + len) * len / 2 - sum + target};
    }
}
