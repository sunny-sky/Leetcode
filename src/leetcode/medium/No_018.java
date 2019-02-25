package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Liang
 * @Description: 四数之和
 * @Date: Created in 12:12 2019/2/17
 */
public class No_018 {
    /**
     * @Description 四数之和
     * @Auther Liang
     * @date 12:13 2019/2/17
     * @param nums 输入数
     * @param target 目标数
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int head, rear;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int temp = target - nums[i] - nums[j];
                head = j + 1;
                rear = nums.length - 1;
                while (head < rear) {
                    if (temp == nums[head] + nums[rear]) {
                        List<Integer> arrayRes = new ArrayList<>();
                        arrayRes.add(nums[i]);
                        arrayRes.add(nums[j]);
                        arrayRes.add(nums[head]);
                        arrayRes.add(nums[rear]);
                        res.add(arrayRes);
                        while (head + 1 < rear && nums[head + 1] == nums[head]) {
                            head++;
                        }
                        head++;
                    } else if (temp > nums[head] + nums[rear]) {
                        head++;
                    } else {
                        rear--;
                    }
                }
                while (j + 1 < nums.length - 2 && nums[j + 1] == nums[j]) {
                    j++;
                }
            }
            while (i + 1 < nums.length - 2 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return res;
    }
}
