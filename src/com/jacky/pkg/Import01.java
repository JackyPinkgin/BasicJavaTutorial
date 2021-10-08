package com.jacky.pkg;


import java.util.Arrays;

public class Import01 {
    public static void main(String[] args) {
        int[] a={-1,55,4,330,15};
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+"\t");
        }
    }
}
