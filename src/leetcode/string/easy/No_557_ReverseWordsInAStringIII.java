package leetcode.string.easy;

public class No_557_ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        String[] sbs = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String sb : sbs) {
            StringBuilder temp = new StringBuilder(sb);
            res.append(temp.reverse());
            res.append(" ");
        }
        return res.toString().trim();
    }
}
