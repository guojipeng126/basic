package com.company;

/**
 * 输入：  “1AB2345CD","12345EF"
 * 输出：  "2345"
 */
public class Solution_最长公共子序列2 {

    public String LCS (String str1, String str2) {
        //dp[i][j]表示到str1第i个个到str2第j个为止的公共子串长度
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        int max = 0;
        int pos = 0;
        for(int i = 1; i <= str1.length(); i++){
            for(int j = 1; j <= str2.length(); j++){
                //如果该两位相同
                if(str1.charAt(i - 1) == str2.charAt(j - 1))
                    //则增加长度
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    //该位置为0
                    dp[i][j] = 0;

                //更新最大长度
                if(dp[i][j] > max){
                    max = dp[i][j];
                    pos = i - 1;
                }
            }
        }
        return str1.substring(pos - max + 1, pos + 1);
    }
}
