package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

    /**
     * @Description 四数之和
     * @Auther Liang
     * @date 12:13 2019/2/17
     * @param nums 输入数
     * @param target 目标数
     * @return java.util.List<java.util.List<java.lang.Integer>>
     */
    public List<List<Integer>> fourSum1(int[] nums, int target) {
        int len = nums.length;
        if (len < 4) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 遍历数组中每个不同的数，确定第一个数后，考虑三数之和
        for (int i = 0; i < len - 3; i++) {
            // 跳过相同元素，去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 有序数组，nums[i]过大，不存在合法结果，直接跳过
            if (nums[i] * 4 > target) {
                break;
            }
            // 同上，过小，跳过
            if (nums[i] + nums[len - 1] * 3 < target) {
                continue;
            }

            // 确定第一个数
            int n1 = nums[i];
            // 三数之和
            for (int j = i + 1; j < len - 2; j++) {
                // 同上的去重操作
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] * 3 > target) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[len - 1] * 2 < target) {
                    continue;
                }
                // 确定第二个数，之后确定2数之和
                int n2 = nums[j];
                int sum0 = n1 + n2;
                // 第三数指针
                int l = j + 1;
                // 去无效数据
                if (sum0 == target && nums[l] > 0) {
                    break;
                }
                // 第四数指针
                int r = len - 1;

                while (r > l) {
                    int n3 = nums[l];
                    int n4 = nums[r];
                    int sum = sum0 + n3 + n4;
                    if (sum == target) {
                        result.add(Arrays.asList(n1, n2, n3, n4));
                        // 第三数改变，第四数页必须改变才能匹配
                        l++;
                        r--;
                        // 去重
                        while (r > l && nums[l] == nums[l - 1]) {
                            l++;
                        }
                        while (r > l && nums[r] == nums[r + 1]) {
                            r--;
                        }
                    } else if (sum > target) {
                        r--;
                    } else {
                        l++;
                    }
                }

            }
        }
        return result;
    }
}
