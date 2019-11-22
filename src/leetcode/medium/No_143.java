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
}
