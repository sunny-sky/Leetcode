package leetcode.array.easy;

public class No_121_MaxProfit {
    public int maxProfit(int[] prices) {
        int result = 0,temp;
        for (int i = 0; i < prices.length - 1; i++) {

            for (int j = i +1; j < prices.length; j++) {
                temp = prices[j] - prices[i];
                result = (temp > result? temp:result);
            }
        }
        return result;
    }
}
