package leetcode.medium;

import leetcode.utils.Interval;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: Liang
 * @Description: 给出一个区间的集合，请合并所有重叠的区间
 * @Date: Created in 10:26 2019/3/22
 */
public class No_056 {
    /**
     * @Description 合并区间
     * @Auther Liang
     * @date 10:27 2019/3/22
     * @param intervals 输入的区间集合
     * @return List<Interval>
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        // 比较器，比较start
        intervals.sort(Comparator.comparingInt(i -> i.start));
        List<Interval> res = new LinkedList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        // 最后一个区间
        res.add(new Interval(start, end));
        return res;
    }
}
