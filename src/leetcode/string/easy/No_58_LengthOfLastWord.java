package leetcode.string.easy;

public class No_58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String words[] = s.split(" ");
        if (words.length == 0) {
            return 0;
        }
        return words[words.length - 1].length();
    }
}
