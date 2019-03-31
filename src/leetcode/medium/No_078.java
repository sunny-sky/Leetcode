package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Liang
 * @Description: 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 * @Date: Created in 14:11 2019/3/27
 */
public class No_078 {
    /**
     * @Description 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
     * @Auther Liang
     * @date 14:11 2019/3/27
     * @param nums input int[]
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    /**
     * @Description
     * @Auther Liang
     * @date 14:23 2019/3/27
     * @param res 保存结果的list
     * @param tempList 临时存储，用于加入list
     * @param nums 输入int[]
     * @param start 起始位置
     * @return void
     */
    private void backtrack(List<List<Integer>> res, List<Integer> tempList, int [] nums, int start) {
        res.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(res, tempList, nums, i +1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
