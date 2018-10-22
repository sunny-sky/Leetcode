package leetcode.easy;

public class No_168_ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        int residue;
        StringBuilder sb = new StringBuilder();

        while (n != 0) {
            residue = n % 26;
            n /= 26;
            if (residue == 0) {
                sb.append('Z');
                n -= 1;
            }
            else
                sb.append((char)('A' + residue - 1));
        }

        return sb.reverse().toString();
    }
}
