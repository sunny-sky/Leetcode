package leetcode.string.easy;

public class No_459_RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len / 2; i >= 1; --i) {
            if (len % i == 0) {
                int m = len / i;
                String subS = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < m; ++j) {
                    sb.append(subS);
                }
                if (sb.toString().equals(s))
                    return true;
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern2(String s) {
        if (s == null || s.length() < 2)
            return false;
        int len = s.length();
        for (int i = len / 2; i >= 1; --i) {
            if (len % i == 0) {
                boolean judge = true;
                for (int j = len / i; j > 1; --j) {
                    if (!s.substring(0, i).equals(s.substring(i*(j-1), i*j))) {
                        judge = false;
                        break;
                    }
                }
                if (judge)
                    return true;
            }
        }
        return false;
    }
}
