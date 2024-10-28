package com.company;

/**
 * @Description
 * @Author guojipeng
 * @Version 1.0
 **/
public class Solution_矩阵路径最小和 {

    public int minPathSum (int[][] matrix) {
        int[][]  dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        for(int i =1; i< matrix.length; i++) {
            dp[i][0] =  dp[i-1][0] + matrix[i][0];
        }
        for(int i =1; i< matrix[0].length; i++) {
            dp[0][i] =  dp[0][i-1] + matrix[0][i];
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[matrix.length-1][matrix[0].length-1];
    }
}
