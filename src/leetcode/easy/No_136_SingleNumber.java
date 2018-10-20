package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class No_136_SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            if (m.getValue() == 1)
                return m.getKey();
        }
        throw new IllegalArgumentException("输入不合法");
    }
}
