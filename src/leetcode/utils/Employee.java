package leetcode.utils;

import java.util.List;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 16:54 2018/12/16
 */
public class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
}
