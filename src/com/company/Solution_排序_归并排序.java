package com.company;

import java.util.Arrays;

/**
 * 归并排序
 */
public class Solution_排序_归并排序 {

    public static void main(String[] args) {
        int[] array = new int[] {8,2,9,3,7,4,5,1,0};
        int[] new_array = mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(new_array));
    }


    public static int[] mergeSort(int[] array, int left, int right){
        if(array.length <= 0){
            return null;
        }
        if(left == right){
            return new int[] {array[left]};
        }

        int mid = (left + right) / 2;
        int[] leftArray = mergeSort(array, left, mid);
        int[] rightArray = mergeSort(array, mid + 1, right);

        int[] mergeArray = new int[leftArray.length + rightArray.length];
        int i = 0, j = 0, m = 0;
        while(i < leftArray.length && j < rightArray.length){
            mergeArray[m++] = leftArray[i] < rightArray[j] ? leftArray[i++] : rightArray[j++];
        }

        while(i < leftArray.length){
            mergeArray[m++] = leftArray[i++];
        }
        while(j < rightArray.length){
            mergeArray[m++] = rightArray[j++];
        }

        return mergeArray;
    }
}
