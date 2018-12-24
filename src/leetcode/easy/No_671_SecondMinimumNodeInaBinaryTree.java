package leetcode.easy;

import leetcode.utils.TreeNode;

/**
 * @Author: Liang
 * @Description: 树中第二小的值
 * @Date: Created in 16:18 2018/11/29
 */

public class No_671_SecondMinimumNodeInaBinaryTree {
    /**
     * @Description 树第二小节点值
     * @Auther Liang
     * @date 17:16 2018/11/29
     * @param root 目标树根节点
     * @return int
     */
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }

        int min = root.val;
        int resMin = root.val;

        resMin = helper(root, min, resMin);
        if (min == resMin) {
            return -1;
        } else {
            return resMin;
        }
    }

    /**
     * @Description 层遍历
     * @Auther Liang
     * @date 17:36 2018/11/29
     * @param root 根节点
     * @param min 最小值
     * @param resMin 第二小值
     * @return int
     */
    private int helper(TreeNode root, int min, int resMin) {
        if (root == null) {
            return resMin;
        }
        if (root.val < resMin && root.val != min || resMin == min) {
            resMin = root.val;
        }
        int temp1 = helper(root.left, min, resMin);
        int temp2 = helper(root.right, min, resMin);
        if (temp1 != min) {
            if (resMin == min) {
                resMin = temp1;
            } else {
                resMin = Math.min(resMin, temp1);
            }
        }
        if (temp2 != min) {
            if (resMin == min) {
                resMin = temp2;
            } else {
                resMin = Math.min(resMin, temp2);
            }
        }
        return resMin;
    }
}

