package leetcode.easy;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 13:56 2018/12/2
 */
public class No_190 {
    /**
     * @Description int类型二进制长度
     * @Auther Liang
     * @date 13:58 2018/12/2
     */
    public static final int INTLEN = 32;

    /**
     * @Description 颠倒二进制
     * @Auther Liang
     * @date 13:56 2018/12/2
     * @param n 无符号int
     * @return int
     */
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < INTLEN; i++) {
            res += n & 1;
            n >>>= 1;  // nz最右一位处理完后右移
            if (i < INTLEN - 1) {  // 最后一次不再左移res
                res <<= 1;
            }
        }
        return res;
    }

//    省去右移判断
//    public int reverseBits1(int n) {
//        int res = 0;
//        for (int i = 0; i < INTLEN; i++) {
//            res <<= 1;
//            res += n & 1;
//            n >>>= 1;  // nz最右一位处理完后右移
//        }
//        return res;
//    }
}
