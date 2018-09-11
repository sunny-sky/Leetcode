package leetcode.array.easy;

public class No_896_MonotonicArray {
    public boolean isMonotonic(int[] A) {
        int len = A.length;
        int flag = 0;

        for (int i = 0; i < len - 1; ++i) {
            if (A[i] == A[i+1])
                continue;
            else if (A[i] > A[i+1] && flag == 0) {
                flag = -1;
            }
            else if (A[i] < A[i+1] && flag == 0) {
                flag = 1;
            }
            else if (A[i] > A[i+1] && flag == 1) {
                return false;
            }
            else if (A[i] < A[i+1] && flag == -1) {
                return false;
            }
        }
        return true;
    }
}
