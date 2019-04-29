package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class No_022 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        // 结果集list， 当前字符串"",左括号0个，右括号0个，总数n
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private void backtrack(List<String> list, String str, int open, int close, int max) {
        // 长度达到n时将该序列str加入list并终止
        if (str.length() == max * 2) {
            list.add(str);
            return;
        }
        // 左括号数小于最大值，继续添加做括号
        if (open < max) {
            backtrack(list, str + "(", open + 1, close, max);
        }
        // 右括号数少于左括号，添加左括号
        if (close < open) {
            backtrack(list, str + ")", open, close + 1, max);
        }
    }
}
