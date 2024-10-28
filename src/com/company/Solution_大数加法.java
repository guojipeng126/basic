package com.company;

import java.math.BigInteger;

/**
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
 * 输入  "1","99"
 * 返回  "100"
 */
public class Solution_大数加法 {

    public static void main(String[] args) {
        char[] new_char = new char[]{'3'};
        System.out.println(String.valueOf(new_char));
    }

    public String solve_0(String s, String t) {
        BigInteger bigInteger1 = new BigInteger(s);
        BigInteger bigInteger2 = new BigInteger(t);
        return bigInteger1.add(bigInteger2).toString();
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     *
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve_1(String s, String t) {
        if (s == null) {
            return t;
        }

        if (t == null) {
            return s;
        }

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        //因为涉及到最后2位相加的进位问题 所以可能多出1位长度
        char[] result = new char[Math.max(a.length, b.length) + 1];
        int resultLen = result.length - 1;
        int aIndex = a.length - 1;
        int bIndex = b.length - 1;

        int jinwei = 0;
        while (aIndex >= 0 && bIndex >= 0) {
            //字符0-9减法对应ascii,用其ascii对应的十进制,减法后,得到的结果为int类型
            //如字符'1'对应49  '2'对应50 '2' - '1' = 1
            int A = a[aIndex--] - '0';//相当于'1' - '0' = 49 - 48 = 1
            int B = b[bIndex--] - '0';//相当于'2' - '0' = 50 - 48 = 2

            //转换为字符存储在char[]中
            result[resultLen--] = (char) ((A + B + jinwei) % 10 + '0');
            jinwei = (A + B + jinwei) / 10;
        }

        while (aIndex >= 0) {
            int A = a[aIndex--] - '0';
            result[resultLen--] = (char) ((A + jinwei) % 10 + '0');
            jinwei = (A + jinwei) / 10;
        }

        while (bIndex >= 0) {
            int B = b[bIndex--] - '0';
            result[resultLen--] = (char) ((B + jinwei) % 10 + '0');
            jinwei = (B + jinwei) / 10;
        }

        if (jinwei != 0) {
            result[resultLen] = (char) (jinwei + '0');
            //此时char[]数组 填满,直接返回
            return String.valueOf(result);
        }

        //最后的2个数相加 没有涉及进位 所以截取char[]数组的第一位到末位返回
        return String.valueOf(result).substring(1);
    }
}
