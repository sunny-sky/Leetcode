package leetcode.easy;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 20:25 2018/12/11
 */
public class No_476 {
    /**
     * @Description 给定的整数保证在32位带符号整数的范围内。你可以假定二进制数不包含前导零位。
     * @Auther Liang
     * @date 20:25 2018/12/11
     * @param num int
     * @return int
     */
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        } else if (num == 1) {
            return 0;
        }
        int count = (int) Math.floor(Math.log(num) / Math.log(2)) + 1;
        int temp = 1;
        while (count != 1) {
            temp <<= 1;
            temp += 1;
            count--;
        }
        return (temp - num);
    }
}
