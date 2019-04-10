package leetcode.medium;

/**
 * @Author: Liang
 * @Description: 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * @Date: Created in 17:57 2019/3/30
 */
public class No_081 {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 若左边为排序部分
            if (nums[start] < nums[mid]) {
                if (target < nums[start] || target > nums[mid]) {
                    // 目标在旋转部分
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else if (nums[start] > nums[mid]) {
                // 左半边为含旋转的部分

                // 目标值在旋转部分
                if (target < nums[mid] || target > nums[end]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // nums[start] == nums[mid] != target,此时start++，最差为O（n）
                start++;
            }
        }
        return false;
    }
}
