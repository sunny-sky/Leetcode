package leetcode.medium;

/**
 * @Author: Liang
 * @Description: 盛最多水的容器
 * @Date: Created in 15:24 2019/1/30
 */
public class No_011 {
    /**
     * @Description 盛最多水的容器
     * @Auther Liang
     * @date 15:24 2019/1/30
     * @param height 输入数组
     * @return int
     */
    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                int area = Math.abs(i - j) * Math.min(height[i], height[j]);
                res = (res >= area ? res : area);
            }
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * @Description 盛最多水的容器,O(n)的算法，从两边向中间扫描
     * @Auther Liang
     * @date 16:24 2019/1/30
     * @param height 输入数组
     * @return int
     */
    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
