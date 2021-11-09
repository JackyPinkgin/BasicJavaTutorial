package com.jacky.iostream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 2021/11/9
 */
public class P642Homework01 {
    public static void main(String[] args) throws IOException {

        String path = "d:\\mytemp";
        File file = new File(path);
        if (!file.exists()){
            System.out.println("don't exist, creat mytemp");
            if (file.mkdir()){
                System.out.println("create " + path + " successful");
            }
        }else {
            System.out.println("folder already exist");
        }

        String filepath = path+"\\hello.txt";
        file = new File(filepath);
        if (!file.exists()){
            if (file.createNewFile()){
                System.out.println("创建成功");
            }
            else {
                System.out.println("创建失败");
            }
        }else {
            System.out.println(filepath+" 文件已经存在");
        }



    }
}
