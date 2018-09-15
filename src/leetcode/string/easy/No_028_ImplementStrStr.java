package leetcode.string.easy;

public class No_028_ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int len = needle.length();
        int lenH = haystack.length();

        for (int i = 0; i <= lenH - len; ++i) {
            int j = 0;
            for (; j < len; ++j) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
            if (j == len)
                return i;
        }
        return -1;
    }
}
