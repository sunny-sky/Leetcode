package leetcode.array.easy;

public class No_088_Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int point1 = 0, point2 = 0,i=0;
        int[] result = new int[m+n];
        while (point1 < m && point2 < n) {
            if (nums1[point1] < nums2[point2]) {
                result[i++] = nums1[point1++];
            }
            else {
                result[i++] = nums2[point2++];
            }
        }
        if (point1 == m) {
            for (;point2 < n; point2++) {
                result[i++] = nums2[point2];
            }
        }
        if (point2 == n) {
            for (;point1 < m; point1++) {
                result[i++] = nums1[point1];
            }
        }
        for (int j = 0; j < m + n; j++) {
            nums1[j] = result[j];
        }
    }
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1, j=n-1, k=m+n-1;
        while (i>-1 && j>-1)
            nums1[k--]= (nums1[i]>nums2[j]) ? nums1[i--] : nums2[j--];
        while (j>-1)
            nums1[k--]=nums2[j--];
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3,n = 3;
        No_088_Merge no88Merge = new No_088_Merge();
        no88Merge.merge(nums1,m,nums2,n);
        for (int i = 0; i < m + n; i++) {
            System.out.println(nums1[i]+ "  ");
        }
    }
}
