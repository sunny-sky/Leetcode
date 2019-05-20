package leetcode.medium;

import leetcode.utils.ListNode;

public class No_019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        int i = 0, j = 0;
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode node_i = temp;
        ListNode node_j = temp;
        for (;i < n; i++) {
            node_i = node_i.next;
        }
        while (node_i != null && node_i.next != null) {
            node_i = node_i.next;
            node_j = node_j.next;
        }

        node_j.next = node_j.next.next;
        return temp.next;

    }
}
