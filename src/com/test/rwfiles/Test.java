package com.test.rwfiles;

import java.io.*;
import java.nio.charset.StandardCharsets;

//读写文件
public class Test {

    private static String readFilePath = "C:\\Users\\gjp\\Desktop\\新建文件夹\\test2.sql";
    private static String writeFilePath = "C:\\Users\\gjp\\Desktop\\新建文件夹\\test3.sql";

    public static void main(String[] args) {
        // char oo = 0x01;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(readFilePath));

            //        char[] chArr = new char[4096];
            String line = null;
            FileOutputStream fileOutputStream = new FileOutputStream(new File(writeFilePath));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            while((line = bufferedReader.readLine()) != null){
                line = line.replace("|", String.valueOf((char)1));
                line += "\r\n";
                bufferedOutputStream.write(line.getBytes(StandardCharsets.UTF_8));
            }

            bufferedReader.close();

            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
