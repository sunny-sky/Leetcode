package leetcode.medium;

/**
 * @Author: Liang
 * @Description: 不同路径 II 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * @Date: Created in 22:42 2019/3/24
 */
public class No_063 {
    /**
     * @Description 不同路径 II
     * @Auther Liang
     * @date 22:43 2019/3/24
     * @param obstacleGrid input matrix
     * @return int
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[width - 1];
    }
}
