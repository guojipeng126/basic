package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个数组，找出其中最小的K个数。
 * 例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 如果K>数组的长度，那么返回一个空的数组
 **/
public class Solution_最小的K个数 {

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> result = getLeastNumbers_Solution(input, 4);
        System.out.println(Arrays.toString(result.toArray()));
    }

    public static ArrayList<Integer> getLeastNumbers_Solution(int [] input, int k) {
        ArrayList result = new ArrayList();
        if(input == null || input.length <= 0 || k > input.length || k <= 0){
            return result;
        }

        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < k; i++){
            int min_tmp = -1;
            int index = 0;
            for(int n = 0; n < input.length; n++){
                if(map.get(n) != null){
                    continue;
                }
                if(min_tmp == -1){
                    min_tmp = input[n];
                }
                if(min_tmp >= input[n]){
                    int tmp = input[n];
                    input[n] = min_tmp;
                    min_tmp = tmp;
                    index = n;
                }
            }
            map.put(index, min_tmp);
            result.add(min_tmp);
        }
        return result;
    }



}
