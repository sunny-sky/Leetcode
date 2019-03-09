package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Liang
 * @Description: 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * @Date: Created in 14:14 2019/3/9
 */
public class No_040 {
    /**
     * @Description 存放最终结果
     * @Auther Liang
     * @date 14:25 2019/3/9
     */
    private List<List<Integer>> res = new ArrayList<>();
    /**
     * @Description 组合总和 II
     * @Auther Liang
     * @date 14:16 2019/3/9
     * @param candidates 输入数组
     * @param target 目标数
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        recursive(candidates, target, list, 0);
        return res;
    }
    /**
     * @Description 递归寻找符合条件的数组
     * @Auther Liang
     * @date 14:21 2019/3/9
     * @param candidates 输入数组
     * @param tempTarget 当前目标数
     * @param list 存放当前已存在结果
     * @param startIndex 当前起始扫描位置
     */
    private void recursive(int[] candidates, int tempTarget, List<Integer> list, int startIndex) {
        // 非重复遍历数组，确定每个以不同数开头的满足条件的组合
        for (int i = startIndex; i < candidates.length; i++) {
            List<Integer> tempList = new ArrayList<>(list);
            // 当前值对应的tempTarget
            int newTarget = tempTarget - candidates[i];
            tempList.add(candidates[i]);
            if (newTarget == 0) {
                res.add(tempList);
            } else if (newTarget > 0) {
                recursive(candidates, newTarget, tempList, i + 1);
            }
            // 去重复
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }
}
