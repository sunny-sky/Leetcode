package leetcode.medium;

public class No_096 {
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int res = 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        return dp(n, dp);
    }

    private int dp(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        for (int i = 1; i < n + 1; i++) {
            dp[n] += dp(n - i, dp) * dp(i - 1, dp);
        }
        return dp[n];
    }

    public int numTrees2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int j = 0, k = i - 1;
            while (j < i) {
                dp[i] += dp[j++] * dp[k--];
            }
        }
        return dp[n];
    }

    public int numTrees3(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int j = 0, k = i - 1;
            while (j < k) {
                dp[i] += 2 * dp[j++] * dp[k--];
            }
            if (j == k) {
                dp[i] += dp[j] * dp[j];
            }
        }
        return dp[n];
    }
}
