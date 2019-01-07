package leetcode.easy;

/**
 * @Author: Liang
 * @Description: 有效的完全平方数
 * @Date: Created in 20:22 2018/12/21
 */
public class No_367 {
    /**
     * @Description 有效的完全平方数,int最大值开根 46340.95...
     * @Auther Liang
     * @date 20:22 2018/12/21
     * @param num int
     * @return boolean
     */
    public boolean isPerfectSquare(int num) {
        int head = 1;
        int rear = 46340;
        int mid;
        while (head <= rear) {
            mid = (head + rear) / 2;
            if (num == mid * mid) {
                return true;
            } else if (num < mid * mid) {
                rear = mid - 1;
            } else {
                head = mid + 1;
            }
        }
        return false;
    }
}
