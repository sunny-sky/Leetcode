package leetcode.easy;

import leetcode.utils.TreeNode;

public class No_100_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if ((p == null && q != null) || (p != null && q == null) || p.val != q.val)
            return false;
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;

        return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
