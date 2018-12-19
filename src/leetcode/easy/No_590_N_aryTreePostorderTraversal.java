package leetcode.easy;

import leetcode.utils.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 10:12 2018/11/24
 * @Modified By:
 */
public class No_590_N_aryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(root, list);

        return list;
    }

    private void helper (Node root, List<Integer> list) {
        if (root == null)
            return;
        if (root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                helper(root.children.get(i), list);
            }
        }

        list.add(root.val);
    }

    public List<Integer> postorder1(Node root) {
        if (root == null)
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        stack.push(root);

        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            if (!stack.isEmpty() && temp == stack.peek()) {
                for (int i = temp.children.size() - 1; i >= 0; i--) {
                    stack.push(temp.children.get(i));
                    stack.push(temp.children.get(i));
                }
            } else {
                list.add(temp.val);
            }
        }

        return list;
    }

    public List<Integer> postorder2 (Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        for (Node node : root.children) {
            list.addAll(postorder2(node));
        }

        list.add(root.val);
        return list;
    }

}
