package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Liang
 * @Description: 最长和谐子序列
 * @Date: Created in 0:57 2019/1/29
 */
public class No_594 {
    /**
     * @Description 最长和谐子序列
     * @Auther Liang
     * @date 0:57 2019/1/29
     * @param nums 输入数组
     * @return int
     */
    public int findLHS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (map.containsKey(entry.getKey() + 1)) {
                res = Math.max(res, entry.getValue() + map.get(entry.getKey() + 1));
            }
        }
        return res;
    }
}
