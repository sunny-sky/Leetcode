package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No_350_IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }

        int[] temp = new int[Math.min(nums1.length, nums2.length)];
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) +1);
        }

        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j]) && map.get(nums2[j]) > 0) {
                temp[index++] = nums2[j];
                map.put(nums2[j], map.get(nums2[j]) - 1);
            }
        }

        return Arrays.copyOf(temp, index);
    }
}
