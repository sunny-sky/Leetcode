package leetcode.array.easy;

public class No_026_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length<2){
            return nums.length;
        }
        int i = 0, j = 1;
        while (j<nums.length) {
            if (nums[i] == nums[j]) {
                j += 1;
            }
            else {
                i += 1;
                nums[i]=nums[j];
                j += 1;
            }
        }
        return i+1;
    }
    public int removeDuplicates2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; ++j) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}
