package leetcode.string.easy;

public class No_014_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        else if (len == 1) {
            return strs[0];
        }
        int strLen = strs[0].length();
        if (strLen == 0) {
            return "";
        }
        String  res = "";
        for (int i = 0; i < len; ++i) {
            strLen = strs[i].length() < strLen ? strs[i].length() : strLen;
        }

        for (int j = 0; j < strLen; ++j) {
            for (int k = 0; k < len - 1; ++k) {
                if (strs[k].charAt(j) != strs[k+1].charAt(j)) {
                    return res;
                }
            }
            res += strs[0].charAt(j);
        }
        return res;

    }

    public String longestCommonPrefix2(String[] strs) {
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        else if (len == 1) {
            return strs[0];
        }
        int strLen = strs[0].length();
        if (strLen == 0) {
            return "";
        }
        int  res = 0;
        for (int i = 0; i < len; ++i) {
            strLen = strs[i].length() < strLen ? strs[i].length() : strLen;
        }

        for (int j = 0; j < strLen; ++j) {
            for (int k = 0; k < len - 1; ++k) {
                if (strs[k].charAt(j) != strs[k+1].charAt(j)) {
                    return strs[k].substring(0,j);
                }
            }
            res++;
        }
        return strs[0].substring(0,res);

    }
}
