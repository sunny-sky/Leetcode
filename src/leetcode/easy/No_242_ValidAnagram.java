package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class No_242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if ((s == null && t == null) || (s.length() == 0 && t.length() == 0))
            return true;
        if (s.equals(t) || s.length() != t.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int j = 0; j < len; j++) {
            if (!map.containsKey(t.charAt(j))) {
                return false;
            } else {
                map.put(t.charAt(j), map.get(t.charAt(j)) - 1);
            }
        }

        for (Integer v : map.values()) {
            if (v != null && !v.equals(0))
                return false;
        }
        return true;
    }

    public boolean isAnagram2(String s, String t) {
        if (null == s && null == t)
            return true;
        if (s == null && t != null || s != null && t == null)
            return false;
        if (s.length() != t.length())
            return false;
        int len = s.length();
        char[] cs = new char[len];
        char[] ct = new char[len];
        int[] a = new int[len];
        int[] b = new int[len];
        for (int i = 0; i < len; i++) {
            a[cs[i] - 'a']++;
            b[ct[i] - 'a']++;
        }
        for (int j = 0; j < 26; j++) {
            if (a[j] != b[j])
                return false;
        }
        return true;
    }
}
