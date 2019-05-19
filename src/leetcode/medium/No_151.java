package leetcode.medium;




public class No_151 {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        char[] a = s.toCharArray();
        int n = a.length;

        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        // step 2. reverse each word
        reverseWords(a, n);
        // step 3. clean up spaces
        return cleanSpaces(a, n);
    }

    private void reverseWords(char[] a, int n) {
        int i = 0, j = 0;

        while (i < n) {
            // j跳至单词结尾，i跳至单词开头，然后翻转单词
            while (i < j || i < n && a[i] == ' ') {
                i++; // skip spaces
            }
            while (j < i || j < n && a[j] != ' ') {
                j++; // skip non spaces
            }
            reverse(a, i, j - 1);                      // reverse the word
        }
    }

    // trim leading, trailing and multiple spaces
    private String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            // j定位到单词
            while (j < n && a[j] == ' ') {
                j++;             // skip spaces
            }
            // j处单词移至i
            while (j < n && a[j] != ' ') {
                a[i++] = a[j++]; // keep non spaces
            }
            // 跳过下个单词间的多个空格
            while (j < n && a[j] == ' ') {
                j++;             // skip spaces
            }
            // 保留一个空格
            if (j < n) {
                a[i++] = ' ';     // keep only one space
            }
        }

        return new String(a).substring(0, i);
    }

    // reverse a[] from a[i] to a[j]
    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char t = a[i];
            a[i++] = a[j];
            a[j--] = t;
        }
    }
}
