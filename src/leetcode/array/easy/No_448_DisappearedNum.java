package leetcode.array.easy;

import java.util.ArrayList;
import java.util.List;

public class No_448_DisappearedNum {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            result.add(i,i+1);
        }
        for (int j = 0; j < len; j++) {
            result.set(nums[j]-1,0);
        }
        for (int k = 0; k < result.size(); k++) {
            if (result.get(k) == 0) {
                result.remove(k--);
            }
        }
        return result;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i+1);
            }
        }
        return result;
    }
}
