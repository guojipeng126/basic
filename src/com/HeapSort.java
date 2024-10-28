package com;

import java.util.Arrays;

/**
 * 堆排序 不稳定
 * 时间复杂度：O(nlogn)
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {2,3,1,-1,0,-1,44,56,98,20,18,65};

        int len = arr.length;

        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(arr, i, len);
        }

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }

        System.out.println(Arrays.toString(arr));       // 小顶堆
    }

    private static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
