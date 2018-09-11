package leetcode.array.easy;

public class No_888_FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int sum = 0, sumA = 0, dif = 0;

        for (int i = 0; i < lenA; ++i) {
            sum += A[i];
            sumA = sum;
        }
        for (int i = 0; i < lenB; ++i) {
            sum += B[i];
        }
        dif = sum / 2 - sumA;
        for (int i = 0; i < lenA; ++i) {

            for (int j = 0; j < lenB; ++j) {
                if (A[i] + dif == B[j]) {
                    return new int[] {A[i], B[j]};
                }
            }
        }
        return null;
    }
}
