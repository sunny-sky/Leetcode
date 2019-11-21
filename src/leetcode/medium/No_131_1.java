package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_131_1 {
    private boolean[][] dp;
    public List<List<String>> partition(String s) {
        dp = new boolean[s.length()][s.length() + 1];
        initDpMatrix(s);
        for (int i = 0; i < s.length(); i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
        return partitionHelper(s, 0);
    }

    private List<List<String>> partitionHelper(String s, int start) {
        // 退出
        List<List<String>> ans = new ArrayList<>();
        if (start == s.length()) {
            ans.add(new ArrayList<>());
            return ans;
        }
        // 递归
        for (int i = start; i < s.length(); i++) {
            if (dp[start][i + 1]) {
                String left = s.substring(start, i + 1);
                for (List<String> l : partitionHelper(s, i + 1)) {
                    l.add(0, left);
                    ans.add(l);
                }
            }
        }
        return ans;
    }

    private void initDpMatrix(String s) {
        // 两层遍历，起点、终点
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String temp = s.substring(i, j);
                System.out.println("temp:" + temp);
                int start = 0;
                int end = temp.length() - 1;
                while (start < end) {
                    if (temp.charAt(start) != temp.charAt(end)) {
                        dp[i][j] = false;
                        break;
                    }
                    start++;
                    end--;
                }
                if (start >= end) {
                    dp[i][j] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> ans = new No_131_1().partition(s);
        for (List<String> l : ans) {
            System.out.println(l.toString());
        }
    }
}
