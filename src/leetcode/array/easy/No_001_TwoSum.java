package leetcode.array.easy;

import java.util.HashMap;
import java.util.Map;

public class No_001_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    /*int[] result = {i, j};
                    return result;*/
                    return new int[] {i,j};
                }
            }
        }
        /*return null;*/
        throw new IllegalArgumentException("不存在符合条件的参数");
    }

    public static void main(String[] args){
        No_001_TwoSum ts = new No_001_TwoSum();
        int[] nums = {1, 2, 3, 4, 5};
        int target = 9;
        int[] result = ts.twoSum3(nums, target);
        System.out.println("我的答案"+(result[0]+1)+" "+(result[1]+1));
    }
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for (int i = 0; i<nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[] {i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("无符合条件参数");
    }

    public int[] twoSum3(int[] nums,int target){
        Map<Integer, Integer> map = new HashMap<>();
        // 对muns中每个数，若map中存在key = target - nums[i];则返回他们在nums中的下标
        // 若不存在，则把num[i]和它的下表i放入map中，等待后续元素匹配
        // 匹配成功，意味着nums[i] + nums[j] = target
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("无符合条件参数");
    }
}