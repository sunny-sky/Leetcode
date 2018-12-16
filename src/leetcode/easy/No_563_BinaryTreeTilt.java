package leetcode.easy;

import leetcode.utils.TreeNode;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 14:06 2018/11/21
 * @Modified By:
 */
public class No_563_BinaryTreeTilt {
    public int findTilt(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null)
            return 0;
        int tile =  helper(root.left) + helper(root.right);
        int left = 0, right = 0;
        if (root.left != null) {
            root.val += root.left.val;
            left = root.left.val;
        }
        if (root.right != null) {
            root.val += root.right.val;
            right = root.right.val;
        }
        return tile += Math.abs(left - right);
    }
}
