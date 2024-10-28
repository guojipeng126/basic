package com.company;

import java.util.Arrays;

/**
 * 将两个数组合并，去掉重复的数字
 */
public class MergeArray {

    public static void main(String[] args) {
        System.out.println("hello word");
        int [] array1 = {1,2,3,5,7,8,9,12,14,15,18};
        int [] array2 = {4,5,6,10,11,13,15,17};
        int[] array3 = new int[array1.length + array2.length];

        int m = 0, n = 0;
        for(int i = 0; i < array3.length; i++){
            if(m >= array1.length){
                if(n >= array2.length){
                    System.out.println("数组中的重复元素个数为： " + (array3.length - i));
                    break;
                }else{
                    array3[i] = array2[n];
                    n++;
                    continue;
                }
            }else{
                if(n >= array2.length){
                    array3[i] = array1[m];
                    m++;
                    continue;
                }else{
                    if(array1[m] < array2[n]){
                        array3[i] = array1[m];
                        m++;
                    }else if(array1[m] > array2[n]){
                        array3[i] = array2[n];
                        n++;
                    }else{
                        array3[i] = array1[m];
                        m++;
                        n++;
                    }
                }
            }
        }

        System.out.println("新的数组为： " + Arrays.toString(array3));
        System.out.println("hello word");
    }
}
