package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Solution_两数之和 {

    /**
     * 该问题可以通过map的数据结构，减少时间开销为O(n)
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int[] index=new int[2];
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]+numbers[j] == target){
                    index[0]=i+1;
                    index[1]=j+1;
                    break;
                }
            }
        }
        return index;
    }
}
