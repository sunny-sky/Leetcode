package leetcode.easy;

/**
 * @Author: Liang
 * @Description: Nim游戏
 * @Date: Created in 14:23 2018/12/17
 */
public class No_292 {
    /**
     * @Description Nim游戏,4时无论如何取都会输，所以对手为5,6,7时我必输，因此我为8时对手必然为5,6,7,归纳法可知我为4的倍数时必输，否则必赢
     * @Auther Liang
     * @date 14:23 2018/12/17
     * @param n int 石头数量
     * @return boolean
     */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
