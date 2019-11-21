package leetcode.medium;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 判空
        if (root == null) {
            return new ArrayList<>();
        } else if (root.left == null && root.right == null) {
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            res.add(temp);
            return res;
        }
        // 2个队列
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if (root.left != null) {
            queue1.offer(root.left);
        }
        if (root.right != null) {
            queue1.offer(root.right);
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        res.add(temp);
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            temp = new ArrayList<>();
            while (!queue1.isEmpty()) {
                TreeNode tempNode = queue1.poll();
                temp.add(tempNode.val);
//                System.out.println("加入节点" + tempNode.val);
                if (tempNode.left != null) {
                    queue2.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue2.offer(tempNode.right);
                }
            }
            // queue1空后，temp加入结果中
            res.add(temp);
            // 重置queue1和queue2
            queue1 = queue2;
            queue2 = new LinkedList<>();
        }

        return res;
    }
}
