package leetcode.medium;

public class No_043 {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        // 遍历num1
        for (int i = m - 1; i >= 0; i--) {
            // 遍历num2
            for (int j = n - 1; j >= 0; j--) {
                // i j 对应位置数相乘
                int mul = (num1.charAt(i) - '0') *
                        (num2.charAt(j) - '0');
                // 相乘结果对应位置
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        // pos中每个数加入字符串sb中,头部含0跳过
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
