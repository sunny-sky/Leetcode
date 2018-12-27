package leetcode.easy;

import java.util.Stack;

public class No_844_BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack_S = new Stack<>();
        Stack<Character> stack_T = new Stack<>();

        char[] ch_S = S.toCharArray();
        char[] ch_T = T.toCharArray();

        for (char ch : ch_S) {
            if (ch != '#')
                stack_S.push(ch);
            else if (!stack_S.isEmpty())
                stack_S.pop();
        }

        for (char aCh_T : ch_T) {
            if (aCh_T != '#') {
                stack_T.push(aCh_T);
            } else if (!stack_T.isEmpty()){
                stack_T.pop();
            }
        }

        if (stack_S.size() != stack_T.size()) {
            return false;
        } else {
            for (int k = 0; k <stack_S.size(); k++) {
                if (stack_S.pop() != stack_T.pop())
                    return false;
            }
            return true;
        }
    }
}
