package leetcode.array.easy;

public class No_219_ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j <= k && (i+j) < len; j++) {
                if (nums[i] == nums[i+j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
