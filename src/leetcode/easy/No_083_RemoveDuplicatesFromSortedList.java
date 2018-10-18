package leetcode.easy;

public class No_083_RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode first = head;
        ListNode sec = head.next;
        while (sec != null) {
            if (first.val == sec.val) {
                sec = sec.next;
                first.next = sec;
            } else {
                first = sec;
                sec = sec.next;
            }
        }
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
