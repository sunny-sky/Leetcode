package leetcode.easy;

public class No_204_CountPrimes {
    public int countPrimes(int n) {
        boolean[] isP = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i ++) {
            if (isP[i] == false) {
                count++;
                for (int j = 2; i * j < n; j++) {
                    isP[i * j] = true;
                }
            }
        }
        return count;
    }
}
