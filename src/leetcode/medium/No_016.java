package leetcode.medium;

import java.util.Arrays;

/**
 * @Author: Liang
 * @Description: 最接近的三数之和
 * @Date: Created in 18:57 2019/2/1
 */
public class No_016 {
    /**
     * @Description 最接近的三数之和
     * @Auther Liang
     * @date 18:58 2019/2/1
     * @param nums 输入数组
     * @param target 目标数
     * @return int
     */
    public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
        int min = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1, high = nums.length - 1;
                while (low < high) {
                    int temp = nums[i] + nums[low] + nums[high];
                    if (Math.abs(min - target) > Math.abs(temp - target)) {
                        min = temp;
                    }
                    if (temp - target > 0) {
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        high--;
                    } else if (temp - target < 0) {
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        low++;
                    } else {
                        return temp;
                    }
                }
            }
        }
        return min;
    }
}