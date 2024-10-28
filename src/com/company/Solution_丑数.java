package com.company;


import java.util.Arrays;

/**
 * 只包含因子2、3、5的数成为丑数，求从小到大顺序的1500个丑数；
 * 例如 6、8是丑数，14不是，因为包含因子7；
 * 习惯上把1当做第一个丑数
 */
public class Solution_丑数 {

    public static void main(String... args) {
        int[] result = findUglyNum(12);
        System.out.println(Arrays.toString(result));
    }

    /**
     * @param index：丑数的个数
     * @return
     */
    public static int[] findUglyNum(int index) {
        int[] num = new int[index];
        int next = 1;
        num[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        while (next < index) {
            int num2 = num[index2] * 2;
            int num3 = num[index3] * 3;
            int num5 = num[index5] * 5;

            num[next] = findMinNum(num2, num3, num5);
            if (num2 <= num[next]) {
                index2++;
            }
            if (num3 <= num[next]) {
                index3++;
            }
            if (num5 <= num[next]) {
                index5++;
            }
            next++;

        }
//        System.out.println(num[index - 1]);
        return num;
    }

    public static int findMinNum(int num2, int num3, int num5) {
        int s = num2;
        if (num3 < s) {
            s = num3;
        }
        if (num5 < s) {
            s = num5;
        }
        return s;
    }
}
