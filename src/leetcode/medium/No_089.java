package leetcode.medium;

import java.util.LinkedList;
import java.util.List;

public class No_089 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }
}
