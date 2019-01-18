package leetcode.easy;

/**
 * @Author: Liang
 * @Description: 排列硬币
 * @Date: Created in 14:14 2018/12/25
 */
public class No_441 {
    /**
     * @param n int
     * @return int
     * @Description 排列硬币, (1 + m)m = 2 Integer.MAX_VALUE
     * 2147450880
     * 2147483647
     * @Auther Liang
     * @date 14:14 2018/12/25
     */
    public int arrangeCoins1(int n) {
        long x = n;
        double m = (Math.sqrt(1 + 8 * x) - 1) / 2;
        return (int) Math.floor(m);
    }
}
