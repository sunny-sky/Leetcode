package leetcode.medium;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No_113 {
    private int SUM;
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        SUM = sum;
        if (root == null) {
            return res;
        }
        List<Integer> tempList = new ArrayList<>();
        int counter = 0;
        helper(root, tempList, counter);
        return res;
    }

    //递归,先序遍历
    public void helper(TreeNode root, List<Integer> tempList, int counter) {
        // 退出
        if (root == null) {
            return;
        }
        // 先序遍历，递归
//        List<Integer> list = new ArrayList<>();
//        Collections.copy(list, tempList);
        tempList.add(root.val);
        counter += root.val;
        if (root.left == null && root.right == null && counter == SUM) {
            List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[tempList.size()]));
            Collections.copy(list, tempList);
            res.add(list);
        }
        // 递归左右
        helper(root.left, tempList, counter);
        helper(root.right, tempList, counter);

        counter -= tempList.get(tempList.size() - 1);
        tempList.remove(tempList.size() - 1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(4);
        TreeNode root2 = new TreeNode(8);
        TreeNode root3 = new TreeNode(11);
        TreeNode root4 = new TreeNode(13);
        TreeNode root5 = new TreeNode(4);
        TreeNode root6 = new TreeNode(7);
        TreeNode root7 = new TreeNode(2);
        TreeNode root8 = new TreeNode(5);
        TreeNode root9 = new TreeNode(1);
        root3.left = root6;
        root3.right = root7;
        root5.left = root8;
        root5.right = root9;
        root1.left = root3;
        root2.left = root4;
        root2.right = root5;
        root.left = root1;
        root.right = root2;
        List<List<Integer>> tempRes = new ArrayList<>();

        No_113 sample = new No_113();
        tempRes = sample.pathSum(root, 22);
        System.out.println(tempRes);

    }
}
