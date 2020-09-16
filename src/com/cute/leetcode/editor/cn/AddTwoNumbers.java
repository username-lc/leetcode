//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。 
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4842 👎 0

package com.cute.leetcode.editor.cn;

public class AddTwoNumbers {

    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //设置一个结果链表
            ListNode result = new ListNode(0);

            ListNode curr = result;

            //定义一个数字存储满10进1
            int temp = 0;
            while (l1 != null || l2 != null) {
                int l1Val = (l1 != null) ? l1.val : 0;
                int l2Val = (l2 != null) ? l2.val : 0;

                //l1的第一位和l2的第一位相加 ,再加上temp
                int i = l1Val + l2Val + temp;
                if (i > 9) {
                    //余数
                    int residue = i % 10;
                    curr.next = new ListNode(residue);
                    temp = 1;
                } else {
                    curr.next = new ListNode(i);
                    temp = 0;
                }

                curr = curr.next;
                if (l1 != null) l1 = l1.next;
                if (l2 != null) l2 = l2.next;
            }

            if (temp == 1) {
                curr.next = new ListNode(1);
            }
            return result.next;
        }


    }

//leetcode submit region end(Prohibit modification and deletion)

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}