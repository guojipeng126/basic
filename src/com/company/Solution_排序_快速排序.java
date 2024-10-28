package com.company;

import java.util.Arrays;

/**
 * 快速排序
 */
public class Solution_排序_快速排序 {

    public static void main(String[] args) {
        int [] arr = new int[]{1,3,7,122,5,9,4,4,6};  //数组的初始化 new int[]{};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int [] array, int left, int right){
        if(array.length <= 0 || left >= right){ //如果只有1个元素就不执行，2个及以上元素才会执行
            return;
        }

        int pivot = array[left];	//设置为基准值
        int low = left;		//左指针
        int high = right;		//右指针

        while(low < high){
            while(low < high && array[high] >= pivot){	//右指针指向的值大于等于基准值
                high--; 	//右指针左移，直到指向的值小于基准值
            }
            array[low] = array[high];	//将左指针指向的值和该值交换

            while(low < high && array[low] <= pivot){ 	//左指针指向的值小于等于基准值
                low++;	//左指针右移，直到指向的值大于基准值
            }
            array[high] = array[low];	//将该值与右指针指向的值交换

            array[low] = pivot;	//将基准值填入正确的位置，这样得到基准值左边的数据都小于它，右边同理
            System.out.println("pivot = " + pivot + "," + Arrays.toString(array));
            quickSort(array, low+1, right);
            quickSort(array, left, low - 1);
        }

//        quickSort(array, low+1, right);       // 放在外面做递归也是可以的
//        quickSort(array, left, low - 1);       // 放在外面做递归也是可以的
    }




}
