package leetcode.array.easy;


import java.util.HashMap;
import java.util.Map;

public class No_532_K_diff {
    public int findPairs(int[] nums, int k) {
        // 输入特殊情况
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        // 初始化map值，key的value对应key出现次数
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                // k==0,则重复元素为要求元素，即n与n相差0
                if (entry.getValue() >= 2) {
                    count++;
                } else {
                // k != 0, 与n相差k的元素为n+k, 若n+k存在则计数加1
                    if (map.containsKey(entry.getKey() + k)) {
                        count++;
                    }
                }
            }
        }
        return count++;
    }
}
