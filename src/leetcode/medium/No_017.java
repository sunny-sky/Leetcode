package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class No_017 {
    public List<String> letterCombinations(String digits) {
        // 结果链表
        LinkedList<String> ans = new LinkedList<>();
        // 判空
        if (digits.isEmpty()) {
            return ans;
        }
        // 字母映射数组
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        // 遍历digits中每个字符
        for (int i = 0; i < digits.length(); i++) {
            // 第i个字符串的asic🐎
            int x = Character.getNumericValue(digits.charAt(i));
            // 结果不完整时
            while (ans.peek() == null || ans.peek().length() == i) {
                // 拿出ans中首个字符串
                String t = ans.remove();
                // 每个可能的加一位的结果加入ans中
                for (char s : mapping[x].toCharArray()) {
                    ans.add(t + s);
                }
            }
        }
        return ans;
    }
}
