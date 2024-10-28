package com.company;


/**
 * 给出一个排序好的数组和一个数，求数组中连续元素的和等于所给数的子数组
 */
public class FindSubArray {

    public static void main(String ... ars) {
        int[] num = {1, 2, 2, 3, 4, 5, 6, 7, 8, 9};
        int sum = 7;
        findSubArr(num, sum);
    }

    public static void findSubArr(int[] num, int sum) {
        int right = 0;

        for (int i = 0; i < num.length; i++) {
            int curSum = 0;
            right = i;
            while (curSum < sum) {
                curSum += num[right++];
            }
            if (curSum == sum) {
                for (int j = i; j < right; j++) {
                    System.out.print(num[j] + " ");
                }
                System.out.println();
            }
        }
    }
}
