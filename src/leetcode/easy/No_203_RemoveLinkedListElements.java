package leetcode.easy;

public class No_203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = new ListNode(0), rear = head, res = pre;
        pre.next = rear;
        while (rear != null) {
            if (rear.val == val) {
                rear = rear.next;
                pre.next = rear;
            } else {
                rear = rear.next;
                pre = pre.next;
            }
        }
        return res.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
