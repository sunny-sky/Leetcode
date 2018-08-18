package leetcode.array.easy;

public class No_066_PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newNumber = new int [n+1];
        newNumber[0] = 1;

        return newNumber;
    }
    public int[] plusOne2(int[] digits) {
        int temp = 1;
        for (int i = 0; i < digits.length; i++) {
            if (digits[digits.length - i - 1]==9 && temp ==1) {
                digits[digits.length - i - 1] = 0;
            }
            else if (digits[digits.length - i - 1]!=9 && temp ==1) {
                digits[digits.length - i - 1] += 1;
                temp = 0;
            }
        }
        if (digits[0]==0) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i+1] = 0;
            }
            return result;
        }
        return digits;
    }
}
