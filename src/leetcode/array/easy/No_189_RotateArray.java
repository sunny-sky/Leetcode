package leetcode.array.easy;

public class No_189_RotateArray {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len == 1 || k == 0 || k == len)
            return;
        if (k > len)
            k = k - len;
        reverseArr(nums,0,len-1);
        reverseArr(nums,0,k-1);
        reverseArr(nums,k,len-1);
    }
    public void reverseArr(int[] nums, int head, int rear) {
        int temp;
        for (int i = 0; i <= (rear - head) / 2; i ++) {
            //System.out.println("head:"+head+",rear:"+rear);
            temp = nums[head+i];
            nums[head+i] = nums[rear-i];
            nums[rear-i] = temp;
        }
    }
}
