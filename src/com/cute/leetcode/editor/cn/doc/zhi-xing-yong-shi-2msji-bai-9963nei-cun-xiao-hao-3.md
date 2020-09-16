### 解题思路
此处撰写解题思路
首先题目为：求出数组中两数之和为目标数，那么经过转化，原题可以理解为 X + Y = target ，再一个，最明显不过的是肯定会使用遍历，那么遍历中的每一个元素可作为 X ，也就是我们要找的是 target - X 的值，是否存在其他元素中，第一直觉就想到了用哈希表来做，毕竟这个东西除去一些特殊情况，大部分情况下的时间复杂度为O(1)，一开始我使用了双层Map遍历，时间复杂度毕竟高，于是想着优化看看能不能靠一层遍历解决问题，很明显是可以的，在遍历时也进行运算即可。但要注意的是，不能是自己，因为题目要求了同一个元素不能使用两次。
### 代码

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int length = nums.length;
        Map<Integer, Integer> map = new HashMap();
        for (int i=0; i<length; i++) {
            int key = nums[i];
            int value = i;
            int temp = target - key;
            if (map.containsKey(temp)) {
                result[0] = value;
                result[1] = map.get(temp);
                return result;
            }
            map.put(key,value);
        }
        throw new RuntimeException("未找到匹配的数据");  
    }
}
```