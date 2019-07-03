package leetcode.medium;

import leetcode.utils.ListNode;

import java.util.List;

public class No_092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
            // 判空和单个节点
            if (head == null || head.next == null) {
                return head;
            }
            // 头结点
            ListNode first = new ListNode(0);
            first.next = head;
            // 新建指针,1:m前一个位置，2：m位置，3：遍历指针
            ListNode pointer1 = first, pointer2, pointer3;
            // 找m前一个位置
            while (m - 1 > 0) {
                pointer1 = pointer1.next;
                m--;
                n--;
            }
            // 判是否需要反转
            if (pointer1 == null || pointer1.next == null || pointer1.next.next == null) {
                return head;
            }
            pointer2 = pointer1.next;
            pointer3 = pointer2.next;
            // 遍历
            while (pointer2.next != null && n - m > 0) {
                // 反转
                pointer2.next = pointer3.next;
                pointer3.next = pointer1.next;
                pointer1.next = pointer3;
                // 遍历下一个
                pointer3 = pointer2.next;
                n--;
            }
            return first.next;
    }
}
