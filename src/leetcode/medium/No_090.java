package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Liang
 * @Description: 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 * @Date: Created in 23:17 2019/4/10
 */
public class No_090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> each = new ArrayList<>();
        helper(res, each, 0, nums);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
        // each加入res
        if (pos <= n.length) {
            res.add(each);
        }
        // 去重复
        int i = pos;
        while (i < n.length) {
            // each中一次加入n中i之后的元素
            each.add(n[i]);
            // 递归
            helper(res, new ArrayList<>(each), i + 1, n);
            // 移除新加入的n[i]，为下次循环做准备
            each.remove(each.size() - 1);
            i++;
            // 跳过重复项
            while (i < n.length && n[i] == n[i - 1]) {
                i++;
            }
        }
    }
}
