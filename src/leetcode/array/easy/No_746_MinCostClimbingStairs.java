package leetcode.array.easy;

public class No_746_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len == 2){
            return Math.min(cost[0],cost[1]);
        }
        int[] count = new int[len];
        count[0] = cost[0];
        count[1] = cost[1];
        for (int i = 2; i < len; i++) {
            count[i] = Math.min(count[i-2],count[i-1]) + cost[i];
        }
        return Math.min(count[len-1],count[len-2]);
    }
}
