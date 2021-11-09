package com.jacky.iostream.outputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 2021/11/8
 */
public class P618CopyFIle {
    public static void main(String[] args) throws IOException {

        String srcPath = "D:\\test-3.txt.simple.txt";
        String desPath = "D:\\new_test-3.txt.simple.txt";

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        int readLength = 0;
        byte[] buff = new byte[1024];


        fileInputStream = new FileInputStream(srcPath);
        fileOutputStream = new FileOutputStream(desPath, true);

        while ((readLength = fileInputStream.read(buff)) != -1) {
            fileOutputStream.write(buff, 0, readLength);
        }
        System.out.println("复制完成");

        fileInputStream.close();
        fileOutputStream.close();


    }
}
