package leetcode.easy;

public class No_007_ReverseInteger {
    public int reverse(int x) {
        int res = 0, count = 0, temp = 0;
        while (x != 0) {
            count++;
            temp = x % 10;
            x /= 10;
            if (count > 10 || res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10 || count == 10 && (temp > 7 || temp < -8))
                return 0;
            res = res * 10 + temp;
        }
        return res;
    }
}
