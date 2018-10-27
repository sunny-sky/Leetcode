package leetcode.easy;

import javafx.scene.chart.Chart;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No_205_IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length(), count = 0;
        int[] temp1 = new int[len], temp2 = new int[len];
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                temp1[i] = map.get(s.charAt(i));
                // System.out.println("temp1[i]"+temp1[i]);
            } else {
                temp1[i] = count;
                map.put(s.charAt(i), count);
                // System.out.println("temp1[i]"+temp1[i]);
                count++;
            }
        }
        map.clear();
        count = 0;
        for (int j = 0; j < len; j++) {
            if (map.containsKey(t.charAt(j))) {
                temp2[j] = map.get(t.charAt(j));
                // System.out.println("temp2[j]"+temp2[j]);
            } else {
                temp2[j] = count;
                map.put(t.charAt(j), count);
                count++;
                // System.out.println("temp2[j]"+temp2[j]);
            }
        }
        if (Arrays.equals(temp1, temp2))
            return true;
        else
            return false;
    }
}
