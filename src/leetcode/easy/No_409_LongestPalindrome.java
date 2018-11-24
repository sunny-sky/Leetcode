package leetcode.easy;

import javax.xml.ws.AsyncHandler;
import java.util.HashMap;
import java.util.Map;

public class No_409_LongestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int tag = 0, res = 0;
        char[] s_ch = s.toCharArray();
        for (char c : s_ch) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            res += entry.getValue() / 2 * 2;
        }

        return res < s.length() ? res + 1 : res;
    }

    public int longestPalindrome2(String s) {
        int[] is = new int[58];
        int n = 0;
        char[] s_ch = s.toCharArray();

        for (char c : s_ch) {
            is[c - 65]++;
        }

        for (int i : is) {
            n += i / 2;
        }

        return 2 * n < s.length() ? (2 * n + 1) : (2 * n);
    }
}
