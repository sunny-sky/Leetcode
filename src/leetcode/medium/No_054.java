package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Liang
 * @Description: 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋
 * 顺序，返回矩阵中的所有元素。
 * @Date: Created in 10:22 2019/3/12
 */
public class No_054 {

    /**
     * @param matrix 输入矩阵
     * @return java.util.List<java.lang.Integer>
     * @Description 遍历每一层，每一层设置4个tag位，rowBegin  rowEnd  colBegin  colEnd
     * 遇到某tag则换向
     * @Auther Liang
     * @date 10:23 2019/3/12
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        // 判空
        if (matrix.length == 0) {
            return res;
        }
        // init parameter
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // traverse right
            for (int j = colBegin; j <= colEnd; j++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            // traverse down
            for (int j = rowBegin; j <= rowEnd; j++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // traverse left
                for (int j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // traverse up
                for (int j = rowEnd; j >= rowBegin; j--) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }
        return res;
    }
}
