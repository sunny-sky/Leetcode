package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No_349_IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0)
            return new int[0];
        int[] res = new int[nums1.length + nums2.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i]))
                map.put(nums1[i], 1);
        }
        for (int j = 0; j < nums2.length; j++) {
            if (map.containsKey(nums2[j]))
                map.put(nums2[j], 2);
        }
        int point = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 2)
                res[point++] = entry.getKey();
        }

        int[] temp = new int[point];
        System.arraycopy(res, 0, temp, 0, point);
        /*for (int k = 0; k < point; k++) {
            temp[k] = res[k];
        }*/

        return temp;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index = 0, i1 = 0, i2 = 0;
        int[] temp = new int[nums2.length];
        while (i1 < nums1.length && i2 <nums2.length) {
            if (nums1[i1] == nums2[i2]) {
                temp[index++] = nums2[i2++];
                while (i2 < nums2.length && nums1[i1] == nums2[i2])
                    i2++;
            } else if (nums1[i1] < nums2[i2]) {
                i1++;
            } else {
                i2++;
            }
        }
        return Arrays.copyOf(temp, index);
    }
}
