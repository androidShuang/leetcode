import java.util.HashMap;

/**
 *
 * 罗马数字包含以下七种字符：I， V， X， L，C，D 和 M。

 字符          数值
 I             1
 V             5
 X             10
 L             50
 C             100
 D             500
 M             1000
 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

 I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。

 示例 1:

 输入: "III"
 输出: 3
 示例 2:

 输入: "IV"
 输出: 4
 示例 3:

 输入: "IX"
 输出: 9
 示例 4:

 输入: "LVIII"
 输出: 58
 解释: C = 100, L = 50, XXX = 30, III = 3.
 示例 5:

 输入: "MCMXCIV"
 输出: 1994
 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 *
 * 有几条须注意掌握：
 1、基本数字Ⅰ、X 、C 中的任何一个，自身连用构成数目，或者放在大数的右边连用构成数目，都不能超过三个；放在大数的左边只能用一个。
 2、不能把基本数字V 、L 、D 中的任何一个作为小数放在大数的左边采用相减的方法构成数目；放在大数的右边采用相加的方式构成数目，只能使用一个。
 3、V 和X 左边的小数字只能用Ⅰ。
 4、L 和C 左边的小数字只能用X。
 5、D 和M 左边的小数字只能用C。

 而这道题好就好在没有让我们来验证输入字符串是不是罗马数字，这样省掉不少功夫。我们需要用到map数据结构，来将罗马数字的字母转化为对应的整数值，因为输入的一定是罗马数字，那么我们只要考虑两种情况即可：
 第一，如果当前数字是最后一个数字，或者之后的数字比它小的话，则加上当前数字
 第二，其他情况则减去这个数字
 *
 */

public class RomanToInt {
    public static int romanToInt(String s) {
        int res = 0;
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);

        for (int i = 0; i < s.length(); ++i) {
            int val = map.get(s.charAt(i)+"");
            if(i==s.length()-1||map.get(s.charAt(i+1)+"")<=map.get(s.charAt(i)+"")){
                res+=val;
            }else{
                res-=val;
            }
        }
        return res;
    }

    public static void main(String[] args){
         romanToInt("IV");
    }

}
