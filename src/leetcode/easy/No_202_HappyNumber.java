package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class No_202_HappyNumber {
    public boolean isHappy(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = n;
        while (!map.containsKey(sum)) {
            map.put(sum, 0);
            int res = 0;
            while (sum != 0) {
                int temp = sum % 10;
                res += temp * temp;
                sum /= 10;
            }
            if (res == 1) {
                return true;
            }
            sum = res;
        }
        return false;
    }
}
