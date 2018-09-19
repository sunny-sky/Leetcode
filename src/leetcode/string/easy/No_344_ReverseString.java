package leetcode.string.easy;

public class No_344_ReverseString {
    public String reverseString(String s) {
        String res = new StringBuffer(s).reverse().toString();
        return res;
    }

    public String reverseString2(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            ++i;
            --j;
        }
        return new String(word);
    }
}
