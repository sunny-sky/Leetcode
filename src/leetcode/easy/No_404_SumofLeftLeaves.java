package leetcode.easy;

import leetcode.utils.TreeNode;

/**
 * @Author: Liang
 * @Description: 计算给定二叉树的所有左叶子之和。
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * @Date: Created in 14:50 2018/11/14
 * @Modified By:
 */
public class No_404_SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        int ans = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            ans += root.left.val;
        }
        if (root.left != null)
            ans += sumOfLeftLeaves(root.left);
        if (root.right != null)
            ans += sumOfLeftLeaves(root.right);
        return ans;
    }

}
