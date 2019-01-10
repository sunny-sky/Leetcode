package leetcode.easy;

/**
 * @Author: Liang
 * @Description: 猜数字大小
 * @Date: Created in 20:45 2018/12/21
 */
public class No_374 {
    /**
     * @Description 猜数字大小
     * @Auther Liang
     * @date 20:46 2018/12/21
     * @param n int
     * @return int
     */
    public int guessNumber(int n) {
        int head = 1;
        int rear = n;
        int mid;
        while (head <= rear) {
            mid = head + (rear - head) / 2;
            int temp = guess(mid);
            if (temp == 0) {
                return mid;
            } else if (temp == 1) {
                head = mid + 1;
            } else {
                rear = mid - 1;
            }
        }
        return -1;
    }
    /**
     * @Description 占位
     * @Auther Liang
     * @date 14:13 2018/12/25
     * @param a int
     * @return int
     */
    int guess(int a) {
        return 0;
    }
}
