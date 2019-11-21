package leetcode.medium;

public class no_137 {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        int threes = 0;
        for (int num : nums) {
            twos |= ones & num;
            ones ^= num;
            threes = ones & twos;
            ones &= ~threes;
            twos &= ~threes;
        }
        return ones;
    }
}
