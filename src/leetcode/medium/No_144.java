package leetcode.medium;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No_144 {
    // 递归
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res) {
        // 退出递归,叶子节点
        if (node == null) {
            return;
        }

        // 递归
        res.add(node.val);
        if (node.left != null) {
            helper(node.left, res);
        }
        if (node.right != null) {
            helper(node.right, res);
        }
        return;
    }

    // 迭代
    public List<Integer> preorderTraversal_1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }

    // 莫里斯遍历，空间复杂度O（1）
    public List<Integer> preorderTraversal_2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        LinkedList<Integer> output = new LinkedList<>();

        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                output.add(node.val);
                node = node.right;
            } else {
                TreeNode predecessor = node.left;
                while ((predecessor.right != null) && (predecessor.right != node)) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    output.add(node.val);
                    predecessor.right = node;
                    node = node.left;
                } else {
                    predecessor.right = null;
                    node = node.right;
                }
            }
        }
        return output;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
