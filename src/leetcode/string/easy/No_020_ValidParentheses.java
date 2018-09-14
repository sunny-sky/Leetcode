package leetcode.string.easy;

public class No_020_ValidParentheses {
    public static boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int head = 0;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '{':
                case '[':
                case '(':
                    stack[head++] = c;
                    break;
                case '}':
                    if (head == 0 || stack[--head] != '{')
                        return false;
                    break;
                case ')':
                    if (head == 0 || stack[--head] != '(')
                        return false;
                    break;
                case ']':
                    if (head == 0 || stack[--head] != '[')
                        return false;
                    break;
            }
        }
        return head == 0;
    }

    public static void main(String[] args) {
        String s = "()";
        String res = isValid(s) ? "是":"不是";
        System.out.println(res);
    }
}
