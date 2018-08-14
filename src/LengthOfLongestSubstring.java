import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *
 * 示例：
 *
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 *
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 *
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 *
 * 解析：
 *
 * 这道求最长无重复子串的题和之前那道 Isomorphic Strings 很类似，属于LeetCode的早期经典题目，博主认为是可以跟Two Sum媲美的一道题。给了我们一个字符串，让我们求最长的无重复字符的子串，注意这里是子串，不是子序列，所以必须是连续的。我们先不考虑代码怎么实现，如果给一个例子中的例子"abcabcbb"，让你手动找无重复字符的子串，该怎么找。博主会一个字符一个字符的遍历，比如a，b，c，然后又出现了一个a，那么此时就应该去掉第一次出现的a，然后继续往后，又出现了一个b，则应该去掉一次出现的b，以此类推，最终发现最长的长度为3。所以说，我们需要记录之前出现过的字符，记录的方式有很多，最常见的是统计字符出现的个数，但是这道题字符出现的位置很重要，所以我们可以使用HashMap来建立字符和其出现位置之间的映射。进一步考虑，由于字符会重复出现，到底是保存所有出现的位置呢，还是只记录一个位置？我们之前手动推导的方法实际上是维护了一个滑动窗口，窗口内的都是没有重复的字符，我们需要尽可能的扩大窗口的大小。由于窗口在不停向右滑动，所以我们只关心每个字符最后出现的位置，并建立映射。窗口的右边界就是当前遍历到的字符的位置，为了求出窗口的大小，我们需要一个变量left来指向滑动窗口的左边界，这样，如果当前遍历到的字符从未出现过，那么直接扩大右边界，如果之前出现过，那么就分两种情况，在或不在滑动窗口内，如果不在滑动窗口内，那么就没事，当前字符可以加进来，如果在的话，就需要先在滑动窗口内去掉这个已经出现过的字符了，去掉的方法并不需要将左边界left一位一位向右遍历查找，由于我们的HashMap已经保存了该重复字符最后出现的位置，所以直接移动left指针就可以了。我们维护一个结果res，每次用出现过的窗口大小来更新结果res，就可以得到最终结果啦。
 *
 * 这里我们可以建立一个256位大小的整型数组来代替HashMap，这样做的原因是ASCII表共能表示256个字符，所以可以记录所有字符，然后我们需要定义两个变量res和left，其中res用来记录最长无重复子串的长度，left指向该无重复子串左边的起始位置，然后我们遍历整个字符串，对于每一个遍历到的字符，如果哈希表中该字符串对应的值为0，说明没有遇到过该字符，则此时计算最长无重复子串，i - left +１，其中ｉ是最长无重复子串最右边的位置，left是最左边的位置，还有一种情况也需要计算最长无重复子串，就是当哈希表中的值小于left，这是由于此时出现过重复的字符，left的位置更新了，如果又遇到了新的字符，就要重新计算最长无重复子串。最后每次都要在哈希表中将当前字符对应的值赋值为i+1。
 *
 * 出处：
 *
 * http://www.cnblogs.com/grandyang/p/4480780.html
 *
 *
 * leetcode解析：
 *
 * 方法一：暴力法
 * 思路
 *
 * 逐个检查所有的子字符串，看它是否不含有重复的字符。
 *
 * 算法
 *
 * 假设我们有一个函数 boolean allUnique(String substring) ，如果子字符串中的字符都是唯一的，它会返回true，否则会返回false。 我们可以遍历给定字符串 s 的所有可能的子字符串并调用函数 allUnique。 如果事实证明返回值为true，那么我们将会更新无重复字符子串的最大长度的答案。
 *
 * 现在让我们填补缺少的部分：
 *
 * 为了枚举给定字符串的所有子字符串，我们需要枚举它们开始和结束的索引。假设开始和结束的索引分别为 ii 和 jj。那么我们有 0 \leq i \lt j \leq n0≤i<j≤n （这里的结束索引 jj 是按惯例排除的）。因此，使用 ii 从0到 n - 1n−1 以及 jj 从 i+1i+1 到 nn 这两个嵌套的循环，我们可以枚举出 s 的所有子字符串。
 *
 * 要检查一个字符串是否有重复字符，我们可以使用集合。我们遍历字符串中的所有字符，并将它们逐个放入 set 中。在放置一个字符之前，我们检查该集合是否已经包含它。如果包含，我们会返回 false。循环结束后，我们返回 true。
 *
 *方法二：滑动窗口
 * 算法
 *
 * 暴力法非常简单。但它太慢了。那么我们该如何优化它呢？
 *
 * 在暴力法中，我们会反复检查一个子字符串是否含有有重复的字符，但这是没有必要的。如果从索引 ii 到 j - 1j−1 之间的子字符串 s_{ij}s
 * ​ij
 * ​​  已经被检查为没有重复字符。我们只需要检查 s[j]s[j] 对应的字符是否已经存在于子字符串 s_{ij}s
 * ​ij
 * ​​  中。
 *
 * 要检查一个字符是否已经在子字符串中，我们可以检查整个子字符串，这将产生一个复杂度为 O(n^2)O(n
 * ​2
 * ​​ ) 的算法，但我们可以做得更好。
 *
 * 通过使用 HashSet 作为滑动窗口，我们可以用 O(1)O(1) 的时间来完成对字符是否在当前的子字符串中的检查。
 *
 * 滑动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i, j)[i,j)（左闭，右开）。而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 [i, j)[i,j) 向右滑动 11 个元素，则它将变为 [i+1, j+1)[i+1,j+1)（左闭，右开）。
 *
 * 回到我们的问题，我们使用 HashSet 将字符存储在当前窗口 [i, j)[i,j)（最初 j = ij=i）中。 然后我们向右侧滑动索引 jj，如果它不在 HashSet 中，我们会继续滑动 jj。直到 s[j] 已经存在于 HashSet 中。此时，我们找到的没有重复字符的最长子字符串将会以索引 ii 开头。如果我们对所有的 ii 这样做，就可以得到答案。
 *
 */

public class LengthOfLongestSubstring {

    //暴力法
    public int lengthOfLongestSubstring2(String s) {

        int ans = 0;

        for(int i=0;i<s.length();i++){
            for(int j = i+1;j<s.length();j++){
                if(allUnique(s,i,j)){
                    return Math.max(ans,j-i);
                }
            }
        }
        return ans;
    }

    //暴力法判断函数
    public boolean allUnique(String s,int start,int end){
        HashSet<Character> hashSet = new HashSet();
        for(int i=start;i<end;i++){
            if(hashSet.contains(s.charAt(i))){
                return false;
            }else{
                hashSet.add(s.charAt(i));
            }
        }
        return true;
    }


    //leetcode窗口方式1
    public int lengthOfLongestSubstring3(String s) {
        int l = s.length();
        HashSet hashSet = new HashSet();
        int i = 0,j = 0,ans = 0;
        while(i<l&&j<l){
            if(!hashSet.contains(s.charAt(j))){
                hashSet.add(s.charAt(j++));
                ans = Math.max(ans,j-i);
            }else{
                //直到删除了存在的字符为止，如果不理解就自己写个例子
                hashSet.remove(s.charAt(i++));
            }
        }

        return ans;
    }

    //leetcode窗口方式2(优化)
    public int lengthOfLongestSubstring4(String s) {
        //通过hashmap
        int ans = 0;
        HashMap<Character,Integer> hashMap = new HashMap<>();
        for(int i=0,j=0;j<s.length();j++){
            if(hashMap.containsKey(s.charAt(j))){
                i = Math.max(i,hashMap.get(s.charAt(j)));
            }
            hashMap.put(s.charAt(j),j+1);
            ans = Math.max(ans,j - i + 1);
        }
        return ans;
    }

    //leetcode通过数组优化(替换Map)
    public int lengthOfLongestSubstring5(String s) {
        int ans = 0;
        int[] res = new int[256];
        for(int i=0,j=0;j<s.length();j++){
            i = Math.max(res[s.charAt(j)],i);
            ans = Math.max(ans,j-i+1);
            res[s.charAt(j)] = j+1;
        }
        return ans;
    }

}
