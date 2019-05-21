package leetcode.medium;

import leetcode.utils.ListNode;

public class No_024 {
    public ListNode swapPairs(ListNode head) {
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode front = temp;
        ListNode rear = head;
        while (rear != null && rear.next != null) {
            front.next = rear.next;
            rear.next = front.next.next;
            front.next.next = rear;
            front = rear;
            rear = rear.next;
        }
        return temp.next;
    }
}
