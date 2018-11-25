package leetcode.easy;

import leetcode.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 12:27 2018/11/16
 * @Modified By:
 */
public class No_437_PathSumIII {
    /**
     * @Description:
     * @Auther: Liang
     * @date: 16:16 2018/11/17
     * @param: [root, sum]
     * @return: int
     */
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0, 1);
        return helper(root, 0, sum, preSum);
    }

    /**
     * @Description:
     * @Auther: Liang
     * @date: 16:16 2018/11/17
     * @param: [root, currSum, target, preSum]
     * @return: int
     */
    private int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null)
            return 0;
        System.out.println("root:"+root.toString());
        currSum += root.val;
        System.out.println("currSum:"+currSum);
        int res = preSum.getOrDefault(currSum - target, 0);
        System.out.println("res本节点"+res);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        System.out.println("preSum 加后:"+preSum.toString());
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        System.out.println("res 加左右节点res值"+res);
        preSum.put(currSum, preSum.get(currSum) - 1);
        System.out.println("preSum 减后"+preSum.toString());
        return res;
    }

    public static int pathSum2(TreeNode root, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        return helper2(root, target, 0, map);
    }

    private static int helper2(TreeNode root, int target, int currSum, Map<Integer, Integer> map) {
        if (root == null)
            return 0;

        currSum += root.val;
        int res = map.getOrDefault(currSum - target, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        res += helper2(root.left, target, currSum, map) + helper2(root.right, target, currSum, map);
        map.put(currSum, map.getOrDefault(currSum, 0) - 1);

        return res;

    }
}
