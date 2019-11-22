package leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

public class No_117 {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        helper(root);
        return root;
    }

    private void helper(Node node) {
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue1.offer(node);
        while (!queue1.isEmpty()) {
            while (!queue1.isEmpty()) {
                Node temp = queue1.poll();
                if (!queue1.isEmpty()) {
                    temp.next = queue1.peek();
                }
                if (temp.left != null) {
                    queue2.offer(temp.left);
                }
                if (temp.right != null) {
                    queue2.offer(temp.right);
                }
            }
            queue1 = queue2;
            queue2 = new LinkedList<>();
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
    }
}
