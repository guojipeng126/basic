package com.company;


import java.util.HashMap;
import java.util.concurrent.locks.Lock;

/**
 * 计算数组的小和, 每一位数字左边的小于它自己的数字和，然后将所有的和相加
 */
public class SmallSum {

    public static void main(String[] args) {
        int [] arr = new int[] {1,3,5,2,4,6};
        int smallSum = sort(arr, 0 , arr.length-1);

        System.out.println("这个是新的");
        System.out.println(smallSum);
    }

    public static int sort(int[] arr , int L , int R) {
        if(L == R) {
            return  0;
        }
        int mid = L+((R-L)>>1);
        return  sort(arr,L,mid)+sort(arr,mid+1,R)+merge(arr,L,mid,R);
    }

    private static int  merge(int [] arr, int L, int mid, int R) {
        int [] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = mid+1;
        int res = 0;
        while(p1<=mid && p2<= R) {
            res += arr[p1] <= arr[p2]  ? arr[p1] * (R-p2+1):0;
            help[i++] =  arr[p1] <= arr[p2]  ? arr[p1++]:arr[p2++];
        }
        while(p1<=mid) {
            help[i++] = arr[p1++];
        }
        while(p2<=R) {
            help[i++] = arr[p2++];
        }
        for(i= 0 ; i<help.length; i++ ) {
            arr[L+i] = help[i];
        }
        return res;
    }

}