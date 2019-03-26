package leetcode.medium;

/**
 * @Author: Liang
 * @Description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * @Date: Created in 12:55 2019/3/24
 */
public class No_062 {
    /**
     * @Description 不同路径
     * @Auther Liang
     * @date 12:55 2019/3/24
     * @param m 行
     * @param n 列
     * @return int
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        m--;
        n--;
        if (m < n) {
            m = m + n;
            n = m - n;
            m = m - n;
        }
        long res = 1;
        int j = 1;
        for (int i = m + 1; i <= m + n; i++, j++) {
            res *= i;
            res /= j;
        }
        return (int) res;
    }
}
