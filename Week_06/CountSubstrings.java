package wb.test;

public class CountSubstrings {
    /**
     * 647. 回文子串
     * https://leetcode-cn.com/problems/palindromic-substrings/
     */

    //解法一：DP
     public int countSubstrings_dp(String s) {
         //状态转移方程
         //dp[i][j] = true if (s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1] == true))

         int ans = 0;
         char[] cs = s.toCharArray();
         boolean[][] dp = new boolean[cs.length][cs.length];

         for (int j = 0; j < cs.length; j++) {
             for (int i = 0; i <= j; i++) {
                 if (cs[i] == cs[j] && (j - i < 2 || dp[i + 1][j - 1])) {
                     ans++;
                     dp[i][j] = true;
                 }
             }
         }

         return ans;
     }

     //解法二：中心扩展法
     public int countSubstrings_center(String s) {
         //中心扩展法
         int ans = 0;
         char[] cs = s.toCharArray();   //转成字符数组，效率会提升

         //长度为n的字符串，考虑中心有1位和2位的情况，中心的个数为2 * n - 1
         //举例：aba的中心可以是 a, b, a, ab, ba
         //     abab的中心可以是a, b, a, b, ab, ba, ab
         for (int center = 0; center < (2 * cs.length - 1); center++) {
             int left = center / 2;
             int right = left + center % 2;
             while (left >= 0 && right < cs.length && cs[left] == cs[right]) {
                 ans++;
                 left--;
                 right++;
             }
         }

         return ans;
     }
}
