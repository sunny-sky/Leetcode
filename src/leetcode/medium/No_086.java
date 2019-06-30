package leetcode.medium;

import leetcode.utils.ListNode;

public class No_086 {
    public ListNode partition(ListNode head, int x) {
        // 判空
        if (head == null) {
            return head;
        }
        // 设置头节点
        ListNode first = new ListNode(0);
        first.next = head;
        // 寻找首个大于等于x的前一个节点
        ListNode pointer1 = first;
        while (pointer1.next != null && pointer1.next.val < x) {
            pointer1 = pointer1.next;
        }
        // 无小于x的节点
        if (pointer1.next == null) {
            return head;
        }
        // 扫描之后的节点
        ListNode pointer2 = pointer1.next;
        ListNode pointer3 = pointer2.next;
        while (pointer2.next != null) {
            if (pointer2.next.val < x) {
                pointer2.next = pointer3.next;
                pointer3.next = pointer1.next;
                pointer1.next = pointer3;
                pointer3 = pointer2.next;
                pointer1 = pointer1.next;
            } else {
                pointer2 = pointer2.next;
                pointer3 = pointer3.next;
            }
        }
        return first.next;
    }
    //  tou   [2, 1]
    //first--po2--po3
    // po1
}
