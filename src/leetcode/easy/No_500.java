package leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: Liang
 * @Description:
 * @Date: Created in 12:37 2019/1/25
 */
public class No_500 {
    /**
     * @Description 键盘行
     * @Auther Liang
     * @date 12:38 2019/1/25
     * @param words 输入目标词组
     * @return java.lang.String[]
     */
    public String[] findWords(String[] words) {
        HashSet<Character> line1 = new HashSet<Character>() {
            {
                add('q');
                add('w');
                add('e');
                add('r');
                add('t');
                add('y');
                add('u');
                add('i');
                add('o');
                add('p');
            }
        };
        HashSet<Character> line2 = new HashSet<Character>() {
            {
                add('a');
                add('s');
                add('d');
                add('f');
                add('g');
                add('h');
                add('j');
                add('k');
                add('l');
            }
        };
        HashSet<Character> line3 = new HashSet<Character>() {
            {
                add('z');
                add('x');
                add('c');
                add('v');
                add('b');
                add('n');
                add('m');
            }
        };
        List<String> res = new ArrayList<>();
        for (String word : words) {
            String lowerCase = word.toLowerCase();
            HashSet<Character> target;
            if (line1.contains(lowerCase.charAt(0))) {
                target = line1;
            } else if (line2.contains(lowerCase.charAt(0))) {
                target = line2;
            } else {
                target = line3;
            }
            int i = 1;
            for (; i < word.length(); i++) {
                if (!target.contains(lowerCase.charAt(i))) {
                    break;
                }
            }
            if (i == word.length()) {
                res.add(word);
            }
        }
        String[] resArray = new String[res.size()];
        res.toArray(resArray);
        return resArray;
    }
}
