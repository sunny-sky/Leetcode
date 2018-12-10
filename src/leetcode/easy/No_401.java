package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 21:27 2018/12/9
 */
public class No_401 {
    /**
     * @Description 二进制手表
     * @Auther Liang
     * @date 21:27 2018/12/9
     * @param num int
     * @return java.util.List<java.lang.String>
     */
    public List<String> readBinaryWatch(int num) {
        // 小时灯亮0、1、2、3个时可能的值
        String[][] hour = {{"0"},
                {"1", "2", "4", "8"},
                {"3", "5", "6", "9", "10"},
                {"7", "11"}};
        // 分钟等亮0到5个时可能的值
        String[][] minute = {{"00"},
                {"01", "02", "04", "08", "16", "32"},
                {"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48"},
                {"07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49", "50", "52", "56"},
                {"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"},
                {"31", "47", "55", "59"}};
        List<String> res = new ArrayList<>();
        // 小时灯亮灯个数从0到num
        for (int i = 0; i <= 3 && i <= num; i++) {
            // 确保分钟灯数量不多于5个
            if (num - i <= 5) {
                // 小时灯为i个时，处理每个可能的值
                for (String str1 : hour[i]) {
                    // 相应情况下，分钟灯为num-i时每个可能的分钟值处理
                    for (String str2 : minute[num - i]) {
                        res.add(str1 + ":" + str2);
                    }
                }
            }
        }
        return res;
    }

    /**
     * @Description 另一种直接简便的方法
     * @Auther Liang
     * @date 22:00 2018/12/9
     * @param num int
     * @return java.util.List<java.lang.String>
     */
    public List<String> readBinaryWatch2(int num) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
                    res.add(String.format("%d:%02d", i, j));
                }
            }
        }
        return res;
    }
}
