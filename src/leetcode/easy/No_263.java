package leetcode.easy;

/**
 * @Author: Liang
 * @Description: 丑数
 * @Date: Created in 16:07 2018/12/19
 */
public class No_263 {
    /**
     * @Description 丑数
     * @Auther Liang
     * @date 16:08 2018/12/19
     * @param num int
     * @return boolean
     */
    public boolean isUgly(int num) {
        if (num == 1) {
            return true;
        } else if (num <= 0) {
            return false;
        }

//        while (num % 15 == 0) {
//            num /= 15;
//        }
//        while (num % 10 == 0) {
//            num /= 10;
//        }
//        while (num % 6 == 0) {
//            num /= 6;
//        }
        while (num % 5 == 0) {
            num /= 5;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 2 == 0) {
            num /= 2;
        }

        return num == 1;
    }
}
