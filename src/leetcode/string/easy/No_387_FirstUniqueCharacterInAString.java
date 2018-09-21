package leetcode.string.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class No_387_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            if (map.containsKey(String.valueOf(s.charAt(i)))) {
                map.put(String.valueOf(s.charAt(i)), map.get(String.valueOf(s.charAt(i))) + 1);
            } else {
                map.put(String.valueOf(s.charAt(i)), 1);
            }
        }

        for (int i = 0; i < s.length(); ++i) {
            if (map.get(String.valueOf(s.charAt(i))) == 1)
                return i;
        }

        return -1;
    }

    public int firstUniqChar2(String s) {
        int res = -1;

        for (char ch = 'a'; ch <= 'z'; ++ch) {
            int index = s.indexOf(ch);
            if (index != -1 && index == s.lastIndexOf(ch)) {
                res = (res == -1 ? index : Math.min(index, res));
            }
        }
        return res;
    }
}
