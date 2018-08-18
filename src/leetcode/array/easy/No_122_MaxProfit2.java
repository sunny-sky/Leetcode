package leetcode.array.easy;

public class No_122_MaxProfit2 {
    public int maxProfit(int[] prices) {
        if (prices.length < 1)
            return 0;
        int[] temp = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            temp[i - 1] = prices[i] - prices[i-1];
        }
        int result = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > 0) {
                result += temp[i];
            }
        }
        return result;
    }
}
