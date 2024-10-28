package com;

import java.util.Arrays;

public class FindM {

    public static void main(String[] args) {

        System.out.println(solution(34231));
    }

    public static int solution(int n){
        if(n <= 11){
            return -1;
        }
        String tmp = String.valueOf(n);
        for(int i = tmp.length() - 1; i > 0; i--){
            for(int j = i - 1; j > 0; j--){
                if(tmp.charAt(i) > tmp.charAt(j)){
                    char c1 = tmp.charAt(i);
                    char c2 = tmp.charAt(j);
                    tmp = tmp.substring(0, j) + c1 + tmp.substring(j + 1, i) + c2 + tmp.substring(i + 1);
                    tmp = tmp.substring(0, j + 1) + sortString(tmp.substring(j + 1));
                    return Integer.parseInt(tmp);
                }
            }
        }

        return -1;
    }

    public static String sortString(String param){
        if(param == null || param.length() <= 1){
            return param;
        }

        int []arr = new int[param.length()];
        for(int i = 0; i < param.length(); i++){
            arr[i] = param.charAt(i) - '0';
        }

        for(int i = 0; i < param.length() - 1; i++){
            for(int j = 0; j < param.length() - 1; j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j +1] = tmp;
                }
            }
        }
        String result = "";
        for(int i = 0; i < arr.length; i++){
            result = result + arr[i];
        }
        return result;
    }
}
