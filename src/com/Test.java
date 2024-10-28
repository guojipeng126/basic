package com;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,7,3,5,2,9,0};

        for(int i = 0; i < arr.length; i++){
           for(int j = i; j < arr.length; j++){
               if(arr[i] < arr[j]){
                   int tmp = arr[i];
                   arr[i] = arr[j];
                   arr[j] = tmp;
               }
           }
        }

        System.out.println(Arrays.toString(arr));
    }

}
