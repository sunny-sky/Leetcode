package leetcode.medium;

import leetcode.utils.ListNode;

public class No_082 {
    // first->1->2->3->3->4->4->5
    public ListNode deleteDuplicates(ListNode head) {
        // 判空或只有一个节点
        if (head == null || head.next == null) {
            return head;
        }
        // 设头结点
        ListNode first = new ListNode(0);
        first.next = head;
        // 指针
        ListNode pointer1 = first, pointer2 = head;
        // 遍历每个节点
        while (pointer2.next != null) {
            // 值不等，指针后移
            if (pointer2.next != null && pointer2.val != pointer2.next.val) {
                pointer1 = pointer2;
                pointer2 = pointer2.next;
            } else {
                // 该节点与其下一个节点值重复
                // 指针2移动到最后一个同值节点
                while (pointer2.next != null && pointer2.val == pointer2.next.val) {
                    pointer2 = pointer2.next;
                }
                if (pointer2.next == null) {
                    pointer1.next = null;
                    break;
                } else {
                    pointer1.next = pointer2.next;
                    pointer2 = pointer2.next;
                }
            }
        }
        return first.next;
    }
}
