package leetcode.easy;

/**
 * @Author: Liang
 * @Description: 给定一个长度为 n 的非空整数数组，找到让数组所有元素相等的最
 * 小移动次数。每次移动可以使 n - 1 个元素增加 1。
 * @Date: Created in 14:34 2019/1/21
 */
public class No_453 {
    /**
     * @Description 最小移动次数使数组元素相等
     * @Auther Liang
     * @date 14:35 2019/1/21
     * @param nums int[]
     * @return int
     */
    public int minMoves(int[] nums) {
        int min = nums[0];
        long sum = 0;
        for (int num : nums) {
            if (min > num) {
                min = num;
            }
        }
        for (int num : nums) {
            sum += num - min;
        }
        return (int) sum;
    }
}
