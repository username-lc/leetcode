//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1858 👎 0

package com.cute.leetcode.editor.cn;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("([}{})"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {


            /**
             * s.push(item)      将数据item放在栈的顶部
             * s.pop()             返回栈顶部数据，并从栈中移除该数据
             * s.peek()           返回栈顶部数据，但不移除
             * s.size()            返回栈的大小
             * s.isEmpty()       返回栈是否为空
             */

            if (s.length() % 2 != 0) return false;
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (c == '(') stack.push(')');
                else if (c == '[') stack.push(']');
                else if (c == '{') stack.push('}');
                else if (stack.isEmpty() || c != stack.pop()) return false;
            }
            return stack.empty();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}