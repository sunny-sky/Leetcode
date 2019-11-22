package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class No_143 {
    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> temp = new ArrayList<>();
        ListNode pointer = head;
        while (pointer != null) {
            temp.add(pointer);
            pointer = pointer.next;
        }
        pointer = head;
        int i = 1;
        int j = temp.size() - 1;
        while (i < j) {
            pointer.next = temp.get(j--);
            pointer = pointer.next;
            pointer.next = temp.get(i++);
            pointer = pointer.next;
        }
        if (i == j) {
            pointer.next = temp.get(i);
            pointer = pointer.next;
        }
        pointer.next = null;

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node0 = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        reorderList(node0);
        while (node0 != null) {
            System.out.println(node0.val);
            node0 = node0.next;
        }

    }

    public static void reorderList1(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        int len = 0;
        ListNode h = head;
        while (h != null) {
            len++;
            h = h.next;
        }
        helper1(head, len);
    }

    private static ListNode helper1(ListNode head, int len) {
        if (len == 1) {
            ListNode outTail = head.next;
            head.next = null;
            return outTail;
        } else if (len == 2) {
            ListNode outTail = head.next.next;
            head.next.next = null;
            return outTail;
        }

        ListNode tail = helper1(head.next, len - 2);
        ListNode subHead = head.next;
        head.next = tail;
        ListNode outTail = tail.next;
        tail.next = subHead;
        return  outTail;
    }

    public static void reorderList2(ListNode head, int len) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;

        newHead = reverseList(newHead);

        while (newHead != null) {
            ListNode temp = newHead.next;
            newHead.next = head.next;
            head.next = newHead;
            head = newHead.next;
            newHead = temp;
        }

    }

    private static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 头结点first
        ListNode first = new ListNode(0);
        first.next = head;
        head = head.next;
        first.next.next = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = first.next;
            first.next = head;
            head = temp;
        }
//        head = first.next;
//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }
        return first.next;
    }
}
