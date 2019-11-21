package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;



public class No_116 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        helper(root);
        return root;
    }

    // 按层遍历，入双端队列
    private void helper(Node root) {
        Deque<Node> temp1 = new LinkedList<>();
        Deque<Node> temp2 = new LinkedList<>();
        temp1.offer(root);
        while (!temp1.isEmpty()) {
            while (!temp1.isEmpty()) {
                Node tempNode = temp1.pollFirst();
                if (temp1.size() >= 1) {
                    tempNode.next = temp1.getFirst();
                }
                if (tempNode.left != null) {
                    temp2.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    temp2.offer(tempNode.right);
                }
            }
            temp1 = temp2;
            temp2 = new LinkedList<>();
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val,Node _left,Node _right,Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
}
