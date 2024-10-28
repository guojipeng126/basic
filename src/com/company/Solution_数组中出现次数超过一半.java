package com.company;

/**
 * @Description
 * @Author guojipeng
 * @Version 1.0
 **/
public class Solution_数组中出现次数超过一半 {
    public static void main(String... args) {
        int[] num = {1, 2, 2, 2, 2, 2, 2, 4, 2, 4, 6, 4, 2, 6, 8, 2, 7, 7};
        System.out.println(moreThanHaft(num));
    }

    //也可以将出现的次数存在map中，最后判断一次
    public static int moreThanHaft(int[] array) {
        if (array.length <= 0) {
            return 0;
        }

        int result = -1;
        int times = 0;
        for (int value : array) {
            if (times == 0) {
                result = value;
                times++;
            } else {
                if (result == value) {
                    times++;
                } else {
                    times--;
                }
            }
        }

        times = 0;
        for (int value : array) {
            if (value == result) {
                times++;
            }
        }
        if (times > array.length / 2) {
            return result;
        }

        return 0;
    }
}
