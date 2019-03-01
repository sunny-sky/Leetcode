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
            // 逆序则后退一位
            if (nums[point] <= nums[point - 1]) {
                point--;
            } else { // temp存交换数
                int temp = nums[point - 1];
                while (nums[point - 1] >= nums[minAdd] && minAdd > point) {
                    minAdd--;
                }
                nums[point - 1] = nums[minAdd];
                nums[minAdd] = temp;
                Arrays.sort(nums, point, len); // 此处排序为nlogn
                break;
            }
        }
        if (point == 0) {
            Arrays.sort(nums);
        }
    }

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
    public void nextPermutation2(int[] nums) {
        // i为倒数第二个数的索引
        int i = nums.length - 2;
        // 找出倒序的首个逆序位置，-1时代表数组完全逆序
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            // j为倒数第一个数的索引
            int j = nums.length - 1;
            // 找到第一个交换i使数字变大的数
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // 交换i，j位置
            swap(nums, i, j);
        }
        // 若逆序，直接翻转，否则翻转交换i后的部分，以保证其最小
        reverse(nums, i + 1);
    }

    /**
     * @Description 交换数组中的i和j位置的数
     * @Auther Liang
     * @date 0:03 2019/3/2
     * @param nums 目标数组
     * @param i 交换数1索引值
     * @param j 交换数2索引值
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * @Description 从start起，反转数组
     * @Auther Liang
     * @date 0:06 2019/3/2
     * @param nums 目标数组
     * @param start 起始位置
     */
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
