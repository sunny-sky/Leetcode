package leetcode.easy;

import leetcode.utils.TreeNode;


public class No_101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // 叶子结点返回True
//        if (root.left == null && root.right == null)
//            return true;
//        // 孩子节点有一侧为空
//        if (root.left == null || root.right == null) {
//            return false;
//        }
//
//        if (root.left.val != root.right.val) {
//            return false;
//        } else {
//            return isSymmetric(root.left) && isSymmetric(root.right);
//        }
    }
}
