package leetcode.medium;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No_095 {
    public List<TreeNode> generateTrees(int n) {
        Map<String, List<TreeNode>> dp = new HashMap<>();
        // 对角线为节点本身
        for (int i = 0; i <= n; i++) {
            List<TreeNode> temp = new ArrayList<>();
            temp.add(new TreeNode(i));
            dp.put(i + " " + i, temp);
        }
        // 填写右上部dp，即从i到j的所有可能的排序树
        // 从下往上填写，因为填1到n需要1n位置下方的数据
        // i为列,j为行
        for (int i = 2; i < n + 1; i++) {
            for (int j = i - 1; j > 0; j--) {
                dp.put(j + " " + i, helper(j, i, dp, n));
            }
        }
        return dp.get(1 + " " + n);
    }

    // 从start到end，返回所有可能的排序树的List,即填写[start][end]位置的列表
    private List<TreeNode> helper(int start, int end, Map<String, List<TreeNode>> dp, int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // 结果List
        List<TreeNode> res = new ArrayList<>();
        // 遍历start到end，分别以其为根节点

        for (int i = start; i < end + 1; i++) {
            // 若根节点为两侧
            if (i == start) {
                // 只遍历右
                for (TreeNode trR : dp.get((i + 1) + " " + end)) {
                    TreeNode tempNode = new TreeNode(i);
                    tempNode.right = trR;
                    res.add(tempNode);
                }
            } else if (i == end) {
                // 只遍历左
                for (TreeNode trL : dp.get(start + " " + (i - 1))) {
                    TreeNode tempNode = new TreeNode(i);
                    tempNode.left = trL;
                    res.add(tempNode);
                }
            } else {
                // 遍历左侧
                for (TreeNode trL : dp.get(start + " " + (i - 1))) {
                    // 遍历右
                    for (TreeNode trR : dp.get((i + 1) + " " + end)) {
                        TreeNode tempNode = new TreeNode(i);
                        tempNode.left = trL;
                        tempNode.right = trR;
                        res.add(tempNode);
                    }
                }
            }
        }
        return res;
    }
}
