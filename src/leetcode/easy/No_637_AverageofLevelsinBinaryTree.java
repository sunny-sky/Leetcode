package leetcode.easy;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 15:09 2018/11/26
 * @Modified By:
 */
public class No_637_AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null)
            return new ArrayList<>();


        List<Double> list = new ArrayList<>();
        int num = 1, node_num = 1, next_node_num = 0;
        double sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            sum += temp.val;
            node_num--;
            if (temp.left != null) {
                queue.offer(temp.left);
                next_node_num++;
            }
            if (temp.right != null) {
                queue.offer(temp.right);
                next_node_num++;
            }
            if (node_num == 0) {
                list.add(sum / num);
                sum = 0;
                node_num = next_node_num;
                num = next_node_num;
                next_node_num = 0;
            }
        }

        return list;
    }
}
