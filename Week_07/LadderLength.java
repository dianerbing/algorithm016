package wb.test;

import java.util.*;

/**
 * 127. 单词接龙
 * https://leetcode-cn.com/problems/word-ladder/
 */
public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);
        if (!wordSet.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        return deBFS(wordSet, beginSet, endSet, 2);
    }

    public int deBFS(Set<String> wordSet, Set<String> beginSet, Set<String> endSet, int depth) {
        if (endSet.size() < beginSet.size()) return deBFS(wordSet, endSet, beginSet, depth);

        wordSet.removeAll(beginSet);

        Set<String> next = new HashSet<>();
        for (String begin : beginSet) {
            char[] cs = begin.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char old = cs[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    cs[i] = c;
                    String word = new String(cs);
                    if (wordSet.contains(word)) {
                        if (endSet.contains(word)) {
                            return depth;
                        }

                        next.add(word);
                    }
                }
                cs[i] = old;
            }
        }

        if (next.size() < 1) return 0;

        return deBFS(wordSet, next, endSet, depth + 1);
    }
}
