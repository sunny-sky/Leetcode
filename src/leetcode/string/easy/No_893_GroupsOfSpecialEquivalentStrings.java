package leetcode.string.easy;

import sun.util.resources.cldr.lag.CalendarData_lag_TZ;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No_893_GroupsOfSpecialEquivalentStrings {
    public int numSpecialEquivGroups(String[] A) {

        Set<String> seen = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            int[] count = new int[52];
            for (int j = 0; j < A[0].length(); j++) {
                count[A[i].charAt(j) - 'a' + 26 * (j % 2)]++;
            }
            seen.add(Arrays.toString(count));
        }
        return seen.size();
    }
}
