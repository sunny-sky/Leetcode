package leetcode.medium;

import leetcode.utils.ListNode;

public class No_061 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode  fast = dummy, slow = dummy;

        int i;
        for (i = 0; fast.next != null; i++) {
            fast = fast.next;
        }
        for (int j = i - k % i; j > 0; j--) {
            slow = slow.next;
        }
        // 回转
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }
}
