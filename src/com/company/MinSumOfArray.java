package com.company;

/**
 * 计算数组的小和, 每一位数字左边的小于它自己的数字和，然后将所有的和相加
 */
public class MinSumOfArray {

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 2, 4, 6};
//        minSum(arr, 0);
//        System.out.println(sum_result);

        method2(arr);
    }

    public static void method2(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            for(int n = 0; n < i; n++){
                if(arr[n] < arr[i]){
                    sum += arr[n];
                }
            }
        }
        System.out.println(sum);
    }


    static int sum_result;
    public static void minSum(int[] arr, int index){
        for(int i = 0; i < index; i++){
            if(arr[i] < arr[index]){
                sum_result += arr[i];
            }
        }
        if(index < (arr.length - 1)){
            minSum(arr, ++index);
        }
    }


}
