package leetcode.medium;

/**
 * @Author: Liang
 * @Description: 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 * @Date: Created in 11:18 2019/3/21
 */
public class No_055 {
    /**
     * @Description 跳跃游戏，倒着遍历，看前面有无可跳到的点
     * @Auther Liang
     * @date 14:49 2019/3/21
     * @param nums 输入数组
     * @return boolean
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}
