package leetcode.easy;

import leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 12:38 2018/11/27
 * @Modified By:
 */
public class No_653_TwoSumIV_InputisaBST {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;
        Map<Integer, Integer> map = new HashMap<>();

        return helper(root, k, map);
    }

    private boolean helper (TreeNode root, int k, Map<Integer, Integer> map) {
        if (root == null)
            return false;

        if (map.containsKey(root.val))
            return true;

        map.put(k - root.val, 1);

        return helper(root.left, k, map) || helper(root.right, k, map);
    }
}
