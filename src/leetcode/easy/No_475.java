package leetcode.easy;

import java.util.Arrays;


/**
 * @Author: Liang
 * @Description: 供暖器
 * @Date: Created in 8:57 2019/1/25
 */
public class No_475 {
    /**
     * @param houses  房子的一维坐标
     * @param heaters 加热器所在位置
     * @return int
     * @Description 供暖器最小半径
     * @Auther Liang
     * @date 8:58 2019/1/25
     */
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int[] res = new int[houses.length];
        int address = 0;
        // 遍历house，index 为 i
        for (int i = 0; i < houses.length; i++) {
            // 房子在加热器范围两头时，确定其最小距离
            if (houses[i] <= heaters[0]) {
                res[i] = heaters[0] - houses[i];
                continue;
            } else if (houses[i] >= heaters[heaters.length - 1]) {
                res[i] = houses[i] - heaters[heaters.length - 1];
                continue;
            }
            // 房子在加热器范围内部时,address为房子在第几个加热器区间内
            while (houses[i] > heaters[address]) {
                address++;
            }
            res[i] = Math.min(houses[i] - heaters[address - 1], heaters[address] - houses[i]);
        }
        Arrays.sort(res);
        return res[res.length - 1];
    }
}
