package leetcode.string.easy;

public class No_520_DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1)
            return true;
        if (word.charAt(0) <= 'z' && word.charAt(0) >= 'a') {
            for (int i = 1; i < word.length(); ++i) {
                if (word.charAt(i) < 'a' || word.charAt(i) > 'z')
                    return false;
            }
            return true;
        }
        else {
            if (word.charAt(1) <= 'z' && word.charAt(1) >= 'a') {
                for (int i = 2; i < word.length(); ++i) {
                    if (word.charAt(i) < 'a' || word.charAt(i) > 'z')
                        return false;
                }
                return true;
            }
            else {
                for (int i = 2; i < word.length(); ++i) {
                    if (word.charAt(i) < 'A' || word.charAt(i) > 'Z')
                        return false;
                }
                return true;
            }
        }
    }

    public boolean detectCapitalUse2(String word) {
        return word.substring(1).equals(word.substring(1).toLowerCase())||word.equals(word.toUpperCase());
    }

    public boolean detectCapitalUse3(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }
}
