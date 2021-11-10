package com.jacky.iostream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 2021/11/10
 */
public class P643Homework02 {
    public static void main(String[] args) throws IOException {
        String path = "D:\\mytemp\\12345678951468729.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = "";
        int i = 1;

        while ((line = bufferedReader.readLine()) != null) {
            System.out.println("第" + (i++) + "行  " + line);
        }
        bufferedReader.close();
    }
}
