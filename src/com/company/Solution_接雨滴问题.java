package com.company;

public class Solution_接雨滴问题 {

    public long maxWater (int[] arr) {
        // write code here
        //排除空数组
        if(arr.length == 0)
            return 0;
        long res = 0;
        //左右双指针
        int left = 0;
        int right = arr.length - 1;
        //中间区域的边界高度
        int maxL = 0;
        int maxR = 0;
        //直到左右指针相遇
        while(left < right){
            //每次维护往中间的最大边界
            maxL = Math.max(maxL, arr[left]);
            maxR = Math.max(maxR, arr[right]);
            //较短的边界确定该格子的水量
            if(maxR > maxL)
                res += maxL - arr[left++];
            else
                res += maxR - arr[right--];
        }
        return res;
    }


    public long maxWater222 (int[] height) {
        // write code here
        if(height == null || height.length <= 2){
            return 0;
        }

        int left = 0, right = height.length - 1, level = 0, sum = 0;

        while(left < right){
            if(height[left] < height[right]){
                level = height[left];
                while(height[left] <= level && left < right){
                    sum += level - height[left++];
                }

            }else{
                level = height[right];
                while(height[right] <= level && left < right){
                    sum += level - height[right];
                    right--;
                }
            }
        }
        return sum;
    }


}
