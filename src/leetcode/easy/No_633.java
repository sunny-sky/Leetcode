package leetcode.easy;

/**
 * @Author: Liang
 * @Description: 平方数之和
 * @Date: Created in 19:02 2019/1/29
 */
public class No_633 {
    /**
     * @Description 平方数之和
     * @Auther Liang
     * @date 19:03 2019/1/29
     * @param c 输入参数int
     * @return boolean
     */
    public boolean judgeSquareSum(int c) {
        int a = 0;
        int b = (int) Math.sqrt(c);
        while ((c - a * a) != b * b) {
            a++;
            if (a >= (int) Math.sqrt(c) + 1) {
                return false;
            }
            b = (int) Math.sqrt(c - a * a);
        }
        return true;
    }
}
