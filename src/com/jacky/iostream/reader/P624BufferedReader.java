package com.jacky.iostream.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * 2021/11/8
 */
public class P624BufferedReader {
    public static void main(String[] args) throws Exception {

        String codePath = "D:\\JavaLearn\\src\\com\\jacky\\array_\\P485ArrayExercise.java";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(codePath));

        String line = null;

        while ((line = bufferedReader.readLine())!=null){
            System.out.println(line);
        }

        bufferedReader.close();

        System.out.println("程序执行完成");


    }
}
