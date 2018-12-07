package leetcode.easy;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 15:27 2018/12/7
 */
public class No_342 {
    /**
     * @Description 4的幂
     * @Auther Liang
     * @date 15:28 2018/12/7
     * @param num int
     * @return boolean
     */
    public boolean isPowerOfFour(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        } else {
            int temp1 = num & num - 1;
            int temp2 = num & 3;
            int temp3 = num & 0x55555555;
            if (temp1 == 0 && temp2 == 0 && temp3 != 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * @Description 一行。。。牛逼
     * @Auther Liang
     * @date 15:51 2018/12/7
     * @param num int
     * @return boolean
     */
    public boolean isPowerOfFour2(int num) {
        return num > 0 && ((num & 0x55555555) != 0 && (num & (num - 1)) == 0);
    }
}
