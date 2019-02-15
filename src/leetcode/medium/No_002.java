package leetcode.medium;

import leetcode.utils.ListNode;

/**
 * @Author: Liang
 * @Description: 两数相加,链表
 * @Date: Created in 19:37 2019/1/29
 */
public class No_002 {
    /**
     * @Description 两数相加,链表
     * @Auther Liang
     * @date 19:37 2019/1/29
     * @param l1 链表节点
     * @param l2 链表节点
     * @return ListNode
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode res = l1;
        while (l1 != null) {
            int sum = l1.val + l2.val + flag;
            l1.val = sum % 10;
            flag = sum / 10;
            if (l1.next == null && l2.next != null) {
                l1.next = new ListNode(0);
            } else if (l1.next != null && l2.next == null) {
                l2.next = new ListNode(0);
            } else if (l1.next == null && flag != 0) {
                l1.next = new ListNode(0);
                l2.next = new ListNode(0);
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return res;
    }
}
