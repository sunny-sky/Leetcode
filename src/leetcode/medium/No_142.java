package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class No_142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            System.out.println("no cycle");
            return null;
        }
        ListNode point = head;
        Set<ListNode> set = new HashSet<>();
        int pos = 0;
        while (point != null) {
            if (set.contains(point)) {
                return point;
            } else {
                set.add(point);
                point = point.next;
            }
        }
        return null;
    }

    private ListNode helper(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return fast;
            }
        }

        return null;
    }
    public ListNode detectCycle1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode same = helper(head);
        if (same == null) {
            return null;
        } else {
            ListNode ptr11 = head;
            ListNode ptr2 = same;
            while (ptr11 != ptr2) {
                ptr11 = ptr11.next;
                ptr2 = ptr2.next;
            }
            return ptr11;
        }
    }
}
