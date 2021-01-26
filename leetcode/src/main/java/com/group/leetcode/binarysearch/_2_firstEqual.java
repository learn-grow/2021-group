package com.group.leetcode.binarysearch;

/**
 * @author: lisy
 * @version: _2_firstEqual , v0.1 2021年01月26日 14:47
 * @remark：_2_firstEqual
 */
public class _2_firstEqual {

    /**
     * 查找第一个与目标值相等的元素
     * @param nums
     * @param target
     * @return
     */
    private int searchFirstEqualElement(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] != target) { //找到第一个与target相等的元素，要么mid是在0，要么他的上一个元素跟目标值不相等才能证明他是第一个出现的
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 4, 5, 6, 7, 7};
        int target = 1;
        _2_firstEqual firstEqual = new _2_firstEqual();
        int queryIndex = firstEqual.searchFirstEqualElement(nums, target);
        System.out.println("index : " + queryIndex + " values " + nums[queryIndex]);
    }
}
