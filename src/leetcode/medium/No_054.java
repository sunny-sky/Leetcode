package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
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
     * @Description 遍历每一层，每一层设置4个tag位，如第一层tag1=[0,0]，tag2=[0,lenX]
     * 遇到某tag则换向，优先考虑tag位重合的情况，为最后一次遍历
     * @Auther Liang
     * @date 10:23 2019/3/12
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // 判空
        if (matrix == null || matrix.length == 0 && matrix[0].length == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        int dx = 0, dy = 0;
        int[] tag1, tag2, tag3, tag4;
        int lenX = matrix[0].length, lenY = matrix.length;
        // 加入list的置0，遇到0或超出界限换向
        for (int i = 0; i < (lenX + 1) / 2 && i < (lenY + 1) / 2; i++) {
            tag1 = new int[]{i, i}; // 左上
            tag2 = new int[]{i, lenY - 1 - i}; // 右上
            tag3 = new int[]{lenX - 1 - i, lenY - 1 - i}; // 右下
            tag4 = new int[]{lenX - 1 - i, i}; // 左下
            // 遍历该层
            for (int x = i, y = i;;) {
                res.add(matrix[x][y]);
                if (Arrays.equals(tag1, tag2) && Arrays.equals(tag1, tag3)) {
                    break;
                }
                if (!Arrays.equals(tag1, tag2)) {

                } else {

                }

            }
        }
        return res;
    }
}
