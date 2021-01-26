package com.group.leetcode.binarysearch;

/**
 * @author: lisy
 * @version: _3_firstGreater , v0.1 2021年01月26日 14:53
 * @remark：_3_firstGreater
 */
public class _3_firstGreater {

    /**
     * 查找第一个大于等于目标值的元素
     * @param nums
     * @param target
     * @return
     */
    private int searchFirstGreaterElement(int[] nums, int target) {
        int low = 0 , high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                if (mid == 0 || nums[mid - 1] < target) { //找到第一个大于等于target的元素，要么下标是为0的，要么就是他的上一个元素不符合要求
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 4, 5, 6, 7, 7};
        int target = 3;
        _3_firstGreater firstGreater = new _3_firstGreater();
        int queryIndex = firstGreater.searchFirstGreaterElement(nums, target);
        System.out.println("index : " + queryIndex + " values " + nums[queryIndex]);
    }
}
