package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_分割回文数 {

    public static void main(String[] args) {
        String s = "aab";
        partition(s);
        System.out.println(ret.toString());
    }


    static boolean[][] f;
    static List<List<String>> ret = new ArrayList<List<String>>();
    static List<String> ans = new ArrayList<String>();
    static int n;

    public static List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }
        System.out.println(s);
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        for(boolean[] b :  f){
            System.out.println(Arrays.toString(b));
        }


        dfs(s, 0);
        return ret;
    }

    public static void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                System.out.println("i:" + i + " j:" + j);
                ans.add(s.substring(i, j + 1));

                dfs(s, j + 1);
                System.out.println(ans.toString());
                ans.remove(ans.size() - 1);
            }
        }
    }
}
