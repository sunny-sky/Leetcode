package leetcode.easy;

import leetcode.utils.TreeNode;

import java.util.*;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 13:22 2018/11/18
 * @Modified By:
 */
public class No_538_ConvertBSTtoGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;

        List<Integer> list = new LinkedList<>();
        travelling(root,list);

        Collections.sort(list);

        int size = list.size();
        List<Integer> target = new LinkedList<>();
        target.add(list.get(size - 1));
        Map<Integer, Integer> map = new HashMap<>();
        map.put(list.get(size - 1), list.get(size - 1));

        for (int i = size - 2; i >= 0; i--) {
            target.add(0, list.get(i) + target.get(0));
            map.put(list.get(i), target.get(0));
        }

        travellingForRes(root, map);
        return root;
    }

    private void travelling(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        if (!list.contains(root.val))
            list.add(root.val);
        travelling(root.left, list);
        travelling(root.right, list);
    }

    private void travellingForRes(TreeNode root, Map<Integer, Integer> map) {
        if (root == null)
            return;
        root.val = map.get(root.val);
        travellingForRes(root.left, map);
        travellingForRes(root.right, map);
    }

    private int sum = 0;
    public TreeNode convertBST2(TreeNode root) {
        travelling2(root);
        return root;
    }

    private void travelling2(TreeNode root) {
        if (root == null)
            return;
        travelling2(root.right);

        root.val += sum;
        sum = root.val;

        travelling2(root.left);
    }
}
