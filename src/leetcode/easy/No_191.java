package leetcode.easy;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 14:20 2018/12/2
 */
public class No_191 {
    /**
     * 用于转换int为64位数，eg：m = n & 0x0FFFFFFFF
     */
    public static final int GET_UNSINGL_INT = 0x0FFFFFFFF;

    /**
     * @Description 二进制中1的个数，n &= (n - 1)意为每次将n最右侧的1清除，m = n & 0x0FFFFFFFF 使其可按无符号处理
     * @Auther Liang
     * @date 14:21 2018/12/2
     * @param n 无符号数
     * @return int
     */
    public int hammingWeight(int n) {
        int count = 0;
        long m = n & GET_UNSINGL_INT;
        for (; m > 0; count++) {
            m &= (m - 1);
        }
        return count;
    }

    /**
     * @Description 规避了n=  2147483648 (10000000000000000000000000000000)时 n > 0 不进入循环问题
     * @Auther Liang
     * @date 14:40 2018/12/2
     * @param n 按无符号数处理，但其本身为有符号数
     * @return int
     */
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
