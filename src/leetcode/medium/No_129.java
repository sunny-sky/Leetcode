package leetcode.medium;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No_129 {
    private Integer sum = 0;
    private Integer res = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        helper(root);
        return res;
    }

    // 回溯
    private void helper(TreeNode node) {
        // 退出
        if (node == null) {
            return;
        }

        // 递归
        sum *= 10;
        sum += node.val;
        if (node.left == null && node.right == null) {
            res += sum;
        }
        if (node.left != null) {
            helper(node.left);
        }
        if (node.right != null) {
            helper(node.right);
        }
        sum -= node.val;
        sum /= 10;
    }
}
