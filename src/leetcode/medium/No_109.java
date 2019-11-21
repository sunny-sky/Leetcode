package leetcode.medium;

import leetcode.utils.ListNode;
import leetcode.utils.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class No_109 {
    public List<Integer> list;
    public TreeNode res;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
//        System.out.println(list.toString());
        res = new TreeNode(list.get((list.size() - 1) / 2));
        helper(0, list.size() - 1, res);
        return res;
    }

    // 递归二分列表，构造树,node为父节点，start到（start + end） / 2 - 1为左边
    private void helper (int start, int end, TreeNode node) {
        // 退出
        if (start > end) {
            return;
        }

        // 递归
        int center = (start + end) / 2;
        if (start < center) {
            TreeNode tempNode = new TreeNode(list.get((start + center - 1) / 2));
            node.left = tempNode;
            helper(start, center - 1, tempNode);
        }
        if (end > center) {
            TreeNode tempNode = new TreeNode(list.get((center + 1 + end) / 2));
            node.right = tempNode;
            helper(center + 1, end, tempNode);
        }
    }
}
