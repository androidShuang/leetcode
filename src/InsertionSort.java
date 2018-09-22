/**
 *
 *　对于未排序数据(右手抓到的牌)，在已排序序列(左手已经排好序的手牌)中从后向前扫描，找到相应位置并插入。

 　　插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。

 　　具体算法描述如下：

 从第一个元素开始，该元素可以认为已经被排序
 取出下一个元素，在已经排序的元素序列中从后向前扫描
 如果该元素（已排序）大于新元素，将该元素移到下一位置
 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 将新元素插入到该位置后
 重复步骤2~5
 *
 *
 */
// 分类 ------------- 内部比较排序
// 数据结构 ---------- 数组
// 最差时间复杂度 ---- 最坏情况为输入序列是降序排列的,此时时间复杂度O(n^2)
// 最优时间复杂度 ---- 最好情况为输入序列是升序排列的,此时时间复杂度O(n)
// 平均时间复杂度 ---- O(n^2)
// 所需辅助空间 ------ O(1)
// 稳定性 ------------ 稳定
public class InsertionSort {

    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int now = arr[i];
            int sort = i-1;
            while(sort>=0&&arr[sort]>now){
                arr[sort+1] = arr[sort];
                sort--;
            }
            arr[sort+1] = now;
        }
    }

    public static void main(String[] args){
        int A[] = { 8, 5, 2, 6, 9, 3, 1, 4, 0, 7 }; // 从小到大选择排序
        insertionSort(A);
        System.out.println("选择排序结果：");
        for (int i = 0; i < A.length; i++)
        {
            System.out.println(A[i]);
        }
    }

}
