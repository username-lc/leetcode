//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串  动态规划
// 👍 2654 👎 0

package com.cute.leetcode.editor.cn;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome("abcba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.equals("")) {
                return s;
            }
            boolean[][] dp = new boolean[s.length()][s.length()];

            for (int i = 0; i < s.length(); i++) {
                dp[i][i] = true;
            }
            int max = 1;
            int begin = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (j - i == 1) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = dp[i + 1][j - 1];
                        }
                    } else {
                        dp[i][j] = false;
                    }
                    if (dp[i][j] && j - i + 1 > max) {
                        max = j - i + 1;
                        begin = i;
                    }
                }
            }
            return s.substring(begin, begin + max);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}