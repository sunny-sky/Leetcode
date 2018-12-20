package leetcode.easy;

import leetcode.utils.TreeNode;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 16:21 2018/11/25
 * @Modified By:
 */
public class No_617_MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        helper(t1, t2);
        return t1;
    }

    private void helper (TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return;
        if (t1 != null && t2 != null) {
            t1.val += t2.val;
            if (t1.left != null || t2.left != null) {
                if (t1.left == null) {
                    t1.left = new TreeNode(0);
                }
                helper(t1.left, t2.left);
            }
            if (t1.right != null || t2.right != null) {
                if (t1.right == null) {
                    t1.right = new TreeNode(0);
                }
                helper(t1.right, t2.right);
            }
        }
    }
}
