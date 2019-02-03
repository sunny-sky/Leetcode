package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Liang
 * @Description: 两个列表的最小索引总和
 * @Date: Created in 17:25 2019/1/29
 */
public class No_599 {
    /**
     * @param list1 输入列表参数
     * @param list2 输入列表参数
     * @return java.lang.String[]
     * @Description 两个列表的最小索引总和
     * @Auther Liang
     * @date 17:26 2019/1/29
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], map.getOrDefault(list1[i], i));
        }
        List<int[]> temp = new ArrayList<>();
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                temp.add(new int[]{j, j + map.get(list2[j])});
            }
        }
        int min = Integer.MAX_VALUE;
        List<Integer> index = new ArrayList<>();
        for (int k = 0; k < temp.size(); k++) {
            if (temp.get(k)[1] < min) {
                index.clear();
                min = temp.get(k)[1];
                index.add(temp.get(k)[0]);
            } else if (temp.get(k)[1] == min) {
                index.add(temp.get(k)[0]);
            }
        }
        String[] ans = new String[index.size()];
        for (int i = 0; i < index.size(); i++) {
            ans[i] = list2[index.get(i)];
        }
        return ans;
    }
}
