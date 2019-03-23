package leetcode.medium;

/**
 * @Author: Liang
 * @Description: 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * @Date: Created in 16:09 2019/3/23
 */
public class No_059 {
    /**
     * @Description 螺旋矩阵 II
     * @Auther Liang
     * @date 16:12 2019/3/23
     * @param n 方阵维数
     * @return int[][]
     */
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 0) {
            return matrix;
        }
        int rowStart = 0;
        int rowEnd = n - 1;
        int colStart = 0;
        int colEnd = n - 1;
        int num = 1;
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                matrix[rowStart][i] = num++;
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                matrix[i][colEnd] = num++;
            }
            colEnd--;
            for (int i = colEnd; i >= colStart; i--) {
                matrix[rowEnd][i] = num++;
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowStart; i--) {
                matrix[i][colStart] = num++;
            }
            colStart++;
        }
        return matrix;
    }
}
