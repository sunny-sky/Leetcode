package leetcode.easy;

/**
 * @Author: Liang
 * @Description: 字符串相加
 * @Date: Created in 10:35 2018/12/23
 */
public class No_415 {
    /**
     * @Description 字符串相加
     * @Auther Liang
     * @date 10:35 2018/12/23
     * @param num1 String
     * @param num2 String
     * @return java.lang.String
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        int carry = 0;
        for (int i = 0; i < len1 && i < len2; i++) {
            int temp1 = num1.charAt(len1 - 1 - i) - '0';
            int temp2 = num2.charAt(len2 - 1 - i) - '0';
            sb.insert(0, Character.forDigit((temp1 + temp2 + carry) % 10, 10));
            carry = (temp1 + temp2 + carry) / 10;
        }
        if (len1 > len2) {
            for (int j = len2; j < len1; j++) {
                int temp3 = num1.charAt(len1 - j - 1) - '0';
                sb.insert(0, Character.forDigit((temp3 + carry) % 10, 10));
                carry = (temp3 + carry) / 10;
            }
        } else if (len1 < len2) {
            for (int j = len1; j < len2; j++) {
                int temp4 = num2.charAt(len2 - j - 1) - '0';
                sb.insert(0, Character.forDigit((temp4 + carry) % 10, 10));
                carry = (temp4 + carry) / 10;
            }
        }
        if (carry != 0) {
            sb.insert(0, Character.forDigit(carry, 10));
        }

        return sb.toString();
    }
}
