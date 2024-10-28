package com.company;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * 也叫兔子数列
 */
public class Solution_斐波那契数列 {
    public int Fibonacci(int n) {
        if(n <= 1){
            return n;
        }
        n = Fibonacci(n - 1) + Fibonacci(n - 2);
        return n;
    }
}
