package leetcode.easy;

import leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 16:53 2018/11/17
 * @Modified By:
 */
public class No_501_FindModeinBinarySearchTree {
    /**
     * @Description:
     * @Auther: Liang
     * @date: 16:54 2018/11/17
     * @param: [root]
     * @return: int[]
     */
    public int[] findMode(TreeNode root) {
        if (root == null)
            return new int[0];
        List<Integer> res = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int num = travellingTree(root, map);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == num)
                res.add(entry.getKey());
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    private int travellingTree(TreeNode root, HashMap<Integer, Integer> map) {
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        if (root.left == null && root.right == null)
            return map.get(root.val);
        System.out.println("root:" + root.val + "value:" + map.get(root.val));
        int num = map.get(root.val);
        if (root.left != null && root.right != null)
            return Math.max(Math.max(travellingTree(root.left, map), travellingTree(root.right, map)), num);
        else if (root.left != null)
            return Math.max(travellingTree(root.left, map), num);
        else
            return Math.max(travellingTree(root.right, map), num);
    }

    Integer preValue;
    int count = 1, max = 0;

    public int[] findMode2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        travellingTree(root, list);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private void travellingTree(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        travellingTree(root.left, list);
        if (preValue != null) {
            if (preValue == root.val)
                count++;
            else
                count = 1;
        }
        if (count == max) {
            list.add(root.val);
        } else if (count > max) {
            list.clear();
            max = count;
            list.add(root.val);
        }
        preValue = root.val;

        travellingTree(root.right, list);
    }
}
