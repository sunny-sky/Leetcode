package leetcode.medium;

public class No_153 {
    public int findMin(int[] nums) {
        // 判空
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 长度1直接返回答案
        if (nums.length == 1) {
            return nums[0];
        }
        int start = 0, end = nums.length - 1;
        // 二分查找，每次分有序一侧和乱序一侧
        while (start < end) {
            int mid = (start + end) / 2;
            // 因为是排序好的，所以小于上一个时必然是mid位置为最小值
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            // 左边有序，右边有交换，则最小在右侧
            if (nums[start] <= nums[mid] && nums[mid] > nums[end]) {
                start = mid + 1;
            } else { // 左边有交换，最小在左侧
                end = mid - 1;
            }
        }
        return nums[start];
    }
}
