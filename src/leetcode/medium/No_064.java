package leetcode.medium;

/**
 * @Author: Liang
 * @Description: 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * @Date: Created in 10:32 2019/3/25
 */
public class No_064 {
    /**
     * @Description  最小路径和,只能向下或向左
     * @Auther Liang
     * @date 10:33 2019/3/25
     * @param grid input matrix
     * @return int
     */
    public int minPathSum(int[][] grid) {
//        int width = grid[0].length;
//        int[] dp = new int[width];
        // grid第一列为grid第一列每个元素与上一行的和，初始化第一列
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        // grid第一行只和左侧值有关
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] += grid[0][i -1];
        }
        // grid其他位置为自身加左侧和上册中最小的一个
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j -1]);
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
