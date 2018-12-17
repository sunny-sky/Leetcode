package leetcode.easy;

import leetcode.utils.TreeNode;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 13:08 2018/11/22
 * @Modified By:
 */
public class No_572_SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        System.out.println("比较节点s:"+s);
        System.out.println("比较节点t:"+t);
        if (t == null)
            return true;
        if (s == null)
            return false;
        if (helper(s, t)) {
            return true;
        } else {
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }

    }

    private boolean helper(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null || s.val != t.val) {
            return false;
        }

        return helper(s.left, t.left) && helper(s.right, t.right);
    }
}
