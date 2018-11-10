package leetcode.easy;

import leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No_107_BinaryTreeLevelOrderTraversalII {

    // BFS
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();

        if (root == null)
            return wrapList;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int nodeNum = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < nodeNum; i++) {
                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                list.add(queue.poll().val);
            }

            wrapList.add(0, list);
        }

        return wrapList;
    }

    // DFS
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }

    private void levelMaker (List<List<Integer>> list, TreeNode root, int level) {
        if (root == null)
            return;
        if (level >= list.size())
            list.add(0,new LinkedList<Integer>());

        levelMaker(list, root.left, level + 1);
        levelMaker(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }
}
