package leetcode.array.easy;

public class No_485_MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int len = nums.length;
        int temp = 0, result = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                temp++;
            }
            else{
                temp = 0;
            }
//            if (temp > result) {
//                result = temp;
//            }
            // 使用Math，最终结果快出3ms，原10，现7
            Math.max(result, temp);
        }
        return result;
    }
    public int findMaxConsecutiveOnes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = -1;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = i - 1 - index;
                max = Math.max(temp, max);
                index = i;
            }
        }
        max = Math.max(max, nums.length-1-index);
        return max;
    }
}
