import java.util.ArrayList;
import java.util.List;

/**
 *
 * 将字符串 "PAYPALISHIRING" 以Z字形排列成给定的行数：

 P   A   H   N
 A P L S I I G
 Y   I   R
 之后从左往右，逐行读取字符："PAHNAPLSIIGYIR"

 实现一个将字符串进行指定行数变换的函数:

 string convert(string s, int numRows);
 示例 1:

 输入: s = "PAYPALISHIRING", numRows = 3
 输出: "PAHNAPLSIIGYIR"
 示例 2:

 输入: s = "PAYPALISHIRING", numRows = 4
 输出: "PINALSIGYAHRPI"
 解释:

 P     I    N
 A   L S  I G
 Y A   H R
 P     I
 *
 *
 * 解析：
 *
 * 方法一：按行排序
 思路

 通过从左向右迭代字符串，我们可以轻松地确定字符位于 Z 字形图案中的哪一行。

 算法

 我们可以使用 \text{min}( \text{numRows}, \text{len}(s))min(numRows,len(s)) 个列表来表示 Z 字形图案中的非空行。

 从左到右迭代 ss，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。

 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
 *
 * 复杂度分析

 时间复杂度：O(n)O(n)，其中 n == \text{len}(s)n==len(s)
 空间复杂度：O(n)O(n)

 *
 */
//注意这里Z字变换Z要竖着
public class ZigConvert {
    public String convert(String s, int numRows) {

        if(numRows==1){
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for(int i=0;i<Math.min(s.length(),numRows);i++){
            rows.add(new StringBuilder());
        }

        boolean canDown = false;
        int currRow = 0;
        for(Character c:s.toCharArray()){
            rows.get(currRow).append(c);
            //因为currRow是从0开始的，所以最后一行要numRows-1
            if(currRow==0||currRow==(numRows-1)){
                canDown = !canDown;
            }
            currRow+=canDown?1:-1;
        }
        StringBuilder sb = new StringBuilder();
        for(StringBuilder ss:rows){
            sb.append(ss.toString());
        }
        return sb.toString();
    }
}
