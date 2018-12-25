package leetcode.easy;

import java.util.Stack;

public class No_682_BaseballGame {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < ops.length;i++) {
            switch (ops[i]) {
                case "+" : {
                    int para1 = stack.pop();
                    int para2 = stack.peek();
                    stack.push(para1);
                    stack.push(para1 + para2);
                    break;
                }
                case "D" :
                    stack.push(stack.peek() * 2);break;
                case "C" :
                    stack.pop();break;
                default :
                    stack.push(Integer.parseInt(ops[i]));break;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "-321";
        String temp = s.matches("^[-\\+]?[\\d]*$") ? "num" : "oth";
        System.out.println(temp);
        System.out.println(Integer.parseInt(s) + 1);
    }
}
