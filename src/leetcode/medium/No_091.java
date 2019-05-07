package leetcode.medium;

public class No_091 {
    // num_ways ("") => 1 (empty string can be represented by empty string) (i.e. num_ways[n] = 1) NOTE: only for build up with a valid string. Empty string on it's own doesn't need to be decoded.
    //num_ways ("3") => 1 (only one way), i.e. num_ways[n-1] = 1
    //num_ways ("23") => "23" or "2"-"3",
    //num_ways ("33") => "3""3"
    //num_ways ("123") => "12"(num_ways("3")) + "1"("num_ways("23")) (i.e. num_ways[i+2] + num_ways[i+1])
    //num_ways ("323") => "3"(num_ways("23")) (i.e. num_ways[i+1])
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            } else {
                memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ?
                        memo[i + 1] + memo[i + 2] : memo[i + 1];
            }
        }
        return memo[0];
    }
}
