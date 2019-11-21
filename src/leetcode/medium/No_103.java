package leetcode.medium;

import leetcode.utils.TreeNode;

import java.util.*;

public class No_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        boolean flag = false;
        Deque<TreeNode> deque1 = new LinkedList<>();
        Deque<TreeNode> deque2 = new LinkedList<>();
        deque1.offer(root);
        while (!deque1.isEmpty() || !deque2.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            while (!deque1.isEmpty()) {
                TreeNode tempNode = deque1.pollLast();
                temp.add(tempNode.val);
                if (flag) {
                    if (tempNode.right != null) {
                        deque2.offer(tempNode.right);
                    }
                    if (tempNode.left != null) {
                        deque2.offer(tempNode.left);
                    }
                } else {
                    if (tempNode.left != null) {
                        deque2.offer(tempNode.left);
                    }
                    if (tempNode.right != null) {
                        deque2.offer(tempNode.right);
                    }
                }
            }
            res.add(temp);
            deque1 = deque2;
            deque2 = new LinkedList<>();
            flag = !flag;
        }
        return res;
    }
}
