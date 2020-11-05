package wb.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 208. 实现 Trie (前缀树)
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
class Trie {
    Map<Character, TrieNode> dicts;
    Set<String> sets;

    class TrieNode {
        char c;
        TrieNode[] children;

        TrieNode(char c) {
            this.c = c;
            children = new TrieNode[26];
        }

        public void insert(char[] chars, int begin) {
            if (begin >= chars.length - 1) return;
            char c0 = chars[begin], c1 = chars[begin + 1];

            if (c == c0) {
                if (children[c1 - 'a'] != null) {
                    children[c1 - 'a'].insert(chars, begin + 1);
                } else {
                    TrieNode node = new TrieNode(c1);
                    node.insert(chars, begin + 1);
                    children[c1 - 'a'] = node;
                }
            }
        }

        public boolean find(char[] chars, int begin) {
            if (begin >= chars.length - 1) return true;
            char c0 = chars[begin], c1 = chars[begin + 1];

            if (c == c0) {
                if (children[c1 - 'a'] != null) {
                    return children[c1 - 'a'].find(chars, begin + 1);
                }
            }

            return false;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        dicts = new HashMap<>();
        sets = new HashSet<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() < 1) return;

        if (!sets.contains(word)) {
            sets.add(word);

            char[] chars = word.toCharArray();
            if (dicts.containsKey(chars[0])) {
                dicts.get(chars[0]).insert(chars, 0);
            } else {
                TrieNode node = new TrieNode(chars[0]);
                node.insert(chars, 0);
                dicts.put(chars[0], node);
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return sets.contains(word);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() < 1) return false;

        char[] chars = prefix.toCharArray();
        if (dicts.containsKey(chars[0])) {
            return dicts.get(chars[0]).find(chars, 0);
        }

        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
