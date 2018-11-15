package leetcode.easy;

import leetcode.utils.TreeNode;

public class No_235_LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val >= p.val && root.val <= q.val ||root.val <= p.val && root.val >= q.val)
            return root;
        if (p.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        return lowestCommonAncestor(root.right, p, q);
    }
}
