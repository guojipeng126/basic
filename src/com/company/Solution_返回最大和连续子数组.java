package com.company;

import java.util.Arrays;

/**
 * 包含正负数的数组，查找最大和的连续子数组
 */
public class Solution_返回最大和连续子数组 {

    public static void main(String[] args) {
        int[] array = { -1, 2, -3, 12, -5, -1, 9, -2 };
        maxsumofSubarray(array);
        System.out.println(maxsumofSubarray(array));
    }

    public static int maxsumofSubarray(int [] arr){
        int max = 0;
        int sum = 0;

        int begin = 0;
        int end = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum < 0){
                begin = i + 1;
            }
            if(sum > max){
                max = sum;
                end = i;
            }
        }

        return max;
    }
}
