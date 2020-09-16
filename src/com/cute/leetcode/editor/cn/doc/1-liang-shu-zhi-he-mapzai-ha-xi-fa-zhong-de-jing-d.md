## 思路 

很明显暴力的解法是两层for循环查找，时间复杂度是O(n^2)。

使用哈希法最为合适，之前已经介绍过，数组和set在哈希法中的应用，那么来看一下使用数组和set来做哈希法的局限。

* 数组的大小是受限制的，而且如果元素很少，而哈希值太大会造成内存空间的浪费。
* set是一个集合，里面放的元素只能是一个key，而两数之和这道题目，不仅要判断y是否存在而且还要记录y的下表位置，因为要返回x 和 y的下表。所以set 也不能用。

此时就要选择另一种数据结构：map ，map是一种key value的存储结构，可以用key保存数值，用value在保存数值所在的下表。

C++中map，有三种类型：

|映射 |底层实现 | 是否有序 |数值是否可以重复 | 能否更改数值|查询效率 |增删效率|
|---|---| --- |---| --- | --- | ---|
|std::map |红黑树 |key有序 |key不可重复 |key不可修改 | O(logn)|O(logn) |
|std::multimap | 红黑树|key有序 | key可重复 | key不可修改|O(logn) |O(logn) |
|std::unordered_map |哈希表 | key无序 |key不可重复 |key不可修改 |O(1) | O(1)|

std::unordered_map 底层实现为哈希表，std::map 和std::multimap 的底层实现是红黑树。

同理，std::map 和std::multimap 的key也是有序的（这个问题也经常作为面试题，考察对语言容器底层的理解）。  更多哈希表的理论知识请看[关于哈希表，你该了解这些！](https://mp.weixin.qq.com/s/g8N6WmoQmsCUw3_BaWxHZA)。

**这道题目中并不需要key有序，选择std::unordered_map 效率更高！**



## C++代码
```
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::unordered_map <int,int> map;
        for(int i = 0; i < nums.size(); i++) {
            auto iter = map.find(target - nums[i]);
            if(iter != map.end()) {
                return {iter->second, i};
            }
            map.emplace(nums[i], i);
        }
        return {};
    }
};
```

**我是程序员Carl，先后在腾讯和百度从事技术研发多年，利用工作之余重刷leetcode，更多精彩文章尽在公众号：[代码随想录](https://img-blog.csdnimg.cn/20200815195519696.png)，关注后，回复「Java」「C++」「python」「简历模板」等等，有我整理多年的学习资料，可以加我[微信](https://img-blog.csdnimg.cn/20200814140330894.png)，备注「组队刷题」，拉你进入刷题群，每天一道经典题目分析，我选的每一道题目都不是孤立的，而是由浅入深一脉相承的，如果跟住节奏每篇连续着看，定会融会贯通。本文  [https://github.com/youngyangyang04/leetcode-master](https://github.com/youngyangyang04/leetcode-master ) 已经收录，里面还有leetcode刷题攻略、各个类型经典题目刷题顺序、思维导图，看一看一定会有所收获！**

**以下资料希望对你有帮助：**
* [如何学习C++B站视频](https://www.bilibili.com/video/BV1rK4y1e7ed)
* [手把手带你读C++primer B站视频](https://www.bilibili.com/video/BV1Z5411874t)
* [C++面试&C++学习指南知识点整理](https://github.com/youngyangyang04/TechCPP)
* [程序员应该如何写简历（附简历模板）](https://mp.weixin.qq.com/s/PkBpde0PV65dJjj9zZJYtg)
* [leetcode刷题攻略](https://github.com/youngyangyang04/leetcode-master)

**哈希表经典题目**
* [关于哈希表，你该了解这些！](https://mp.weixin.qq.com/s/g8N6WmoQmsCUw3_BaWxHZA)
* [哈希表：可以拿数组当哈希表来用，但哈希值不要太大](https://mp.weixin.qq.com/s/vM6OszkM6L1Mx2Ralm9Dig)
* [哈希表：哈希值太大了，还是得用set](https://mp.weixin.qq.com/s/N9iqAchXreSVW7zXUS4BVA)
* [哈希表：今天你快乐了么？](https://mp.weixin.qq.com/s/G4Q2Zfpfe706gLK7HpZHpA)
* [哈希表：map等候多时了](https://mp.weixin.qq.com/s/uVAtjOHSeqymV8FeQbliJQ)
* [哈希表：其实需要哈希的地方都能找到map的身影](https://mp.weixin.qq.com/s/Ue8pKKU5hw_m-jPgwlHcbA)
* [哈希表：这道题目我做过？](https://mp.weixin.qq.com/s/sYZIR4dFBrw_lr3eJJnteQ)
* [哈希表：解决了两数之和，那么能解决三数之和么？](https://mp.weixin.qq.com/s/r5cgZFu0tv4grBAexdcd8A)
* [双指针法：一样的道理，能解决四数之和](https://mp.weixin.qq.com/s/nQrcco8AZJV1pAOVjeIU_g)

**如果感觉题解对你有帮助，不要吝啬给一个👍吧！**
