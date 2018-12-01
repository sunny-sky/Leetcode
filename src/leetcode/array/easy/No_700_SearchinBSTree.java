package leetcode.array.easy;

import leetcode.utils.TreeNode;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 11:09 2018/11/30
 */
public class No_700_SearchinBSTree {
    /**
     * @Description BST中搜索给定值val,返回对应子树
     * @Auther Liang
     * @date 11:10 2018/11/30
     * @param root 目标树根节点
     * @param val 要搜索的目标值
     * @return TreeNode
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }
        TreeNode temp = null;
        if (root.val > val) {
            temp = searchBST(root.left, val);
        } else {
            temp = searchBST(root.right, val);
        }

        return temp;
    }

    /**
     * @Description BST中搜索给定值val,返回对应子树
     * @Auther Liang
     * @date 11:10 2018/11/30
     * @param root 目标树根节点
     * @param val 要搜索的目标值
     * @return TreeNode
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        } else if (root.val > val) {
            // CSOFF: Ambigious method
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
