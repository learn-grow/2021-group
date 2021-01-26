package com.group.leetcode.answerkey;

import java.util.HashMap;

/**
 * @author: lisy
 * @version: _1_TwoSum , v0.1 2021年01月26日 15:59
 * @remark：_1_TwoSum
 * ---------------------------------------
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1]
 * ---------------------------------------
 */
public class _1_TwoSum {

    /**
     * 顺序扫描数组，对每一个元素，在 map 中找能组合给定值的另一半数字，
     * 如果找到了，直接返回 2 个 数字的下标即可。
     * 如果找不到，就把这个数字存入 map 中，等待扫到“另一半”数字的时候，再取出来返 回结果。
     */
    private int[] twoSum(int[] nums , int target) {
        if (null == nums) {
            return null;
        }
        HashMap<Integer ,Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < nums.length ; ++i){
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                return new int[]{map.get(temp) , i};
            }
            map.put(nums[i] , i);
        }
        return null;
    }

    public static void main(String[] args) {
        /**
         *  * Given nums = [2, 7, 11, 15], target = 9,
         *  * Because nums[0] + nums[1] = 2 + 7 = 9,
         */
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        _1_TwoSum twoSum = new _1_TwoSum();
        int[] ints = twoSum.twoSum(nums, target);
        if (null != ints) {
            for (int i : ints) {
                System.out.println(i);
            }
        }
    }
}
