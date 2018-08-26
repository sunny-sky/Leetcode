package leetcode.array.easy;

import sun.security.util.AuthResources_fr;

import java.util.Arrays;

public class No_581_SubArray {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null && nums.length == 0) {
            return 0;
        }
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(nums);
        if (nums==temp) {
            return 0;
        }
        int j = 0;
        for (;j < nums.length && nums[j] == temp[j]; j++) {
        }
        if (j == nums.length) {
            return 0;
        }
        int k = nums.length - 1;
        for (; k > j && nums[k] == temp[k]; k--) {
        }
        return k - j + 1;
    }

    public int findUnsortedSubarrayLC1(int[] nums) {
        int res = nums.length;
        int len = nums.length;

        for (int i = 0; i < len; i++) {

            for (int j = i; j <= len; j++) {
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, prev = Integer.MIN_VALUE;

                for (int k = i; k < j; k++) {
                    min = Math.min(min, nums[k]);
                    max = Math.max(max, nums[k]);
                }
                if ((i > 0 && nums[i - 1] > min) || (j < len && nums[j] < max)) {
                    continue;
                }
                int k = 0;
                while (k < i && prev <= nums[k]) {
                    prev = nums[k];
                    k++;
                }
                if (k != i) {
                    continue;
                }
                k = j;
                while (k < len && prev <= nums[k]) {
                    prev = nums[k];
                    k++;
                }
                if (k == len) {
                    res = Math.min(res, j-1);
                }
            }
        }
        return res;
    }
}
