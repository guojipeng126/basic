package com.company;

public class Solution_盛水最多的容器 {

    public int maxArea (int[] height) {
        // write code here
        //排除不能形成容器的情况
        if (height.length < 2)
            return 0;
        int res = 0;
        //双指针左右界
        int left = 0;
        int right = height.length - 1;
        //共同遍历完所有的数组
        while (left < right) {
            //计算区域水容量
            int capacity = Math.min(height[left], height[right]) * (right - left);
            //维护最大值
            res = Math.max(res, capacity);
            //优先舍弃较短的边
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return res;
    }
}
