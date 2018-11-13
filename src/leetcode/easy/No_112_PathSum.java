package leetcode.easy;

import leetcode.utils.TreeNode;

public class No_112_PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        root.val = sum - root.val;
        return manus(root);
    }

    private Boolean manus(TreeNode root) {
        if (root == null || root.left == null && root.right == null && root.val != 0)
            return false;
        if (root.left == null && root.right == null && root.val == 0)
            return true;
        if (root.left != null) {
            root.left.val = root.val - root.left.val;
        }
        if (root.right != null) {
            root.right.val = root.val - root.right.val;
        }
        return manus(root.left) || manus(root.right);
    }
}
