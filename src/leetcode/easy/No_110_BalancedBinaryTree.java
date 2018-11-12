package leetcode.easy;

import leetcode.utils.TreeNode;

public class No_110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        else if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1)
            return false;
        return (isBalanced(root.left) && isBalanced(root.right));
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return 1;
        } else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }
}
