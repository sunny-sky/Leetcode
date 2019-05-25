package test.leetcode.medium;

import leetcode.medium.No_093;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class No_093Test {

    @Test
    public void restoreIpAddresses() {
        No_093 example = new No_093();
        String s = "255255035";
        List<String> solutions = new ArrayList<>();
        solutions = example.restoreIpAddresses(s);
        for (String s1 : solutions) {
            System.out.println(s1);
        }
    }
}