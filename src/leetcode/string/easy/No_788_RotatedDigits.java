package leetcode.string.easy;

public class No_788_RotatedDigits {
    public static int rotatedDigits(int N) {
        // String s = String.valueOf(N);
        // String s = Integer.toString(N);
        // String s = "" + N;

        int count = 0;
        for (int i = 1; i <= N; ++i) {
            if (isValid(i))
                count++;
        }
        return count;

    }

    public static boolean isValid (int N) {
        boolean validFound = false;
        while (N > 0) {
            if (N % 10 == 2) validFound = true;
            if (N % 10 == 5) validFound = true;
            if (N % 10 == 6) validFound = true;
            if (N % 10 == 9) validFound = true;
            if (N % 10 == 3) return false;
            if (N % 10 == 4) return false;
            if (N % 10 == 7) return false;
            N = N / 10;
        }

        return validFound;
    }


    public static void main(String[] args) {
        int N = 10;
        System.out.println(rotatedDigits(N));
    }
}
