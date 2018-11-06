package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class No_290_WordPattern {
    public boolean wordPattern(String pattern, String str) {
        char[] cptn = pattern.toCharArray();
        String[] aStr = str.split(" ");
        Map<Character, String> map = new HashMap<>();
        int len = cptn.length;
        if (aStr.length != len)
            return false;
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(cptn[i]) && !map.containsValue(aStr[i])) {
                map.put(cptn[i], aStr[i]);
            } else if ((map.containsKey(cptn[i]) && !map.containsValue(aStr[i])) || (!map.containsKey(cptn[i]) && map.containsValue(aStr[i]))) {
                return false;
            } else if (!aStr[i].equals(map.get(cptn[i]))) {
                return false;
            }
        }
        return true;
    }
}
