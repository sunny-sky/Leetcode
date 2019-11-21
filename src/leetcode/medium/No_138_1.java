package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class No_138_1 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node res = new Node(head.val, null, null);
        Map<Node, Node> visited = new HashMap<>();
        visited.put(head, res);
        Node point_head = head;
        Node point_res = res;
        while (point_head != null) {
            if (point_head.next == null) {
                point_res.next = null;
            } else if (visited.containsKey(point_head.next)) {
                point_res.next = visited.get(point_head.next);
            } else {
                Node temp_next = new Node(point_head.next.val, null, null);
                visited.put(point_head.next, temp_next);
                point_res.next = temp_next;
            }
            if (point_head.random == null) {
                point_res.random = null;
            } else if (visited.containsKey(point_head.random)) {
                point_res.random = visited.get(point_head.random);
            } else {
                Node temp_random = new Node(point_head.random.val, null, null);
                visited.put(point_head.random, temp_random);
                point_res.random = temp_random;
            }

            point_head = point_head.next;
            point_res = point_res.next;
        }
        return res;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
