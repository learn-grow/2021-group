package com.group.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: lisy
 * @version: _1_TwoSum , v0.1 2021年01月26日 10:33
 * @remark：_1_TwoSum ### [1\. 两数之和](https://leetcode-cn.com/problems/two-sum/)
 * <p>
 * Difficulty: **简单**
 * <p>
 * <p>
 * 给定一个整数数组 `nums` 和一个整数目标值 `target`，请你在该数组中找出 **和为目标值** 的那 **两个** 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * **示例 1：**
 * <p>
 * ```
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * ```
 * <p>
 * **示例 2：**
 * <p>
 * ```
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * ```
 * <p>
 * **示例 3：**
 * <p>
 * ```
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * ```
 * <p>
 * **提示：**
 * <p>
 * *   `2 <= nums.length <= 10<sup>3</sup>`
 * *   `-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup>`
 * *   `-10<sup>9</sup> <= target <= 10<sup>9</sup>`
 * *   **只会存在一个有效答案**
 * <p>
 * <p>
 * #### Solution
 * <p>
 * Language: ****
 * <p>
 * ```
 * ​
 * ```
 */
public class _1_TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < nums.length ; ++i){
            int temp = target - nums[i];
            if (map.containsKey(temp)){
                return new int[]{map.get(temp) , i};
            }
            map.put(nums[i] , i);
        }
        return nums;
    }
}
