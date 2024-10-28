package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 给定一个字符串，求最大回文串长度
 * moom 称为回文串，正序和反序一样
 */
public class Solution_回文子串 {

    public static void main(String[] args) {
        String tmp_s = "abc1234321ab";
        System.out.println(longestPalindrome_0(tmp_s).length());
        System.out.println(longestPalindrome_1(tmp_s));
        System.out.println(find_t(tmp_s));

        boolean nn[][] = new boolean[2][2];
        System.out.println(nn[1][1]);
    }

    public static String find_t(String s){
        if(s.length() < 2){
            return s;
        }

        int length = 1;
        String return_s = "";
        for(int i = 0; i < s.length(); i++){
            for(int n = i + 1; n <= s.length(); n++){
                String tmp_return_s = s.substring(i, n);
                if(is_huiwen(tmp_return_s, 0, tmp_return_s.length() - 1)){
                    if(tmp_return_s.length() > length){
                        length = tmp_return_s.length();
                        return_s = tmp_return_s;
                    }


                }
            }
        }
        return return_s;
    }

    public static boolean is_huiwen(String is_huiwen, int start, int end){
        if(is_huiwen.length() < 2 || start >= end){
            return true;
        }
        if(is_huiwen.charAt(start) == is_huiwen.charAt(end)){
            return is_huiwen(is_huiwen, ++start, --end);
        }else{
            return false;
        }
    }


    //1.动态规划
    public static String longestPalindrome_0(String s) {
        int n = s.length();
        if (n < 2) return s;

        int maxLen = 1;
        String res = s.substring(0, 1);
        boolean[][] dp = new boolean[n][n];
        //左边界一定小于右边界，因此从右边界开始
        for (int r = 1; r < n; r++) { //表示右边界
            for (int l = 0; l < r; l++) { //表示左边界
                // 区间应该慢慢放大
                // 状态转移方程：如果头尾字符相等并且中间也是回文
                // 在头尾字符相等的前提下，如果收缩以后不构成区间（最多只有 1 个元素），直接返回 True 即可
                // 否则要继续看收缩以后的区间的回文性
                if (s.charAt(l) == s.charAt(r) && ((r - l) <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        res = s.substring(l, r + 1);
                    }
                }
            }
        }
        return res;
    }

    //2.中心扩展法
    private static int start, maxLen;

    public static String longestPalindrome_1(String s) {
        if (s == null || s.length() < 2) return s;
        for (int i = 0; i < s.length(); i++) {
            //考虑中心扩散的两种情况1:aba  和 2: bb
            findMaxPalindrome(s, i, i);
            findMaxPalindrome(s, i, i + 1);
        }
        return s.substring(start, start + maxLen);
    }

    private static void findMaxPalindrome(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;//向左延伸
            j++;//向右延伸
        }
        //记录每个起始点扩展的回文串的最大长度
        if (maxLen < j - i - 1) {
            start = i + 1;
            maxLen = j - i - 1;
        }
    }
}
