package leetcode.easy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author: Liang
 * @Description: 回旋镖的数量
 * @Date: Created in 14:20 2018/12/28
 */
public class No_447 {
    /**
     * @param points int[][]
     * @return int
     * @Description 回旋镖的数量
     * @Auther Liang
     * @date 14:21 2018/12/28
     */
    public int numberOfBoomerangs(int[][] points) {
        int len = points.length;
        int res = 0;
        for (int i = 0; i < len; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < len; j++) {
                if (j == i) {
                    continue;
                }
                Double key = Math.pow(points[j][0] - points[i][0], 2) + Math.pow(points[j][1] - points[i][1], 2);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            for (Map.Entry<Double, Integer> entry : map.entrySet()) {
                int num = entry.getValue();
                res += num * (num - 1) / 2;
            }
        }
        return res * 2;
    }
}
