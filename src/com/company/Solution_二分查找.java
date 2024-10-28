package com.company;

/**
 * @Description
 * @Author guojipeng
 * @Version 1.0
 **/
public class Solution_二分查找 {

    public static void main(String[] args) {
        int [] ss = {2,3,4,4,5};
    }

    public int search (int[] nums, int target) {
        int n = nums.length;
        if(n <= 0 || target < nums[0] || target > nums[n - 1]){
            return -1;
        }

        int left = 0;
        int right = n-1;
        int mid = (left + right ) / 2;
        while(left < right){
            if(nums[mid] >= target){
                right = mid;
            }else{
                left =mid+1;
            }
            mid = (left + right ) / 2;
        }

        if(nums[mid] == target){        //mid位置的数据不一定相等，需要判断一下。
            return mid;
        }
        return -1;
    }
}
