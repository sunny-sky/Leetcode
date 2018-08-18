package leetcode.array.easy;

public class No_169_MajorityElement {
    public int majorityElement(int[] nums) {
        int temp = nums[0];
        int n = 1;
        for (int i = 1; i < nums.length; i++) {
            //System.out.println("进入for,n:"+n+",i:"+i+"num[i]:"+nums[i]+",temp:"+temp);
            if (nums[i] == temp) {
                n++;
            }
            else if (nums[i] != temp && n != 0) {
                n--;
            }
            else {
                temp = nums[i];
                n = 1;
            }
        }
        return temp;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,5,5};
        No_169_MajorityElement me = new No_169_MajorityElement();
        System.out.println(me.majorityElement(arr));
    }
}
