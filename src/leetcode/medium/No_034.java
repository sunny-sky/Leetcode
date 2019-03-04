package leetcode.medium;

/**
 * @Author: Liang
 * @Description: 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 输入: nums = [5, 7, 7, 8, 8, 10], target = 8
 *              0  1  2  3  4   5
 * 输出: [3,4]
 * @Date: Created in 11:08 2019/3/2
 */
public class No_034 {
    /**
     * @Description 在排序数组中查找元素的第一个和最后一个位置
     * @Auther Liang
     * @date 11:08 2019/3/2
     * @param nums 输入数组
     * @param target 目标数
     * @return int[]
     */
    public int[] searchRange(int[] nums, int target) {
        // 先二分法找到某一个target，可确认存在target或不存在
        // 判断空数组
        int len = nums.length;
        if (len == 0) {
            return new int[]{-1, -1};
        }
        // 二分查target
        int firstTarget = -1;
        int head = 0, rear = len - 1, mid;
        while (head <= rear) {
            mid = (head + rear) / 2;
            if (nums[mid] == target) {
                firstTarget = mid;
                break;
            } else if (nums[mid] < target) {
                head = mid + 1;
            } else {
                rear = mid - 1;
            }
        }
        // 检查firstTarget 是否为-1，判断是否存在target
        if (firstTarget == -1) {
            return new int[]{-1, -1};
        }
        // 以第一部中找到的target为界，分为左右两部分（都含有该target），分别找分界点
        int resHead = headIndex(nums, target, firstTarget);
        int resRear = rearIndex(nums, target, firstTarget);
        return new int[]{resHead, resRear};
    }

    /**
     * @Description 从0到end位置查找第一个target
     * @Auther Liang
     * @date 13:31 2019/3/2
     * @param nums 输入数组
     * @param target 目标数
     * @param end 查询终点
     * @return int
     */
    private int headIndex(int[] nums, int target, int end) {
        // 二分法查等于target且前一个数小于target或不存在的位置
        int len = nums.length;
        int head = 0, rear = end, mid;
        while (head <= rear) {
            mid = (head + rear) / 2;
            // mid处等于target
            //     上个位置小于target或该处已是index 0 位置
            if (mid == 0 && nums[mid] == target) {
                return 0;
            } else if (mid > 0 && nums[mid] == target && nums[mid - 1] < target) {
                return mid;
            } else if (nums[mid] == target){
                rear = mid - 1;
            }
            // mid处不等于target
            if (nums[mid] < target) {
                head = mid + 1;
            } else if (nums[mid] > target) {
                rear = mid - 1;
            }
        }
        return - 1;
    }

    /**
     * @Description 从start到最后位置查找最后一个target
     * @Auther Liang
     * @date 13:51 2019/3/2
     * @param nums 输入数组
     * @param target 目标数
     * @param start 查询起点
     * @return int
     */
    private int rearIndex(int[] nums, int target, int start) {
        // 二分法查等于target且后一个数小于target或不存在的位置
        int len = nums.length;
        int head = start, rear = len - 1, mid;
        while (head <= rear) {
            mid = (head + rear) / 2;
            // mid处等于target
            //     下个位置大于target或该处已是len - 1 位置
            if (mid == len - 1 && nums[mid] == target) {
                return len - 1;
            } else if (mid < len - 1 && nums[mid] == target && nums[mid + 1] > target) {
                return mid;
            } else if (nums[mid] == target){
                head = mid + 1;
            }
            // mid处不等于target
            if (nums[mid] < target) {
                head = mid + 1;
            } else if (nums[mid] > target) {
                rear = mid - 1;
            }
        }
        return - 1;
    }
}
