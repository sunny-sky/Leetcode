package leetcode.string.easy;

public class No_709_ToLowerCase {
    public String toLowerCase(String str) {
        char[] cArray = str.toCharArray();
        for (int i = 0; i < cArray.length; ++i) {
            if (cArray[i] >= 'A' && cArray[i] <= 'Z') {
                cArray[i] += 32;
            }
        }
        return new String(cArray);
    }
}
