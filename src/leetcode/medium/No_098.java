package leetcode.medium;

import leetcode.utils.TreeNode;

public class No_098 {
    public Integer temp;
    // 中序遍历，若按顺序排列则true，否则false
    public boolean isValidBST(TreeNode root) {
        // 判空和单节点
        if (root == null || root.left == null && root.right == null) {
            return true;
        }

        return midOrder(root);
    }

    // 中序遍历
    private boolean midOrder(TreeNode node) {
        // 退出遍历
        // 叶子节点
        if (node == null) {
            return true;
        }

        // 遍历,先左再中再右,中时比较，符合刷新temp值，不符合返回false
        boolean res = true;
        if (node.left != null) {
            res = res && midOrder(node.left);
        }
        if (null == temp || temp < node.val) {
            temp = node.val;
        } else {
            return false;
        }
        if (node.right != null) {
            res = res && midOrder(node.right);
        }
        return res;
    }
}
