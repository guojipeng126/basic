package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_全排列 {

    public static void permulation(int[] list, int start, int length) {
        if (start == length) {
            for (int i = 0; i < length; i++)
                System.out.print(list[i] + " ");
            System.out.println();
        } else {
            for (int i = start; i < length; i++) {
                swap(list, start, i);
                permulation(list, start + 1, length);
                swap(list, start, i);        //数组重置
            }
        }
    }

    public static void swap(int[] list, int start, int i) {
        int temp;
        temp = list[start];
        list[start] = list[i];
        list[i] = temp;
    }

    public static void main(String[] args) {
        int length = 3;
        int list[] = new int[length];
        for (int j = 0; j < length; j++)
            list[j] = j + 1;
        permulation(list, 0, list.length);
    }
}
