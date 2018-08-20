package leetcode.array.easy;

public class No_283_MoveZeros {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int count = 0,point = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[point++] = nums[i];
            }

        }
        for (int j = point; j < len; j++){
            nums[j] = 0;
        }
    }
}
