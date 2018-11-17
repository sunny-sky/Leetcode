package leetcode.easy;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class No_257_BinaryTreePaths {
    /**
     * 功能 输出所有从根节点到叶子结点的路径，例：["1->2->5", "1->3"]
     *    1
     *  /   \
     * 2     3
     *  \
     *   5
     *
     * @param root  根节点
     * @return List<String> answer
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<>();
        if (root != null)
            searchBT(root, "", answer);
        return answer;
    }

    /**
     * 功能 DFS递归遍历root
     * @param root 节点
     * @param path  保存父节点路径
     * @param answer  保存各路径的结果
     */
    private void searchBT(TreeNode root, String path, List<String> answer) {
        if (root.left == null && root.right == null)
            answer.add(path + root.val);
        if (root.left != null)
            searchBT(root.left, path + root.val + "->", answer);
        if (root.right != null)
            searchBT(root.right, path + root.val + "->", answer);
    }

    /**
     * 功能 另一种答案，快于binaryTreePaths
     * @param root 根节点
     * @return List<String> paths
     */
    public List<String> binaryTreePaths1(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<String> paths = new ArrayList<>();
        getPaths(root, paths, new StringBuffer());
        return paths;
    }

    /**
     * @
     * 功能 DFS遍历各个节点，每次增加节点值和箭头到path，叶子结点时path加入结果paths
     * @param root 节点
     * @param paths 输出结果集
     * @param path 路径暂存
     */
    private void getPaths(TreeNode root, List<String> paths, StringBuffer path) {
        // 叶子节点时，路径path存入结果paths
        if (root.left == null && root.right == null) {
            paths.add(path.append(root.val).toString());
        }

        path.append(root.val + "->"); // 添加节点值和箭头
        String curr = path.toString();
        if (root.left != null) {
            getPaths(root.left, paths, path);
        }
        path.setLength(0);
        path.append(curr);
        if (root.right != null) {
            getPaths(root.right, paths, path);
        }
    }


}
