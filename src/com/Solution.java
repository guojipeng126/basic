package com;

import java.util.ArrayList;

public class Solution {

    /**
     * 求一个字符串数组的最长公共子串
     * @param stringList 字符串数组
     * @return 公共子序列
     */
    public String LongestCommonSub(ArrayList<String> stringList) {
        String res = "";
        if(stringList == null || stringList.size() <= 0){
            return res;
        }
        if(stringList.size() == 1){
            return stringList.get(0);
        }
        res = LongestCommonSubOfString(stringList.get(0), stringList.get(1));
        if(res != null && !res.equals("")){
            for(int i = 2; i < stringList.size(); i++){
                res = LongestCommonSubOfString(res, stringList.get(i));
                if(res == null || res.equals("")){      //中间不存在公共子串的直接返回
                    return res;
                }
            }
        }
        return res;
    }


    private String x = "";
    private String y = "";

    public String LongestCommonSubOfString(String s1, String s2) {
        //特殊情况
        if(s1.length() == 0 || s2.length() == 0)
            return null;
        int len1 = s1.length();
        int len2 = s2.length();
        x = s1;
        y = s2;
        //dp[i][j]表示第一个字符串到第i位，第二个字符串到第j位为止的最长公共子序列长度
        int[][] dp = new int[len1 + 1][len2 + 1];
        //动态规划数组相加的方向
        int[][] b = new int[len1 + 1][len2 + 1];
        //遍历两个字符串每个位置求的最长长度
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                //遇到两个字符相等
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    //考虑由二者都向前一位
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    //来自于左上方
                    b[i][j] = 1;
                }
                //遇到的两个字符不同
                else{
                    //左边的选择更大，即第一个字符串后退一位
                    if(dp[i - 1][j] > dp[i][j - 1]){
                        dp[i][j] = dp[i - 1][j];
                        //来自于左方
                        b[i][j] = 2;
                    }
                    //右边的选择更大，即第二个字符串后退一位
                    else{
                        dp[i][j] = dp[i][j - 1];
                        //来自于上方
                        b[i][j] = 3;
                    }
                }
            }
        }
        //获取答案字符串
        String res = ans(len1, len2, b);
        //检查答案是否位空
        if(res.isEmpty())
            return null;
        else
            return res;
    }

    //获取最长公共子序列
    String ans(int i, int j, int[][] b){
        String res = "";
        //递归终止条件
        if(i == 0 || j == 0)
            return res;
        //根据方向，往前递归，然后添加本级字符
        if(b[i][j] == 1){
            res += ans(i - 1, j - 1, b);
            res += x.charAt(i - 1);
        }
        else if(b[i][j] == 2)
            res += ans(i - 1, j, b);
        else if(b[i][j] == 3)
            res += ans(i,j - 1, b);
        return res;
    }
}
