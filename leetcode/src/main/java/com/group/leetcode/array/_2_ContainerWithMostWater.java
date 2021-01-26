package com.group.leetcode.array;

/**
 * @author: lisy
 * @version: _2 , v0.1 2021年01月26日 10:55
 * @remark：_2 ### [11\. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)
 * <p>
 * Difficulty: **中等**
 * <p>
 * <p>
 * 给你 `n` 个非负整数 `a<sub style="display: inline;">1</sub>，a<sub style="display: inline;">2，</sub>...，a`<sub style="display: inline;">`n`，</sub>每个数代表坐标中的一个点 `(i, a<sub style="display: inline;">i</sub>)` 。在坐标内画 `n` 条垂直线，垂直线 `i` 的两个端点分别为 `(i, a<sub style="display: inline;">i</sub>)` 和 `(i, 0)` 。找出其中的两条线，使得它们与 `x` 轴共同构成的容器可以容纳最多的水。
 * <p>
 * **说明：**你不能倾斜容器。
 * <p>
 * **示例 1：**
 * <p>
 * ![](https://aliyun-lc-upload.oss-cn-hangzhou.aliyuncs.com/aliyun-lc-upload/uploads/2018/07/25/question_11.jpg)
 * <p>
 * ```
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * ```
 * <p>
 * **示例 2：**
 * <p>
 * ```
 * 输入：height = [1,1]
 * 输出：1
 * ```
 * <p>
 * **示例 3：**
 * <p>
 * ```
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * ```
 * <p>
 * **示例 4：**
 * <p>
 * ```
 * 输入：height = [1,2,1]
 * 输出：2
 * ```
 * <p>
 * **提示：**
 * <p>
 * *   `n = height.length`
 * *   `2 <= n <= 3 * 10<sup>4</sup>`
 * *   `0 <= height[i] <= 3 * 10<sup>4</sup>`
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
public class _2_ContainerWithMostWater {

    public int maxArea(int[] height) {
        int sum = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int h = height[l] < height[r] ? height[l] : height[r];
            sum = Math.max(sum , h * (r - l));
            if (height[l] < height[r]){
                ++l;
            } else {
                --r;
            }
        }
        return sum;
    }
}
