package leetcode.easy;

/**
 * @Author: Liang
 * @Description: 3的幂
 * @Date: Created in 20:05 2018/12/21
 */
public class No_326 {
    /**
     * @Description 3的幂
     * @Auther Liang
     * @date 20:06 2018/12/21
     * @param n int
     * @return boolean
     */
    public boolean isPowerOfThree(int n) {
//        简单的API处理
//        if (n <= 0) {
//            return false;
//        }
//        double power = Math.log(n) / Math.log(3);
//        return power == Math.ceil(power);
        if (n == 1) {
            return true;
        }
        if (n % 3 != 0 || n <= 0) {
            return false;
        }

        while (n % 243 == 0) {
            n /= 243;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
