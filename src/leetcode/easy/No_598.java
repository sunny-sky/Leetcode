package leetcode.easy;

/**
 * @Author: Liang
 * @Description: 范围求和 II
 * @Date: Created in 17:09 2019/1/29
 */
public class No_598 {
    /**
     * @Description 范围求和 II
     * @Auther Liang
     * @date 17:10 2019/1/29
     * @param m 矩阵行
     * @param n 矩阵列
     * @param ops 操作矩阵
     * @return int
     */
    public int maxCount(int m, int n, int[][] ops) {
        int len = ops.length;
        if (len == 0) {
            return m * n;
        }
        int a = ops[0][0]; // 公共区域参数，即每次操作都设计的行、列数
        int b = ops[0][1];
        for (int i = 1; i < ops.length; i++) {
            a = Math.min(a, ops[i][0]);
            b = Math.min(b, ops[i][1]);
        }
        return a * b;
    }
}
