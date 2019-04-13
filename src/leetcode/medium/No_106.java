package leetcode.medium;

import leetcode.utils.TreeNode;

import java.util.HashMap;

/**
 * @Author: Liang
 * @Description: 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * @Date: Created in 14:56 2019/4/12
 */
public class No_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; ++i) {
            hm.put(inorder[i], i);
        }
        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0,
                postorder.length - 1, hm);
    }

    // 递归构建树
    private TreeNode buildTreePostIn(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd,
                                     HashMap<Integer, Integer> hm) {
        // 后序完毕或中序完毕，返回空节点
        // 当前根节点是否存在
        if (postStart > postEnd || inStart > inEnd) {
            return null;
        }
        // 当前根节点初始化
        TreeNode root = new TreeNode(postorder[postEnd]);
        // 当前根节点值在中序数组中index
        int ri = hm.get(postorder[postEnd]);
        // 递归左子树，参数依次为：中序数组，左子树在中序数组中起始位置，及其终止位置，后序数组，后序数组左子树开始位置，及其终止位置，哈希表
        // postStart + ri - inStart - 1 = postStart + [(ri - 1) - inStart] 后序起始位置加左树长度
        TreeNode leftchild = buildTreePostIn(inorder, inStart, ri - 1, postorder, postStart, postStart + ri - inStart - 1, hm);
        // 递归右子树，参数类似左
        TreeNode rightchild = buildTreePostIn(inorder, ri + 1, inEnd, postorder, postStart + ri - inStart, postEnd - 1, hm);
        root.left = leftchild;
        root.right = rightchild;
        return root;
    }
}
