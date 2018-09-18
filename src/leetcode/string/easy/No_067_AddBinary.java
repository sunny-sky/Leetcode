package leetcode.string.easy;

public class No_067_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, flag = 0;
        while (i >= 0 || j >= 0) {
            int sum = flag;
            if (j >= 0)
                sum += b.charAt(j--) - '0';
            if (i >= 0)
                sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            flag = sum / 2;
        }
        if (flag != 0)
            sb.append(flag);
        return sb.reverse().toString();
    }
}
