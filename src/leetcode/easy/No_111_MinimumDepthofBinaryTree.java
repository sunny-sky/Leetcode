package leetcode.easy;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;
import leetcode.utils.TreeNode;

public class No_111_MinimumDepthofBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        else if (root.left == null && root.right == null)
            return 1;
        else if (root.left == null)
            return minDepth(root.right) + 1;
        else if (root.right == null)
            return minDepth(root.left) + 1;
        else
            return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
