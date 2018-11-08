package leetcode.easy;

import leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class No_101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode r1, TreeNode r2) {
        // 叶子结点返回True
        if (r1 == null && r2 == null)
            return true;

        // 仅一侧为空，不对称返回false
        if (r1 == null || r2 == null)
            return false;

        return r1.val == r2.val
                && isMirror(r1.left, r2.right)
                && isMirror(r1.right, r2.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tn1 = queue.poll();
            TreeNode tn2 = queue.poll();
            if (tn1 == null && tn2 == null)
                continue;
            if (tn1 == null || tn2 == null)
                return false;
            if (tn1.val != tn2.val)
                return false;

            queue.add(tn1.left);
            queue.add(tn2.right);
            queue.add(tn1.right);
            queue.add(tn2.left);
        }

        return true;
    }
}
