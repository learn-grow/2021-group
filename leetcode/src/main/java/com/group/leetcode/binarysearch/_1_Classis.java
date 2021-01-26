package com.group.leetcode.binarysearch;

/**
 * @author: lisy
 * @version: _1_Classis , v0.1 2021年01月26日 14:36
 * @remark：_1_Classis
 */
public class _1_Classis {

    /**
     * 二分查找法 经典
     * @param nums
     * @param target
     */
    private int binarySearchMatrix(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 5, 6, 7};
        int target = 7;
        _1_Classis classis = new _1_Classis();
        int queryIndex = classis.binarySearchMatrix(nums, target);
        System.out.println("index : " + queryIndex + " values " + nums[queryIndex]);
    }
}
