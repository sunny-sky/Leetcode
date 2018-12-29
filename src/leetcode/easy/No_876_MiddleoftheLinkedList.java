package leetcode.easy;

public class No_876_MiddleoftheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        int mid = length / 2;
        temp = head;
        for (int i = 1; i <= mid; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
