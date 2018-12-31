package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Liang
 * @Description: 各位相加
 * @Date: Created in 11:13 2018/12/18
 */
public class No_258 {
    /**
     * @Description 各位相加
     * @Auther Liang
     * @date 11:14 2018/12/18
     * @param num int
     * @return int
     */
    public int addDigits(int num) {
        while (num > 9) {
            num = getSum(num);
        }
        return num;
    }
    /**
     * @Description 各位相加求新数
     * @Auther Liang
     * @date 11:17 2018/12/18
     * @param num
     * @return int
     */
    public int getSum(int num) {
        List<Integer> list = new ArrayList<>();
        while (num != 0) {
            list.add(num % 10);
            num /= 10;
        }
        int res = 0;
        for (int l : list) {
            res += l;
        }
        return res;
    }
    /**
     * @Description 简单且快速的方法
     * @Auther Liang
     * @date 11:20 2018/12/18
     * @param num
     * @return int
     */
    public int addDigits2(int num) {
        if (num == 0) return 0;
        // 10 / 9 = 1; 100 / 9 = 1; 20 / 9 = 2; 除9的余数等于各位反复相加至只有个位数
        int res = num % 9;
        if (res != 0) return res;
        return 9;
    }
}
