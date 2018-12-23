package leetcode.easy;

import leetcode.utils.TreeNode;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 9:47 2018/11/28
 * @Modified By:
 */
public class No_669_TrimaBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {

        TreeNode temp = root;
        // 界外则寻找子树中界内节点替换
        // 小于L，往右树找第一个界内节点替换，
        if (root != null && root.val < L) {
            // 右树空，该节点为空
            if (root.right == null)
                root = null;
                // 右树不空，查找界内节点
            else {
                root = trimBST(root.right, L, R);
            }
        }

        // 大于R，找左子树
        if (root != null && root.val > R) {
            if (root.left == null)
                root = null;
            else {
                root = trimBST(root.left, L, R);
            }
        }

        // 界内递归左右节点
        if (root != null && root.val >= L && root.val <= R) {
            if (root.left != null) {
                root.left = trimBST(root.left, L, R);
            }
            if (root.right != null) {
                root.right = trimBST(root.right, L, R);
            }
        }



        return root;
    }
}
