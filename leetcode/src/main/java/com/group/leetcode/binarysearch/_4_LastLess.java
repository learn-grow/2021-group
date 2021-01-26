package com.group.leetcode.binarysearch;

/**
 * @author: lisy
 * @version: _4_LastLess , v0.1 2021年01月26日 15:38
 * @remark：_4_LastLess
 */
public class _4_LastLess {

    /**
     * 二分查找最后一个小于等于target的元素
     * @param nums
     * @param target
     * @return
     */
    private int searchaLastLesElement(int[] nums , int target) {
        int low = 0 , high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                if (mid == nums.length - 1 || nums[mid + 1] > target) { //找到最后一个小于等于target的元素，如果他是最后一个元素或者他的下一个元素比目标值大
                    return  mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 4, 5, 6, 7, 7};
        int target = 3;
        _4_LastLess lastLess = new _4_LastLess();
        int queryIndex = lastLess.searchaLastLesElement(nums, target);
        System.out.println("index : " + queryIndex + " values " + nums[queryIndex]);
    }
}
