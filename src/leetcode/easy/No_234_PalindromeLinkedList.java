package leetcode.easy;

public class No_234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode pre = head, rear;
        int len = 1;
        while (pre.next != null) {
            pre = pre.next;
            len++;
        }
        pre = head;
        rear = head;
        int num;
        if (len % 2 == 1)
            num = len + 1;
        else
            num = len;
        for (int i = 0; i < num / 2; i++) {
            rear = rear.next;
        }
        rear = reverseList(rear);

        for (int j = 0; j < len / 2; j++) {
            if (rear.val != pre.val)
                return false;
            else {
                rear = rear.next;
                pre = pre.next;
            }
        }
        return true;
    }

    public static ListNode reverseList(ListNode head) {
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
