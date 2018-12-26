package leetcode.easy;

import leetcode.utils.TreeNode;

import java.util.Stack;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 9:57 2018/11/30
 */
public class No_687_LongestUnivaluePath {
    /**
     * @Description 最长同值路径
     * @Auther Liang
     * @date 9:58 2018/11/30
     * @param root 目标树根节点
     * @return int
     */
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
            int length = lengthOfNodePath(temp);
            res = length > res ? length : res;
        }
        return res;
    }

    /**
     * @Description 返回节点子树中值等于节点值的最长链长度
     * @Auther Liang
     * @date 10:01 2018/11/30
     * @param node 传入节点
     * @return int
     */
    private int lengthOfNodePath(TreeNode node) {
        // node is null
        if (node == null) {
            return 0;
        }
        // node isn't null
        int target = node.val;
        int length = 0;
        // 长度等于左右子树最长链之和
        length += isInPath(node.left, target) + isInPath(node.right, target);
        return length;
    }

    /**
     * @Description 判断该节点是否在目标节点最长等值链上
     * @Auther Liang
     * @date 10:17 2018/11/30
     * @param node 要判断的节点
     * @param target 目标节点的值
     * @return int
     */
    private int isInPath(TreeNode node, int target) {
        // 本节点为空
        if (node == null) {
            return 0;
        }
        // 本节点不空
        int length = 0;
        if (node.val == target) {
            length++;
        } else { // 不等值，链中断
            return 0;
        }
        // 等值时，处理左右孩子的情况,取最长
        length += Math.max(isInPath(node.left, target), isInPath(node.right, target));
        return length;
    }

    /**
     * 全局变量，保存最大深度
     */
    int re = 0;

    /**
     * @Description 本题高效解，上面耗时82ms，本算法10ms
     * @Auther Liang
     * @date 10:43 2018/11/30
     * @param root 根节点
     * @return int
     */
    public int longestUnivaluePath1(TreeNode root) {
        // 根节点的父节点不存在，故此处val值任取，且不需要获取helper返回值，
        helper(root, 0);
        // 全局变量re 已在递归中更新
        return re;
    }

    /**
     * @Description 递归求最大深度，一次完成2项任务
     *              1. 本节点作为等值链父节点时，更新re，值为左右树等值链长度和
     *              2. 本节点作为上一节点的左右子树时，等值则其链长度+1
     * @Auther Liang
     * @date 10:45 2018/11/30
     * @param node 树的节点
     * @param val 上个节点值
     * @return int
     */
    private int helper(TreeNode node, int val) {
        // 空节点
        if (node == null) {
            return 0;
        }
        // 左右同值节点数
        int left = helper(node.left, node.val);
        int right = helper(node.right, node.val);
        // 若该节点同值链长度大于re，更新re
        re = Math.max(re, left + right);
        // 在等值链上，返回左右子树中最大深度，否则链中断
        return node.val == val ? Math.max(left, right) + 1 : 0;
    }
}

