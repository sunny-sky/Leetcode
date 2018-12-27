package leetcode.easy;

public class No_707_DesignLinkedList {
    ListNode head = null;
    private int length = 0;

    /** Initialize your data structure here. */
    public void MyLinkedList() {
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (length == 0 || index > length - 1) {
            return -1;
        } else {
            ListNode res = head;
            for (int i = 1; i <= index; ++i) {
                res = res.next;
            }
            return res.val;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        System.out.println(length);
        ListNode res = new ListNode(val);
        if (length == 0) {
            head = res;
        } else {
            res.next = head;
            head = res;
        }
        length++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode res = new ListNode(val);
        if (length == 0) {
            head = res;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = res;
        }
        length++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > length)
            return;
        else if (length == index) {
            addAtTail(val);
        } else {
            ListNode pre = head,rear, temp = new ListNode(val);
            for (int i = 1; i < index; ++i) {
                pre = pre.next;
            }
            rear = pre.next;
            pre.next = temp;
            temp.next = rear;
            length++;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index <= length -1) {
            ListNode pre = head;
            for (int i = 1; i < index; ++i) {
                pre = pre.next;
            }
            pre.next = pre.next.next;
            length--;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode (int x) {
            val = x;
        }
    }
}
