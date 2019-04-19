package leetcode.medium;

import java.util.HashMap;

public class No_003 {
    public int lengthOfLongestSubstring(String s) {
        // 判空
        if (s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0, j = 0; i < s.length(); ++i) {
            // 如果出现重复过的字符，则减去含重复字符的前面一段
            if (map.containsKey(s.charAt(i))) {
                // Math.max为了避免重复但被上一个重复字符剪掉的情况，即指针j不能倒回
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            // 刷新或新增字符的位置
            map.put(s.charAt(i), i);
            // 取当前最大长度
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
