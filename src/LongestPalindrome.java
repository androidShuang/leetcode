import java.util.HashMap;

/**
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 *
 *
 *
 *示例 1：

 输入: "babad"
 输出: "bab"
 注意: "aba"也是一个有效答案。
 示例 2：

 输入: "cbbd"
 输出: "bb"
 *
 *
 * 解析：
 * 方法四：中心扩展算法
 事实上，只需使用恒定的空间，我们就可以在 O(n^2)O(n
 ​2
 ​​ ) 的时间内解决这个问题。

 我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n - 12n−1 个这样的中心。

 你可能会问，为什么会是 2n - 12n−1 个，而不是 nn 个中心？原因在于所含字母数为偶数的回文的中心可以处于两字母之间（例如 \textrm{“abba”}“abba” 的中心在两个 \textrm{‘b’}‘b’ 之间）
 *
 *
 */
public class LongestPalindrome {
    //什么叫回文，就是正着读和反着读都一样
    public static String longestPalindrome(String s) {
        if("".equals(s)){
            return "";
        }

        int start=0,end = 0;
        for(int i=0;i<s.length();i++){
            int len1 = expandAroundCenter(s,i,i);   //这里分字符串的长度为奇数和偶数的情况因为传入left和right不同，偶数存在中间两个相等的情况
            int len2 = expandAroundCenter(s,i,i+1);//如果不明白可以手写简单的回文看看
            int len = Math.max(len1,len2);
            if(len>end-start){
                start = i-(len-1)/2;    //这里主要是为了找到start的索引，知道了最长回文的长度，和i,计算i左侧的start和i右侧的end
                end = i+len/2;  //因为存在偶数的问题，所以len-1了，我是这样理解的。
            }
        }
        return s.substring(start,end+1);//这里注意substring是不包含结束位的，所以要+1
    }

    public static int expandAroundCenter(String s,int left,int right){
        int l = left;
        int r = right;
        while(l>=0&&r<s.length()&&s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }

}
