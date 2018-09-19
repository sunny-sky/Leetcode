package leetcode.string.easy;

public class No_345_ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int i = 0, j = s.length() - 1;
        String tar = "aeiouAEIOU";
        while (i < j) {
            if (!tar.contains(String.valueOf(word[i]))) {
                ++i;
                continue;
            }
            if (!tar.contains(String.valueOf(word[j]))) {
                --j;
                continue;
            }
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            ++i;
            --j;
        }
        return String.valueOf(word);
    }

    public boolean isU(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' ||
                c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
    public String reverseVowels2(String s) {
        char[] str = s.toCharArray();
        for (int l = 0, r = s.length() - 1; l < r;) {
            if (!isU(str[l])) {
                ++l;
                continue;
            }
            if (!isU(str[r])) {
                --r;
                continue;
            }

            if (isU(str[l]) && isU(str[r])) {
                char temp = str[l];
                str[l] = str[r];
                str[r] = temp;
                ++l;
                --r;
            }

        }
        return String.valueOf(str);

    }
}
