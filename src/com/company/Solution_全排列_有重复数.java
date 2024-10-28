package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_全排列_有重复数 {

    public static void recursion(ArrayList<ArrayList<Integer>> res, int[] num, ArrayList<Integer> temp, Boolean[] vis){
        //临时数组满了加入输出
        if(temp.size() == num.length){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        //遍历所有元素选取一个加入
        for(int i = 0; i < num.length; i++){
            //如果该元素已经被加入了则不需要再加入了
            if(vis[i])
                continue;
            if(i > 0 && num[i - 1] == num[i] && vis[i - 1])
                //当前的元素num[i]与同一层的前一个元素num[i-1]相同且num[i-1]已经用过了
                continue;
            //标记为使用过
            vis[i] =  true;
            //加入数组
            temp.add(num[i]);
            System.out.println("00 >>>   " + "temp[]: " + temp.toString() + "   vis[] : " + Arrays.toString(vis));

            recursion(res, num, temp, vis);
            //回溯
            System.out.println("11 >>>   " + "temp[]: " + temp.toString() + "   vis[] : " + Arrays.toString(vis));
            vis[i] =  false;
            temp.remove(temp.size() - 1);
            System.out.println("22 >>>   " + "temp[] : " + temp.toString() + "   vis[] : " + Arrays.toString(vis));
            System.out.println("33 >>>");
        }
    }

    public static void main(String[] args) {
        int length = 3;
        int start = 0;
        int num[] = new int[length];
        for (int j = 0; j < length; j++)
            num[j] = j + 1;
        num[1] = 1;


        //先按字典序排序
        Arrays.sort(num);
        System.out.println(Arrays.toString(num).toString());


        Boolean[] vis = new Boolean[num.length];
        Arrays.fill(vis, false);
        ArrayList<ArrayList<Integer> > res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        recursion(res, num, temp, vis);

        System.out.println(res.toString());
    }
}
