package leetcode.array.easy;

public class No_035_SearchInsert {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        while (i < nums.length && nums[i] < target) {
                i++;
        }
        return i;
    }
    public int searchInsert2(int[] nums, int target) {
        int head = 0,rear = nums.length - 1,mid = ( head + rear ) / 2;
        while (head <= rear) {
            if (nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target) {
                head = mid + 1;
                mid = ( head + rear ) / 2;
            }
            else {
                rear = mid - 1;
                mid = ( head + rear ) / 2;
            }
        }
        return head;
    }
}
