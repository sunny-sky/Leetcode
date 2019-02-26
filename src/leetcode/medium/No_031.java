package leetcode.medium;

import java.util.Arrays;

/**
 * @Author: Liang
 * @Description: 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须原地修改，只允许使用额外常数空间。
 * @Date: Created in 8:11 2019/2/25
 */
public class No_031 {
    /**
     * @Description 下一个排列
     * 1 2 3 4 -- 1 2 4 3
     * 4 3 2 1 -- 1 2 3 4
     * 1 2 4 3 -- 1 3 2 4
     * 1 4 3 2 -- 2 1 3 4
     * 1 4 2 3 -- 1 4 3 2
     * 3 4 2 1 -- 4 1 2 3
     * 1 1 5 1 -- 1 5 1 1
     * 1 5 1 1 -- 5 1 1 1
     * @Auther Liang
     * @date 8:13 2019/2/25
     * @param nums 输入数字序列int[]型
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int point = len - 1;
        int minAdd = len - 1;
        while (point > 0) {
            if (nums[point] <= nums[point - 1]) {
                point--;
            } else {
                int temp = nums[point - 1];
                while (nums[point - 1] >= nums[minAdd] && minAdd > point) {
                    minAdd--;
                }
                nums[point - 1] = nums[minAdd];
                nums[minAdd] = temp;
                Arrays.sort(nums, point, len);
                break;
            }
        }
        if (point == 0) {
            Arrays.sort(nums);
        }
    }
}
