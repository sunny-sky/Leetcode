package leetcode.easy;

public class No_206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        else if (head.next == null)
            return head;

        ListNode pre = new ListNode(0), rear, res;
        pre.next = head;
        res = pre;
        pre = head.next;
        rear = pre.next;
        while (pre != null) {
            pre.next = res.next;
            res.next = pre;
            head.next = rear;
            pre = rear;
            if (rear == null)
                break;
            else
                rear = rear.next;
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
