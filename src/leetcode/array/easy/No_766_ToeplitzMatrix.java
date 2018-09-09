package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

public class No_766_ToeplitzMatrix {
    public static boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> groups = new HashMap();
        for (int r = 0; r < matrix.length; ++r) {
            for (int c = 0; c < matrix[0].length; ++c) {
                if (!groups.containsKey(r-c))
                    groups.put(r-c, matrix[r][c]);
                else if (groups.get(r-c) != matrix[r][c])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] h = new int[][] {{11,74,7,93},{40,11,74,7}};
        boolean res = isToeplitzMatrix(h);
        System.out.println(res);
    }
}
