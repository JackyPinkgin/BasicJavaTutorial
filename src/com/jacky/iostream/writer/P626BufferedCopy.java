package com.jacky.iostream.writer;

import java.io.*;

/**
 * 2021/11/9
 */
public class P626BufferedCopy {
    public static void main(String[] args) throws Exception {
        String srcPath = "D:\\JavaLearn\\src\\com\\jacky\\array_\\P485ArrayExercise.java";
        String desPath = "D:\\P485ArrayExercise.java";

        BufferedReader bufferedReader = new BufferedReader(new FileReader(srcPath));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(desPath));

        String readLine ;

        while ((readLine=bufferedReader.readLine())!=null){
            bufferedWriter.write(readLine);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        bufferedReader.close();

        System.out.println("程序执行完成");

    }
}
