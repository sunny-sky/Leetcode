package leetcode.easy;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 17:24 2018/12/4
 */
public class No_231 {
    /**
     * @Description 判断它是否是 2 的幂次方
     * @Auther Liang
     * @date 17:26 2018/12/4
     * @param n int 参数
     * @return boolean
     */
    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                return false;
            }
        }
        return true;
    }
}
