package leetcode.easy;

import java.util.Arrays;

/**
 * @Author: Liang
 * @Description: 贪心算法分饼干
 * @Date: Created in 14:05 2018/12/1
 */
public class No_455 {
    /**
     * @Description 贪心算法分饼干
     * @Auther Liang
     * @date 14:05 2018/12/1
     * @param g 孩子胃口值
     * @param s 饼干满足胃口值
     * @return int
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int numGotCookies = 0;
        int numCookies = 0;
        while (numGotCookies < g.length && numCookies < s.length) {
            if (s[numCookies] < g[numGotCookies]) {
                numCookies++;
            } else {
                numCookies++;
                numGotCookies++;
            }
        }
        return numGotCookies;
    }
}
