package leetcode.easy;

public class No_141_LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;
        if (head.next == head)
            return true;

        ListNode sec = head.next;
        while (sec.next != null ) {
            ListNode first = head;
            while (first != sec) {
                if (first == sec.next)
                    return true;
                else {
                    first = first.next;
                }
            }
            sec = sec.next;
        }
        return false;
    }

    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            if (slow == fast)
                return true;
            else {
                slow = slow.next;
                fast = fast.next.next;
            }
        }
        return false;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode makeL () {
        ListNode l_0 = new ListNode(-1);
        ListNode l_1 = new ListNode(-7);
        ListNode l_2 = new ListNode(7);
        ListNode l_3 = new ListNode(-4);
        ListNode l_4 = new ListNode(19);
        ListNode l_5 = new ListNode(6);
        ListNode l_6 = new ListNode(-9);
        ListNode l_7 = new ListNode(-5);
        ListNode l_8 = new ListNode(-2);
        l_0.next = l_1;
        l_1.next = l_2;
        l_2.next = l_3;
        l_3.next = l_4;
        l_4.next = l_5;
        l_5.next = l_6;
        l_6.next = l_7;
        l_7.next = l_8;
        l_8.next = l_7;
        return l_0;
    }

    public static void main(String[] args) {
        No_141_LinkedListCycle ob = new No_141_LinkedListCycle();
        ListNode l0 = ob.makeL();
        System.out.println(hasCycle(l0));
    }
}
