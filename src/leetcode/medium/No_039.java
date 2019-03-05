package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Liang
 * @Description: 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates
 * 中所有可以使数字和为 target 的组合。追踪end
 *
 * candidates 中的数字可以无限制重复被选取。
 * @Date: Created in 8:53 2019/3/4
 */
public class No_039 {
    /**
     * @param candidates 输入数组
     * @param target     目标数
     * @return java.util.List<java.util.List < java.lang.Integer>>
     * @Description 1.数组排序，初始值加入map，和为索引，值为List；2.遍历索引，每个值
     * @Auther Liang
     * @date 8:54 2019/3/4
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listAll = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // 排序
        Arrays.sort(candidates);
        find(listAll, list, candidates, target, 0);
        return listAll;
    }

    /**
     * @Description 递归
     * @Auther Liang
     * @date 16:46 2019/3/5
     * @param listAll 结果数组
     * @param tmp 临时数组，待加入结果数组中
     * @param candidates 输入数组
     * @param target 目标值
     * @param num 起点
     */
    private void find(List<List<Integer>> listAll, List<Integer> tmp, int[] candidates, int target, int num) {
        // 递归的终点
        if (target == 0) {
            listAll.add(tmp);
            return;
        }
        // 当前target无符合要求结果
        if (target < candidates[num]) {
            return;
        }
        for (int i = num; i < candidates.length && candidates[i] <= target; i++) {
            // 深拷贝
            List<Integer> list = new ArrayList<>(tmp);
            list.add(candidates[i]);
            // 递归运算，将i传递至下一次运算，避免结果重复
            find(listAll, list, candidates, target - candidates[i], i);
        }
    }
}