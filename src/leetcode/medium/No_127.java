package leetcode.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        } else if (beginWord == endWord && wordList.contains(beginWord)) {
            return 1;
        }
        // 在第distance步能到达的边界
        Set<String> wList = new HashSet<>(wordList);
        Set<String> reached = new HashSet<>();
        Set<String> end = new HashSet<>();
        Set<String> visited = new HashSet<>();
        reached.add(beginWord);
        end.add(endWord);
        int distance = 1;
        // i既是当前长度，初始2
        for (int i = 2; !reached.isEmpty(); i++) {
            Set<String> temp = new HashSet<>();
            for (String word : reached) {
                for (int j = 0; j < word.length(); j++) {
                    char[] ch = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == word.charAt(j)) {
                            continue;
                        }
                        ch[j] = c;
                        String newWord = String.valueOf(ch);
                        if (end.contains(newWord)) {
                            return i;
                        }
                        if (wList.contains(newWord) && visited.add(newWord)) {
                            temp.add(newWord);
                        }
                    }
                }
            }
            reached = (temp.size() < end.size()) ? temp : end;
            end = (reached == temp) ? end : temp;
        }
        return 0;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wList = new HashSet<>(wordList);
        if (!wList.contains(endWord)) {
            return 0;
        }
        Set<String> reached = new HashSet<>();
        Set<String> hasReaached = new HashSet<>();
        reached.add(beginWord);
        hasReaached.add(beginWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == chars[i]) {
                            continue;
                        }
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wList.contains(word)) {
                            if (!hasReaached.contains(word)) {
                                toAdd.add(word);
                                hasReaached.add(word);
                                wList.remove(word);
                            }
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) {
                return 0;
            }
            reached = toAdd;
        }
        return distance;
    }

    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        Set<String> wList = new HashSet<>(wordList);
        if (!wList.contains(endWord)) {
            return 0;
        }
        Set<String> reached = new HashSet<>();
        reached.add(beginWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (ch == chars[i]) {
                            continue;
                        }
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wList.contains(word)) {
                            toAdd.add(word);
                            wList.remove(word);

                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) {
                return 0;
            }
            reached = toAdd;
        }
        return distance;
    }
}
