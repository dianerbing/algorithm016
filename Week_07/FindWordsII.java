package wb.test;

import java.util.ArrayList;
import java.util.List;

/**
 * 212. 单词搜索 II
 * https://leetcode-cn.com/problems/word-search-ii/
 */
public class FindWordsII {
    class Trie {
        Trie[] children;
        String word;

        Trie() {
            children = new Trie[26];
        }

        public void insert(char[] chars, String word) {
            Trie parent = this;

            for (char c : chars) {
                int id = c - 'a';
                if (parent.children[id] == null) {
                    parent.children[id] = new Trie();
                }
                parent = parent.children[id];
            }

            parent.word = word;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            root.insert(word.toCharArray(), word);
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                back(board, i, j, root, ans);
            }
        }

        return ans;
    }

    public void back(char[][] board, int i, int j, Trie root, List<String> ans) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] == '*') return;

        char c = board[i][j];
        root = root.children[c - 'a'];
        if (root == null) return;

        if (root.word != null) {
            ans.add(root.word);
            root.word = null;
        }

        board[i][j] = '*';
        back(board, i + 1, j, root, ans);
        back(board, i - 1, j, root, ans);
        back(board, i, j + 1, root, ans);
        back(board, i, j - 1, root, ans);
        board[i][j] = c;
    }
}
