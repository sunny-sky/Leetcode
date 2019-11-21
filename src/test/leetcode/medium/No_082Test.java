package test.leetcode.medium;

import leetcode.medium.No_082;
import leetcode.medium.No_093;
import org.junit.Test;

import leetcode.utils.ListNode;
import java.util.ArrayList;
import java.util.List;

public class No_082Test {
    @Test
    public void deleteDuplicates() {
        ListNode example0 = new ListNode(1);
        ListNode example1 = new ListNode(2);
        ListNode example2 = new ListNode(3);
        ListNode example3 = new ListNode(3);
        ListNode example4 = new ListNode(4);
        ListNode example5 = new ListNode(4);
        ListNode example6 = new ListNode(5);

        example0.next = example1;
        example1.next = example2;
        example2.next = example3;
        example3.next = example4;
        example4.next = example5;
        example5.next = example6;

        ListNode example7 = new ListNode(1);
        ListNode example8 = new ListNode(1);
        example7.next = example8;

        No_082 func = new No_082();
        ListNode res = func.deleteDuplicates(example7);
        while (res != null) {
            System.out.println(res.val + "--");
            res = res.next;
        }
    }
}
