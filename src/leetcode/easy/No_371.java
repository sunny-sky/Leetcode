package leetcode.easy;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 15:08 2018/12/8
 */
public class No_371 {
    /**
     * @Description 位操作实现加法
     * @Auther Liang
     * @date 15:09 2018/12/8
     * @param a int 递归过程中保存不进位项的结果，因为异或结果是不同取1
     * @param b int 递归过程中保存上次操作需要进位的位置的值，11时左移一位
     * @return int
     */
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
