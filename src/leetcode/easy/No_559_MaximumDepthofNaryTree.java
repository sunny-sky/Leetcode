package leetcode.easy;

import leetcode.utils.Node;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 10:17 2018/11/20
 * @Modified By:
 */
public class No_559_MaximumDepthofNaryTree {
    public int maxDepth(Node root) {
        return helper(root);
    }

    private int helper(Node root) {
         if (root == null)
             return 0;
         else if (root.children == null)
             return 1;
         else {
             int depth = 0;
             for (Node child : root.children) {
                 int lowerDepth = helper(child);
                 depth = depth < lowerDepth ? lowerDepth : depth;
             }
             return depth + 1;
         }
    }
}
