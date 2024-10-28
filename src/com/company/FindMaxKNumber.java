package com.company;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定N个数的数字，找出最大的K个数
 */
public class FindMaxKNumber {

    public static void main(String[] args) {
        int [] arr = {23,19,5,6,90,89,0,783, 783};
        int [] new_k_arr = findMaxK(arr, 3);
        System.out.println(Arrays.toString(new_k_arr));
    }

    public static int[] findMaxK(int[] arr, int k){
        int [] new_k_arr = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < k; i++){
            int max = 0;
            int max_index = 0;
            for(int n = 0; n < arr.length; n++){
                if(arr[n] > max && map.get(n) == null){
                    max = arr[n];
                    max_index = n;
                }
            }
            map.put(max_index, max);
            new_k_arr[i] = max;
        }

        return new_k_arr;
    }

    public void ss(String jj){
        int[] new_k_arr = new int[90];
        Map<Integer, Integer> map = new HashMap<>();
    }


}
