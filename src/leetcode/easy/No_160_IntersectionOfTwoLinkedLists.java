package leetcode.easy;

public class No_160_IntersectionOfTwoLinkedLists {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 得出两表长度
        ListNode pntA = headA, pntB = headB;
        int lenA = 1, lenB = 1;
        while (headA.next != null) {
            lenA += 1;
            headA = headA.next;
        }
        while (headB.next != null) {
            lenB += 1;
            headB = headB.next;
        }
        // 若最后一个节点不等，必无公共节点
        if (headA != headB)
            return null;
        // 以长度差为指针，减去长链多出部分后一一比较
        headA = pntA;
        headB = pntB;
        if (lenA >= lenB) {
            int point = lenA - lenB;
            for (int i = 0; i < point; ++i) {
                headA = headA.next;
            }

        } else {
            int point = lenB - lenA;
            for (int i = 0; i < point; ++i) {
                headB = headB.next;
            }
        }
        // 等长后遍历
        while (headA != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
