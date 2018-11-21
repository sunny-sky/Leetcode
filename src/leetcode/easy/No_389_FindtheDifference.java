package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class No_389_FindtheDifference {
    public char findTheDifference(String s, String t) {
        if (s.length() == 0)
            return t.toCharArray()[0];

        char[] s_ch = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s_ch.length; i++) {
            map.put(s_ch[i], map.getOrDefault(s_ch[i], 0) + 1);
        }

        char[] t_ch = t.toCharArray();
        for (int j = 0; j < t_ch.length; j++) {
            if (!map.containsKey(t_ch[j]) || map.get(t_ch[j]) < 1) {
                return t_ch[j];
            } else {
                map.put(t_ch[j], map.get(t_ch[j]) - 1);
            }
        }
        throw new IllegalArgumentException("参数不对");
    }

    public char findTheDifference2(String s, String t) {
        char res = 0;
        for (int i = 0; i < s.length(); i++) {
            res ^= s.charAt(i);
        }

        for (int j = 0; j < t.length(); j++) {
            res ^= t.charAt(j);
        }

        return res;
    }
}
