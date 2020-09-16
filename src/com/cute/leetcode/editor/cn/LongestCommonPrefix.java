//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 示例 1: 
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
// 
//
// 示例 2: 
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
// 
//
// 说明: 
//
// 所有输入只包含小写字母 a-z 。 
// Related Topics 字符串 
// 👍 1260 👎 0

package com.cute.leetcode.editor.cn;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        String[] strs = {"dog"};
        System.out.println(solution.longestCommonPrefix(strs));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }
            int minLength = strs[0].length();
            for (String str : strs) {
                minLength = Math.min(minLength, str.length());
            }
            String longestCommonPrefix = strs[0].substring(0, minLength);
            /*for (int i = 1; i <= minLength; i++) {
                int sum = 1;
                String str = strs[0].substring(0, i);
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].substring(0, i).equals(str)) {
                        sum++;
                    }
                }
                if (sum == strs.length) {
                    longestCommonPrefix = str;
                }
            }*/

            for (int i = 1; i < strs.length; i++) {
                int j;
                for (j = 0; j < longestCommonPrefix.length() && j < strs[i].length(); j++) {
                    if (longestCommonPrefix.charAt(j) != strs[i].charAt(j))
                        break;
                }
                longestCommonPrefix = longestCommonPrefix.substring(0,j);
            }

            return longestCommonPrefix;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}