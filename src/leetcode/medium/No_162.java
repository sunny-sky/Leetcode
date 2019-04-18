package leetcode.medium;

public class No_162 {
    public int findPeakElement(int[] nums) {
        int len = nums.length;
        // 长度为1时
        if (len == 1) {
            return 0;
        }
        // 初始化 左右位置
        int left = 0, right = len - 1;
        // 循环二分查找
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            // 必有峰值在右侧
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else { // 必有峰值在左侧
                right = mid;
            }
        }
        // 从左右两位置中返回峰值位置
        return (left == len - 1 || nums[left] > nums[left + 1]) ? left : right;
    }
}
