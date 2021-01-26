# 二分查找

## 定义
   起始下标 low = 0
   终止位置 high = 数组长度 - 1
   中间位置 mid = (low + high) / 2;
   如果 nums[mid] 等于 目标值 ，返回
   如果 nums[mid] 大于 目标值 ，low + 1;
   如果 nums[mid] 小于 目标值 ，hight - 1;
   终止条件 while(low <= high) return;
