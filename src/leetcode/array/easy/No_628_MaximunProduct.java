package leetcode.array.easy;

public class No_628_MaximunProduct {
    public int maximumProduct(int[] nums) {
        if (nums.length == 3) {
            return nums[0]*nums[1]*nums[2];
        }
        int len = nums.length;
        Integer max1=null,max2=null,max3=null,min1=null,min2=null;
        for (int i = 0; i < len; i++) {
            // 取三个最大的值
            if (max1 == null || nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }
            else if (max2 == null || nums[i] > max2 && nums[i] <= max1) {
                max3 = max2;
                max2 = nums[i];
            }
            else if (max3 == null || nums[i] > max3 && nums[i] <= max2) {
                max3 = nums[i];
            }
            // 取2个最小的值
            if (min1 == null || nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            }
            else if (min2 == null || nums[i] < min2 && nums[i] >= min1) {
                min2 = nums[i];
            }
        }
//        System.out.println("max1:"+max1);
//        System.out.println("max2:"+max2);
//        System.out.println("max3:"+max3);
//        System.out.println("min1:"+min1);
//        System.out.println("min2:"+min2);
        int res1 = max3 * max2 * max1;
        int res2 = max1 * min1 * min2;
        return res1>res2 ? res1 : res2;
    }

    public static void main(String[] args) {
        No_628_MaximunProduct func = new No_628_MaximunProduct();
        int[] input = new int[] {1,2,3,2};
        int res = func.maximumProduct(input);
        System.out.println(res);
    }
}
