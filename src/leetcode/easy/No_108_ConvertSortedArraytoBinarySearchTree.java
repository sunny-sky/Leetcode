package leetcode.easy;

import leetcode.utils.TreeNode;

public class No_108_ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = new TreeNode(0);
        root = makeTree(nums, 0, nums.length - 1);
        return root;
    }

    private TreeNode makeTree(int[] nums, int head, int rear) {
        if (head > rear)
            return null;
        else {
            TreeNode root = new TreeNode(nums[(head + rear) / 2]);
            root.left = makeTree(nums, head, (head + rear) / 2 - 1);
            root.right = makeTree(nums, (head + rear) / 2 + 1, rear);
            return root;
        }
    }
}
