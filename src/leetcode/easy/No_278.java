package leetcode.easy;

/**
 * @Author: Liang
 * @Description: 第一个错误的版本
 * @Date: Created in 8:16 2018/12/20
 */
public class No_278 {
    /**
     * @Description 第一个错误的版本
     * @Auther Liang
     * @date 8:18 2018/12/20
     * @param n int
     * @return int
     */
    public int firstBadVersion(int n) {
        int head = 1;
        int rear = n;
        int mid = 1 + (n - 1) / 2;
        while (head <= rear) {
            if (isBadVersion(mid)) {
                rear = mid - 1;
            } else {
                head = mid + 1;
            }
            mid = head + (rear - head) / 2;
        }
        return isBadVersion(mid) ? mid : mid + 1;
    }
    /**
     * @Description 免去return判断，更快
     * @Auther Liang
     * @date 8:40 2018/12/20
     * @param n
     * @return int
     */
    public int firstBadVersion2(int n) {
        int head = 1;
        int rear = n;
        int mid = 1 + (n - 1) / 2;
        // while (head <= rear) {
        while (head < rear) {
            if (isBadVersion(mid)) {
                // mid位置版本错误，因为结果要第一个错误版本，所以mid不加1
                rear = mid;
            } else {
                head = mid + 1;
            }
            mid = head + (rear - head) / 2;
        }
        return rear;
    }

    /**
     * @Description 本题判断函数，仅占位
     * @Auther Liang
     * @date 8:40 2018/12/20
     * @param version int
     * @return boolean
     */
    boolean isBadVersion(int version) {
        return true;
    }
}
