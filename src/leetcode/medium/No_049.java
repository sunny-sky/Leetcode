package leetcode.medium;

import java.util.*;

public class No_049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 判空
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        // map，key'为有序的所含字母String， 值为所有同字母不懂顺序的list
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            // 是否存在对应键，并处理
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                // 无键则新增
                map.put(keyStr, new ArrayList<>());
            }
            // s加入对应value中
            map.get(keyStr).add(s);
        }
        // 使用map.values()返回所有结果
        return new ArrayList<>(map.values());
    }
}
