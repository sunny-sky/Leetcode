package leetcode.easy;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 20:05 2018/12/10
 */
public class No_461 {
    /**
     * @Description 二进制不同位置数
     * @Auther Liang
     * @date 20:05 2018/12/10
     * @param x int
     * @param y int
     * @return int
     */
    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((x & 1) != (y & 1)) {
                count++;
            }
            x >>>= 1;
            y >>>= 1;
        }
        return count;
    }
}
