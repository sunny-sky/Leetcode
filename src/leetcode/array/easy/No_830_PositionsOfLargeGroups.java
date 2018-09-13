package leetcode.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_830_PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0, len = S.length(); //i为每一组的开头
        for (int j = 0; j < len; ++j) {
            //[i,j]代表一组的开头、结束位置
            if (j == len - 1 || S.charAt(j) != S.charAt(j+1)) {
                if (j - i + 1 >= 3) {
                    ans.add(Arrays.asList(new Integer[]{i, j}));
                }
                i = j + 1;
            }
        }
        return ans;
    }
}
