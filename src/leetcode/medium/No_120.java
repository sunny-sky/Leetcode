package leetcode.medium;

import java.util.List;

public class No_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 空三角
        if (triangle.size() == 0) {
            return 0;
        }
        // 从倒数第二层循环至第一层
        for (int i = triangle.size() - 2; i >= 0; i--) {
            // 遍历当前层每一个数
            for (int j = 0; j <= i; j++) {
                // 当前层的上一层，如处理i层时，使用i + 1层
                List<Integer> nextRow = triangle.get(i + 1);
                // 求上一层最小相邻数与当前层当前数的和
                int sum = Math.min(nextRow.get(j), nextRow.get(j + 1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, sum);
            }
        }
        return triangle.get(0).get(0);
    }
}
