package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No_438_FindAllAnagramsinaString {
//    public List<Integer> findAnagrams(String s, String p) {
//        if (s == null || s.length() == 0)
//            return null;
//
//        int p_len = p.length(), s_len = s.length();
//        if (p_len < s_len)
//            return null;
//
//        char[] p_ch = p.toCharArray(), s_ch = s.toCharArray();
//        Map<Character, Integer> map = new HashMap<>();
//        Map<Character, Integer> temp = new HashMap<>();
//        for (int i = 0; i < p_len; i++) {
//            temp.put(p_ch[i], temp.getOrDefault(p_ch[i], 0) + 1);
//        }
//
//        for (int j = 0; j < p_len - 1; j++) {
//            map.put(s_ch[j], map.getOrDefault(s_ch[j], 0) + 1);
//        }
//
//        for (int k = 0; k <= s_len - p_len; k++) {
//            map.put(s_ch[p_len - 1 + k],
//                    map.getOrDefault(s_ch[p_len - 1 + k], 0) + 1);
//            for (Map.Entry<Character, Integer> entry : temp.entrySet()) {
//                if (!map.containsKey(entry.getKey()) ||
//                        map.get(entry.getKey()) != entry.getValue()) {
//                    map.remove(s_ch[k]);
//
//                }
//            }
//        }
//    }

    public static List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0)
            return list;

        int[] hash = new int[26];
        for (char c : p.toCharArray()) {
            hash[c - 97]++;
        }

        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            if (hash[s.charAt(right++) - 97]-- >= 1)
                count--;

            if (count == 0)
                list.add(left);

            if (right - left == p.length() && hash[s.charAt(left++) - 97]++ >= 0)
                count++;
        }

        return list;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        String res = findAnagrams2(s, p).toString();
        System.out.println(res);

    }
}
