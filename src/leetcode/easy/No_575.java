package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Liang
 * @Description: 分糖果
 * @Date: Created in 0:18 2019/1/29
 */
public class No_575 {
    /**
     * @Description 分糖果
     * @Auther Liang
     * @date 0:18 2019/1/29
     * @param candies 糖果
     * @return int
     */
    public int distributeCandies(int[] candies) {
        int len = candies.length;
        if (len == 0) {
            return 0;
        }
        Arrays.sort(candies);
        int numSister = 1; // 第一个直接给妹妹
        for (int i = 1; i < len && numSister < len / 2; i++) {
            if (candies[i] != candies[i - 1]) {
                numSister++;
            }
        }
        return numSister;
    }

    /**
     * @Description 使用HashMap
     * @Auther Liang
     * @date 0:39 2019/1/29
     * @param candies 糖果数组
     * @return int
     */
    public int distributeCandies1(int[] candies) {
        int len = candies.length;
        if (len == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(candies[0], 1);
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(candies[i])) {
                map.put(candies[i], 1);
            }
            if (map.size() == len / 2) {
                break;
            }
        }
        return map.size();
    }
}
