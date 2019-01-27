package leetcode.easy;

/**
 * @Author: Liang
 * @Description: 岛屿的周长
 * @Date: Created in 14:19 2019/1/22
 */
public class No_463  {
    /**
     * @Description 岛屿的周长
     * @Auther Liang
     * @date 14:19 2019/1/22
     * @param grid int[][]
     * @return int
     */
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int lenI = grid.length;
        int lenJ = grid[0].length;
        int res = 0;
        for (int i = 0; i < lenI; i++) {
            for (int j = 0; j < lenJ; j++) {
                if (grid[i][j] == 1) {
                    int num = 4;
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        num--;
                    }
                    if (i + 1 < lenI && grid[i + 1][j] == 1) {
                        num--;
                    }
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        num--;
                    }
                    if (j + 1 < lenJ && grid[i][j + 1] == 1) {
                        num--;
                    }
                    res += num;
                }
            }
        }
        return res;
    }
}
