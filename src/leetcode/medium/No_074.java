package leetcode.medium;

/**
 * @Author: Liang
 * @Description: 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * @Date: Created in 14:15 2019/3/26
 */
public class No_074 {
    /**
     * @Description 搜索二维矩阵
     * @Auther Liang
     * @date 14:15 2019/3/26
     * @param matrix input matrix
     * @param target input target int
     * @return boolean
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        int head = 0, rear = row * col - 1;
        while (head <= rear) {
            int mid = (head + rear) >> 1;
            if (matrix[mid / col][mid % col] == target) {
                return true;
            } else if (matrix[mid / col][mid % col] < target) {
                head = mid + 1;
            } else {
                rear = mid - 1;
            }
        }
        return false;
    }

    /**
     * @Description  it will be useful for future problem. :-)
     * @Auther Liang
     * @date 14:29 2019/3/26
     * @param matrix input matrix
     * @param target input target int
     * @return boolean
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) {
            return false;
        }
        for (int i = row - 1, j = 0; i >= 0 && j < col;) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }
}
