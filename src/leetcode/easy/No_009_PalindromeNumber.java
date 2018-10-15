package leetcode.easy;

public class No_009_PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int len = 0, temp = x;
        while (temp != 0) {
            temp /= 10;
            len++;
        }

        for (int i = 1; i <= len / 2; i++) {
            if ((x % (int) Math.pow(10, i)) / (int)Math.pow(10, i - 1) != (x / (int)Math.pow(10, len - i)) % 10) {
                System.out.println(((x % (int) Math.pow(10, i)) / (int) Math.pow(10, i - 1)));
                System.out.println((x / (int) Math.pow(10, len - i)) % 10);
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(int x) {
        if (x < 0)
            return false;
        int temp = x, newX = 0;
        while (x != 0) {
            newX = newX * 10 + x % 10;
            x /= 10;
        }
        return newX == temp;
    }

    public boolean isPalindrome3(int x) {
        if (x < 0) {
            return false;
        }
        int n = x;
        int tmp  = 0;
        while (x != 0) {
            tmp = tmp * 10 + x % 10;
            x = x/10;
        }
        return n == tmp ? true : false;
    }

    public static void main(String[] args) {
        int x = 1221;
        System.out.println(isPalindrome(x));
    }
}
