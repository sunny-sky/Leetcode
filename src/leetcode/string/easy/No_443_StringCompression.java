package leetcode.string.easy;

public class No_443_StringCompression {
    public int compress(char[] chars) {
        if (chars.length == 1)
            return 1;
        char temp = chars[0];
        int count = 1;
        int point = 0;
        for (int i = 1; i < chars.length; ++i) {
            if (temp == chars[i]) {
                count++;

            } else {
                if (count == 1) {
                    temp = chars[i];
                    chars[++point] = temp;
                } else {
                    temp = chars[i];
                    String num = String.valueOf(count);
                    for (int j = 0; j < num.length(); ++j) {
                        chars[++point] = num.charAt(j);
                    }
                    chars[++point] = temp;
                    count = 1;
                }
            }
        }
        if (count != 1) {
            String num = String.valueOf(count);
            for (int j = 0; j < num.length(); ++j) {
                chars[++point] = num.charAt(j);
            }
        }

        return point + 1;
    }
}
