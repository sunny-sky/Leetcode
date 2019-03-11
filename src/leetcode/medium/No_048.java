package leetcode.medium;

/**
 * @Author: Liang
 * @Description: 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * @Date: Created in 14:18 2019/3/11
 */
public class No_048 {
    /**
     * @Description 将图像顺时针旋转 90 度。
     * @Auther Liang
     * @date 14:19 2019/3/11
     * @param matrix 输入二维数组
     */
    public void rotate(int[][] matrix) {
        // 转置再翻转
        // 判空
        if (matrix == null || matrix.length == 0) {
            return;
        }
        // 转置
        transpose(matrix);
        reverse(matrix);
    }

    /**
     * @Description 将矩阵转置
     * @Auther Liang
     * @date 14:23 2019/3/11
     * @param matrix 输入二维数组
     */
    private void transpose(int[][] matrix) {
        // 遍历行数，将n行n列转置
        int temp;
        for (int i = 0; i < matrix.length; i++) {
            // 遍历该行，完成该行转置
            for (int j = i + 1; j < matrix.length; j++) {
                temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    /**
     * @Description 翻转每一行
     * @Auther Liang
     * @date 14:30 2019/3/11
     * @param matrix 输入二维数组
     */
    private void reverse(int[][] matrix) {
        // 遍历每一行
        int len = matrix.length;
        int temp;
        for (int i = 0; i < len; i++) {
            // 遍历每行中前一半元素，实现翻转
            for (int j = 0; j < len / 2; j++) {
                temp = matrix[i][len - 1 - j];
                matrix[i][len - 1 - j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}
