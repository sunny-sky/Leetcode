package leetcode.medium;

import leetcode.utils.TreeNode;

public class No_114 {
    private TreeNode pointer;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        // 将左右树分开，便于使用root
        TreeNode left = root.left;
        TreeNode right = root.right;
        pointer = root;
        helper(left);
        helper(right);
        // 清楚左节点
        pointer = root;
        while (pointer != null) {
            pointer.left = null;
            pointer = pointer.right;
        }
    }

    // 先序遍历
    private void helper(TreeNode node) {
        // 退出
        if (node == null) {
            return;
        }

        //先序递归,要记录node的左右节点，因为操作会改变node的右节点
        TreeNode left = node.left;
        TreeNode right = node.right;
        pointer.right = node;
        pointer = pointer.right;
        helper(left);
        helper(right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        node5.right = node6;

        No_114 sample = new No_114();
        sample.flatten(node1);
        System.out.println(node1);
    }
}
