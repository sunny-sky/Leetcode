package test.leetcode.medium;

import leetcode.medium.No_046;
import org.junit.Test;

import java.util.List;

public class No_046Test {

    @Test
    public void permute() {
        int[] test = new int[]{1, 2, 3};
        No_046 temp = new No_046();
        List<List<Integer>> res = temp.permute(test);
        System.out.println(res.toString());
    }
}