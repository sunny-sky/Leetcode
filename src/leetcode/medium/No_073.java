package leetcode.medium;

/**
 * @Author: Liang
 * @Description: 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 * @Date: Created in 11:04 2019/3/25
 */
public class No_073 {
    /**
     * @Description 矩阵置零
     * @Auther Liang
     * @date 11:04 2019/3/25
     * @param matrix input matrix
     * @return void
     */
    public void setZeroes(int[][] matrix) {
        // 是否是行、列首位为0
        boolean fr = false, fc = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        fr = true;
                    }
                    if (j == 0) {
                        fc = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        // 以首行、列0位置为标记，其他行列对应值置0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // 处理首行、列原本为0的情况
        if (fr) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if (fc) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        return;
    }
}
