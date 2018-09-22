/**
 *
 * 冒泡排序
 *
 * 基本思想：两个数比较大小，较大的数下沉，较小的数冒起来。
 *过程：
 比较相邻的两个数据，如果第二个数小，就交换位置。
 从后向前两两比较，一直到比较最前两个数据。最终最小数被交换到起始的位置，这样第一个最小数的位置就排好了。
 继续重复上述过程，依次将第2.3...n-1个最小数排好位置。
 *
 */

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
    }

    //冒泡排序提升版，鸡尾酒排序
    public static void cocktailSort(int[] arr){
        int left = 0;
        int right = arr.length-1;
        while (left<right){
            for (int i = 0; i < right; i++) {
                if(arr[i]>arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
            right--;
            for (int i = right; i >left ; i--) {
                if(arr[i-1]>arr[i]){
                    swap(arr,i-1,i);
                }
            }
            left++;
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args){
        int A[] = { 6, 5, 3, 1, 8, 7, 2, 4 };    // 从小到大冒泡排序
//        bubbleSort(A);
        cocktailSort(A);
        System.out.println("冒泡排序结果：");
        for (int i = 0; i < A.length; i++)
        {
            System.out.println(A[i]);
        }
    }

}
