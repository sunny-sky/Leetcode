package leetcode.easy;

/**
 * @Author: Liang
 * @Description: 给定一个正整数，检查他是否为交替位二进制数
 * @Date: Created in 20:58 2018/12/11
 */
public class No_693 {
    /**
     * @Description 给定一个正整数，检查他是否为交替位二进制数
     * @Auther Liang
     * @date 20:58 2018/12/11
     * @param n int
     * @return boolean
     */
    public boolean hasAlternatingBits(int n) {
        while (n != 0) {
            if ((n & 3) == 1 || (n & 3) == 2) {
                n = (n >> 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
