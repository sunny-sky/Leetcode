package leetcode.easy;

import leetcode.utils.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Liang
 * @Description: 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * @Date: Created in 15:04 2018/11/14
 * @Modified By:
 */
public class No_429_N_aryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null)
            return new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int num = 1, numLower = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<Node> nodes;
        while (!queue.isEmpty()) {
            temp.add(queue.peek().val);
            nodes = queue.poll().children;
            num--;
            if (nodes != null) {
                for (Node node : nodes) {
                    queue.offer(node);
                    numLower++;
                }
            }
            if (num == 0) {
                num = numLower;
                numLower = 0;
                ans.add(temp);
                temp = new ArrayList<>();
            }
        }

        return ans;
    }
}
