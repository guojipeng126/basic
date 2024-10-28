package com.company;

import java.util.Arrays;

/**
 * N皇后问题是指在 n * n 的棋盘上要摆 n 个皇后，
 * 要求：任何两个皇后不同行，不同列也不在同一条斜线上，
 * 求给一个整数 n ，返回 n 皇后的摆法数。
 */
public class Solution_N皇后 {

    private int res;
    //判断皇后是否符合条件
    public boolean isValid(int[] pos, int row, int col){
        //遍历所有已经记录的行
        for(int i = 0; i < row; i++){
            //不能同行同列同一斜线
            if(row == i || col == pos[i] || Math.abs(row - i) == Math.abs(col - pos[i]))
                return false;
        }
        return true;
    }

    //递归查找皇后种类
    public void recursion(int n, int row, int[] pos){
        //完成全部行都选择了位置
        if(row == n){
            res++;
            return;
        }
        //遍历所有列
        for(int i = 0; i < n; i++){
            //检查该位置是否符合条件
            if(isValid(pos, row, i)){
                //加入位置
                pos[row] = i;
                //递归继续查找
                recursion(n, row + 1, pos);
            }
        }
    }

    /**
     *
     * @param n int整型 the n
     * @return int整型
     */
    public int Nqueen (int n) {
        res = 0;
        //下标为行号，元素为列号，记录皇后位置
        int[] pos = new int[n];
        Arrays.fill(pos, 0);
        //递归
        recursion(n, 0, pos);
        return res;
    }

}
