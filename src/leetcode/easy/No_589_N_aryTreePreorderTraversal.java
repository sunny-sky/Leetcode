package leetcode.easy;

import leetcode.utils.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 13:58 2018/11/23
 * @Modified By:
 */
public class No_589_N_aryTreePreorderTraversal {
    public List<Integer> preorder (Node root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    private void helper (Node root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        for (Node node : root.children) {
            helper(node, list);
        }
    }

    public List<Integer> preorder2 (Node root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            list.add(temp.val);
            if (temp.children != null) {
                for (int i = temp.children.size() - 1; i >= 0 ; i--) {
                    stack.push(temp.children.get(i));
                }
            }
        }

        return list;
    }
}
