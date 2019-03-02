package leetcode.medium;

/**
 * @Author: Liang
 * @Description: 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * @Date: Created in 12:59 2019/2/27
 */
public class No_033 {
    /**
     * @param nums   输入数组
     * @param target 搜索目标数
     * @return int 目标索引
     * @Description 搜索旋转排序数组
     * eg. [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]
     * @Auther Liang
     * @date 12:59 2019/2/27
     */
    public int search1(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        int minIndex = -1;
        int head = 0, rear = len - 1, mid = (head + rear) / 2;
        // 寻找最小值索引
        if (nums[0] < nums[len - 1]) {
            minIndex = 0;
        } else {
            while (head <= rear) {
                if (nums[mid] < nums[(mid + len - 1) % len] && nums[mid] < nums[(mid + 1) % len]) {
                    minIndex = mid;
                    break;
                } else if (nums[mid] < nums[0]) {
                    rear = mid - 1;
                } else if (nums[mid] > nums[0]) {
                    head = mid + 1;
                }
                mid = (head + rear) / 2;
            }
        }
        // 确定target所在区域
        if (minIndex == 0) {
            return biSearch(nums, 0, len - 1, target);
        }
        int start, end;
        if (target == nums[0]) {
            return 0;
        } else if (target < nums[0]) {
            start = minIndex;
            end = len - 1;
        } else {
            start = 0;
            end = minIndex - 1;
        }
        // 二分查找
        return biSearch(nums, start, end, target);

    }

    /**
     * @param nums   要查找数组
     * @param start  查找起点索引
     * @param end    查找终点
     * @param target 查找目标
     * @return int 结果索引
     * @Description 二分查找
     * @Auther Liang
     * @date 13:30 2019/2/27
     */
    private static int biSearch(int[] nums, int start, int end, int target) {
        int len = nums.length;
        int mid = (start + end) / 2;
        while (start <= end) {
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = (start + end) / 2;
        }
        return -1;
    }

    /**
     * @param nums   输入数组
     * @param target 搜索目标数
     * @return int 目标索引
     * @Description 搜索旋转排序数组
     * eg. [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]
     * @Auther Liang
     * @date 12:59 2019/2/27
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }

        int head = 0, rear = len - 1, mid = (head + rear) / 2;
        // 未旋转
        if (nums[0] <= nums[len - 1]) {
            return biSearch(nums, 0, len - 1, target);
        }
        // 存在旋转
        while (head <= rear) {  // 根据 mid在前后半段，target位于前后半段，分四中情况
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[0] && target < nums[0]) { // mid后半，target后半
                if (nums[mid] <= target) {
                    return biSearch(nums, mid, rear, target);
                } else {
                    rear = mid - 1;
                }
            } else if (nums[mid] >= nums[0] && target >= nums[0]) { // mid、target前半
                if (nums[mid] >= target) {
                    return biSearch(nums, head, mid, target);
                } else {
                    head = mid + 1;
                }
            } else if (nums[mid] < nums[0] && target >= nums[0]) { // mid后半，target前半
                rear = mid - 1;
            } else { // mid 前半 ，target后半
                head = mid + 1;
            }
            mid = (head + rear) / 2;
        }
        return -1;
    }
}
