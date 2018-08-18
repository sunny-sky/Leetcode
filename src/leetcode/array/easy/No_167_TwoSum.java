package leetcode.array.easy;

public class No_167_TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int i = 1,j = numbers.length;
        while (numbers[i-1] + numbers[j-1] != target) {
            if (numbers[i-1] + numbers[j-1] > target)
                j--;
            if (numbers[i-1] + numbers[j-1] < target)
                i++;
        }
        return new int[] {i,j};
    }
}
