package leetcode.medium;

/**
 * @Author: Liang
 * @Description: 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素
 * 相邻，并按照红色、白色、蓝色顺序排列。
 * @Date: Created in 16:29 2019/3/26
 */
public class No_075 {
    /**
     * @Description 颜色分类, 1-pass
     * @Auther Liang
     * @date 16:30 2019/3/26
     * @param nums input int[]
     * @return void
     */
    public void sortColors(int[] nums) {
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
        }
    }

    /**
     * @Description 颜色分类, 2-pass
     * @Auther Liang
     * @date 16:46 2019/3/26
     * @param nums input int[]
     * @return void
     */
    public void sortColors1(int[] nums) {
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            } else if (nums[i] == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < count0) {
                nums[i] = 0;
            } else if (i < count0 + count1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
