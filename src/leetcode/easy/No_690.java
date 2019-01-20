package leetcode.easy;

import leetcode.utils.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 16:53 2018/12/16
 */
public class No_690 {
    /**
     * @Description 员工的重要性
     * @Auther Liang
     * @date 16:55 2018/12/16
     * @param employees 最高领导人
     * @param id int
     * @return int
     */
    public int getImportance(List<Employee> employees, int id) {
        int totalIMP = 0;
        Stack<Employee> stack = new Stack<>();
        Map<Integer, Employee> map = new HashMap<>();

        for (Employee e : employees) {
            map.put(e.id, e);
        }

        stack.push(map.get(id));
        while (!stack.isEmpty()) {
            Employee temp = stack.pop();
            if (temp.subordinates.size() != 0) {
                for (Integer subID : temp.subordinates) {
                    stack.push(map.get(subID));
                }
            }
            totalIMP += temp.importance;
        }

        return totalIMP;
    }
}
