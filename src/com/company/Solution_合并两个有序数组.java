package com.company;

/**
 * 给出两个有序的整数数组 A和 B，请将数组 B合并到数组 A中，变成一个有序的数组
 * 注意：
 * 可以假设 A数组有足够的空间存放 B数组的元素， A和 B中初始的元素数目分别为 m和 n
 **/
public class Solution_合并两个有序数组 {

    public static void main(String[] args) {

        System.out.println("");
    }

    public void merge(int A[], int m, int B[], int n) {
        //index是数组A和B长度之和，因为题目规定A的长度一定能容纳B，所以直接相加作为合并后的坐标。
        int index = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            A[index--] = A[i] > B[j] ? A[i--] : B[j--];
        }
        while (j >= 0) {
            A[index--] = B[j--];
        }
    }
}
