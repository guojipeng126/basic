package com.company;

/**
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示
 **/
public class Solution_二进制中1的个数 {

    /**
     * 最优解
     * 每次计算都是把最右的1计算并清除掉，
     * 这样就只剩下其他的1，并且没有新加1。
     * 所以和是不是负数没有关系，只要是二进制，都可以用这个解法。
     * @param n
     * @return
     */
    public int NumberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;
    }

    /**
     * 解法一
     * @param n
     * @return
     */
    public static int NumberOf1_CanNotUse(int n) {
        int count = 0;
        while(n!=0){
            //用1与每一位相与，相与后结果为1的则该数位是1
            count +=n&1;
            //>>>代表无符号右移，若用>>会导致负数陷入死循环。每次操作后将n右移1位。
            n = n>>>1;
        }
        return count;
    }

    /**
     * 解法二
     * @param n
     * @return
     */
    private static int NumberOf1_low(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            //如此不用考虑符号位。
            flag = flag << 1;
        }
        return count;
    }
}
