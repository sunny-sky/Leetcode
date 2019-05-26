package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_047 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 判空
        if (nums == null || nums.length == 0) {
            return res;
        }
        boolean[] used = new boolean[nums.length];
        // 暂存临时队列，最终结果添加至res
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, used, list, res);
        return res;
    }

    private void dfs(int[] nums, boolean[] used, List<Integer> list,
                     List<List<Integer>> res) {
        // 一组长度够后终止
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        // 遍历nums中每个
        for (int i = 0; i < nums.length; i++) {
            // 若添加过则跳过本次
            if (used[i]) {
                continue;
            }
            // 本次和上次值相等且上次没用过（状态还原，表示该序列已添加过），跳过本次
            // 若上一个使用过，则认为是当前序列的相等值不同顺序的组合
            if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            // 设为用过状态
            used[i] = true;
            list.add(nums[i]);
            // 递归添加其他未使用元素至符合退出条件
            dfs(nums, used, list, res);
            // 还原状态，生成不同顺序序列
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
