package leetcode.dynamicProgramming.easy;

public class No_303_RangeSumQueryImmutable {

    private int[] sum;

    public void NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; ++i) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        //return sum[j + 1] - sum[i];
        if(i==0) return sum[j];
        return sum[j]-sum[i-1];
    }
}
