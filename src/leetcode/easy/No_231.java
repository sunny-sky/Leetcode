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
        return n > 0 && Math.pow(2, 31) % n == 0;
    }
}
