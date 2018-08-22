/**
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 说明：你不能倾斜容器，且 n 的值至少为 2。

 示例:

 输入: [1,8,6,2,5,4,8,3,7]
 输出: 49
 *
 *
 */

public class MaxArea {
    //暴力法

    /**
     *
     * 复杂度分析

     时间复杂度：O(n^2)O(n
     ​2
     ​​ )，计算所有 \frac{n(n-1)}{2}
     ​2
     ​
     ​n(n−1)
     ​​  种高度组合的面积。
     空间复杂度：O(1)O(1)，使用恒定的额外空间。
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                area = Math.max(area, Math.min(height[j], height[i]) * (j - i));
            }
        }
        return area;
    }

    //双指针法

    /**
     *
     * 复杂度分析

     时间复杂度：O(n)O(n)，一次扫描。

     空间复杂度：O(1)O(1)，使用恒定的空间。
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height){
        int area = 0;
        int left = 0;
        int right = height.length-1;
        while (left<right){
            area = Math.max(area,Math.min(height[left],height[right])*(right-left));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return area;
    }

}
