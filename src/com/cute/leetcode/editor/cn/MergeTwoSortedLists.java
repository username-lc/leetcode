//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1269 👎 0

package com.cute.leetcode.editor.cn;


public class MergeTwoSortedLists {

    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode l1 = new ListNode(1);
        /*l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);*/

        ListNode l2 = null;
        /*l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);*/
        System.out.println(solution.mergeTwoLists(l1, l2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            //设置一个结果链表
            ListNode result = new ListNode(0);

            ListNode curr = result;
            while (l1 != null || l2 != null) {
                if (l1 == null) {
                    curr.next = l2;
                    break;
                }
                if (l2 == null) {
                    curr.next = l1;
                    break;
                }
                int val1 = (l1 != null) ? l1.val : 0;
                int val2 = (l2 != null) ? l2.val : 0;
                if (l1 != null && val1 <= val2) {
                    curr.next = new ListNode(val1);
                    l1 = l1.next;
                } else {
                    curr.next = new ListNode(val2);
                    l2 = l2.next;
                }

                curr = curr.next;
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