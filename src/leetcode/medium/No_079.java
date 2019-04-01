package leetcode.medium;

/**
 * @Author: Liang
 * @Description: 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那
 * 些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * @Date: Created in 18:52 2019/3/28
 */
public class No_079 {
    /**
     * @Description 单词搜索
     * @Auther Liang
     * @date 18:55 2019/3/28
     * @param board int[][]
     * @param word String
     * @return boolean
     */
    public boolean exist(char[][] board, String word) {
        char[] w = word.toCharArray();
        // 遍历整个board
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                // 调用递归函数
                if (isExist(board, y, x, w, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @Description
     * @Auther Liang
     * @date 22:14 2019/3/28
     * @param board char[][]
     * @param y int
     * @param x int
     * @param word char
     * @param i int
     * @return boolean
     */
    private boolean isExist(char[][] board, int y, int x, char[] word, int i) {
        // 遍历word中字符后返回ture
        if (i == word.length) {
            return true;
        }
        // 越界返回false
        if (y < 0 || x < 0 || y == board.length || x == board[y].length) {
            return false;
        }
        // 非目标字符返回false
        if (board[y][x] != word[i]) {
            return false;
        }
        // 标记[y][x]值并在其四个方向寻找下一个字符，任意一方向符合则true
        board[y][x] ^= 256;
        boolean exist = isExist(board, y, x - 1, word, i + 1)
            || isExist(board, y, x + 1, word, i + 1)
            || isExist(board, y + 1, x, word, i + 1)
            || isExist(board, y - 1, x, word, i + 1);
        board[y][x] ^= 256;
        return exist;
    }
}
