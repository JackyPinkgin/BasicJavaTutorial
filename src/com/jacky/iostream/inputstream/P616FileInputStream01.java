package com.jacky.iostream.inputstream;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Jacky
 * @version 1.0
 * @date 2021/11/7
 */
public class P616FileInputStream01 {
    public static void main(String[] args) {

    }

    @Test
    public void InputTest01() throws IOException {

        String filePath = "D:\\test1.txt";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        int read = 0;

        while ((read= fileInputStream.read())!=-1){
            System.out.print((char) read);
        }
        fileInputStream.close();

    }

    @Test
    public void InputTest02() throws IOException {

        String filePath = "D:\\test1.txt";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        int read = 0;
        byte[] buff = new byte[5];

        while ((read=fileInputStream.read(buff))!=-1){
            System.out.print(new String(buff, 0, read)+"|||");
        }

        fileInputStream.close();

    }

}
