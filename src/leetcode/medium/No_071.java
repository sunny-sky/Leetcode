package leetcode.medium;

import java.util.Deque;
import java.util.LinkedList;

public class No_071 {
    public String simplifyPath(String path) {
        // 双向队列
        Deque<String> stack = new LinkedList<>();
        for (String s : path.split("/")) {
            // ..则返回上一层
            if (s.equals("..")) {
                stack.poll();
            } else if (!s.equals("") && !s.equals(".")) {
                // 非.  或 / ，将s加入队列
                stack.push(s);
            }
        }
        // StringBuilder 不产生新对象且可更改，线程不安全
        StringBuilder sb = new StringBuilder();
        if (stack.size() == 0) {
            return "/";
        }
        // 非空则循环构造路径
        while (stack.size() != 0) {
            sb.append("/").append(stack.pollLast());
        }
        return sb.toString();
    }
}
