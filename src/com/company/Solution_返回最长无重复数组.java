package com.company;

import java.util.HashMap;

/**
 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
 */
public class Solution_返回最长无重复数组 {

    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int max = 1;
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            // 如果该元素重复,调整起始位置
            if (hashMap.containsKey(arr[j])) {
                i = Math.max(hashMap.get(arr[j]) + 1, i);
                // 因为当前元素已经重复了，所以新的i要在当前元素上加1，也就是向后挪一位
                // 为了避免遇到的索引比当前i还小，所以要比较大小
                // 为什么？因为太小的索引不需要再去计算，之前的结果已经存过max中了
            }
            // 如果改元素没有重复
            hashMap.put(arr[j], j);
            max = Math.max(max, j - i + 1);
        }
        return max;
    }

}
