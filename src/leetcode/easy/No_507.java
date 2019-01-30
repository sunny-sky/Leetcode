package leetcode.easy;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 19:44 2019/1/25
 */
public class No_507 {
    /**
     * @Description 完美数
     * @Auther Liang
     * @date 19:50 2019/1/25
     * @param num 正整数
     * @return boolean
     */
    public boolean checkPerfectNumber(int num) {
        if (num < 6) {
            return false;
        }
        int head = 2;
        int rear = num;
        int res = 1;
        while (head < rear) {
            if (num % head == 0) {
                rear = num / head;
                if (rear != head) {
                    res = res + head + rear;
                } else {
                    res += head;
                }
            }
            head++;
        }
        return res == num;
    }

    /**
     * @Description 一种只有14ms的算法，上面为778ms
     * @Auther Liang
     * @date 20:06 2019/1/25
     * @param num
     * @return boolean
     */
    public boolean checkPerfectNumber2(int num) {
        if (num < 6) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i < num / i; i++) {
            if (num % i == 0) {
                sum = sum + i + num / i;
            }
        }
        return sum / 2 == num;
    }
}
