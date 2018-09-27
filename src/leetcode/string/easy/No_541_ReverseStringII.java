package leetcode.string.easy;

public class No_541_ReverseStringII {
    public String reverseStr(String s, int k) {
        if (s.length() <= k) {
            return new StringBuffer(s).reverse().toString();
        }

        int point = 0;
        StringBuilder sb =  new StringBuilder();
        while (point < s.length()) {
            if (s.length() - point >= 2 * k) {
                StringBuilder tempSb = new StringBuilder(s.substring(point, point +k));
                sb.append(tempSb.reverse());
                sb.append(s.substring(point + k, point + 2 * k));
            }
            else if (s.length() - point > k && s.length() - point < 2 * k) {
                StringBuilder tempSb = new StringBuilder(s.substring(point, point +k));
                sb.append(tempSb.reverse());
                sb.append(s.substring(point + k, s.length()));
            }
            else {
                StringBuilder tempSb = new StringBuilder(s.substring(point, s.length()));
                sb.append(tempSb.reverse());
            }
            point += 2 * k;
        }
        return sb.toString();
    }
}
