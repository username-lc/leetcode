//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9044 👎 0

package com.cute.leetcode.editor.cn;

import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        Solution solution = new TwoSum().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            /**
             * 解题思路：  哈希表运算  时间复杂度 O(n) 我们只遍历了包含有 nn 个元素的列表一次。在表中进行的每次查找只花费 O(1)O(1) 的时间。
             * 循环遍历 通过target-one得出two
             * 由于数组中同一个元素不能使用两遍，所以可以先判断是否存在再存入map
             * 通过map的containsKey()方法，map中是否已存在该值，如果存在，得到对应的value，即第一个数的下标
             * 如果不存在该值，则存入map
             */
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int one = nums[i];
                int two = target - one;
                if (hashMap.containsKey(two)) {
                    return new int[]{hashMap.get(two), i};
                }
                hashMap.put(nums[i], i);
            }
            /*for (int i = 0; i < nums.length; i++) {
                int one = nums[i];
                int two = target - one;
                if (hashMap.containsKey(two) && hashMap.get(two) != i) {
                    Integer value = hashMap.get(two);
                    return new int[]{i, value};
                }
            }*/
            return null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}