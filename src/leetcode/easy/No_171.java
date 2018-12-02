package leetcode.easy;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 20:33 2018/11/30
 */
public class No_171 {
    /**
     * @Description excel编号
     * @Auther Liang
     * @date 20:34 2018/11/30
     * @param s 输入字符串
     * @return int
     */
    public int titleToNumber(String s) {
        int len = s.length();
        int res = 0;
        int temp = len;
        for (int i = 0; i < len; i++) {
            res += (int) (s.charAt(i) - 64) * Math.pow(26, temp - 1);
            temp--;
        }
        return res;
    }
}
