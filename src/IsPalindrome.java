/***
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

 示例 1:

 输入: 121
 输出: true
 示例 2:

 输入: -121
 输出: false
 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 示例 3:

 输入: 10
 输出: false
 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 进阶:

 你能不将整数转为字符串来解决这个问题吗？
 *
 */

public class IsPalindrome {
    //转换为字符串相对简单
    public boolean isPalindrome1(int x) {
        String str = x+"";
        int left = 0;
        int right = str.length()-1;
        if(str.isEmpty()){
            return false;
        }
        if(str.length()==1){
            return true;
        }
        while(left<=right){
            if(str.charAt(left)!=str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    public boolean isPalindrome2(int x) {
        if(x<0){
            return false;
        }

        int div = 1;
        while(x/div>=10){
            div*=10;
        }

        while(x>0){
            int left = x/div;
            int right = x%10;
            if(left!=right){
                return false;
            }
            x = (x%div)/10;
            div/=100;
        }

        return true;
    }

}
