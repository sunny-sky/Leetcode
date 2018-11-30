package leetcode.easy;

import leetcode.utils.TreeNode;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 16:54 2018/11/19
 * @Modified By:
 */
public class No_543_DiameterofBinaryTree {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null)
            return 0;
        maxDepth(root);

        return max;
    }

    private int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            max = max < 1 ? 1 : max;
            return 1;
        }
        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);
        max = max < maxLeft + maxRight ? maxLeft + maxRight : max;
        return Math.max(maxLeft, maxRight) + 1;
    }
}
