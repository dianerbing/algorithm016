package wb.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//字母异位词
public class IsAnagram {
    //sort
    public boolean isAnagram0(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    //hashmap
    public boolean isAnagram1(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        char[] sc = s.toCharArray();
        for (int i=0; i<sc.length; i++) {
            int count = map.getOrDefault(sc[i], 0);
            map.put(sc[i], count+1);
        }

        char[] tc = t.toCharArray();
        for (int i=0; i<tc.length; i++) {
            int count = map.getOrDefault(tc[i], 0);
            if (count <= 0) {
                return false;
            } else {
                if (count == 1) {
                    map.remove(tc[i]);
                } else {
                    map.put(tc[i], count-1);
                }
            }
        }
        if (map.size() > 0) {
            return false;
        }
        return true;
    }

    //用字母数组代替hashmap
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    //同样用字母数组，另一种写法
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
