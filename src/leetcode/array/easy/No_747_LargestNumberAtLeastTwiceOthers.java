package leetcode.array.easy;

public class No_747_LargestNumberAtLeastTwiceOthers {
    public static int dominantIndex(int[] nums) {
        int len = nums.length;
        if (len == 1){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] > nums[res]){
                res = i;
            }
        }
        int temp;
        if (res == 0){
            temp = nums[1];
        }else{
            temp = nums[0];
        }
        for (int j = 0; j < len; j++) {
            if(nums[j] > temp && j != res){
                temp = nums[j];
            }
        }
        return nums[res] >= 2 * temp ? res : -1;
    }

    public static void main(String[] args) {
        int[] h = new int[]{2,0};
        int res = dominantIndex(h);
        System.out.println(res);
    }

    public static int dominantIndex2(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return 0;
        }
        int first = 0,second = 0,pos=0;
        if(nums[1] > nums[0]){
            first = nums[1];
            second = nums[0];
            pos = 1;
        }else{
            first = nums[0];
            second = nums[1];
            pos = 0;
        }
        for (int i = 2; i < len; i++) {
            if (nums[i] > first) {
                pos = i;
                second = first;
                first = nums[i];
            }
            else{
                if (nums[i] >second) {
                    second = nums[i];
                }
            }
        }
        return first >= 2 * second ? pos : -1;
    }
}
