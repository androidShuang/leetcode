//leetcode twosum

import java.util.HashMap;

/**
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 *
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //思路使用hashmap
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hashMap.put(nums[i],i);
        }

        int[] result = new int[2];

        for(int i=0;i<nums.length;i++){
            int t = target-nums[i];
            if(hashMap.containsKey(t)&&hashMap.get(t)!=i){
                result[0] = i;
                result[1] = hashMap.get(t);
                break;
            }
        }
        return result;
    }
}
