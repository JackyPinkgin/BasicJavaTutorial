package com.jacky.iostream;

import java.io.*;

/**
 * 2021/11/10
 * 如果要读取的文件，使用的是gbk/ansi编码的 应该怎么处理
 */
public class P643Homework02_1 {
    public static void main(String[] args) throws IOException {
        String path = "D:\\mytemp\\tttt9.txt";
        //这里InputStreamReader有两个参数，一个是InputStream的子类，一个是charsetName
        // 因为对应的文件编码是ANSI，对应中文操作系统是gbk，所以要写gbk
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"gbk"));
        String line = "";
        int i = 1;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println("第" + (i++) + "行  " + line);
        }
        bufferedReader.close();
    }
}
