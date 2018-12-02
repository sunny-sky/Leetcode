package leetcode.easy;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 20:52 2018/11/30
 */
public class No_172 {
    /**
     * @Description 阶乘尾部0个数
     * @Auther Liang
     * @date 20:52 2018/11/30
     * @param n n！
     * @return int
     */
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n >= 5) {
            ans += n / 5;
            n = n / 5;
        }

        return ans;
    }

    /**
     * @Description 递归算法
     * @Auther Liang
     * @date 14:00 2018/12/1
     * @param n n！
     * @return int
     */
    public int trailingZeroes1(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
