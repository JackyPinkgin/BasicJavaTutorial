package personaltrain;

import java.util.Scanner;

public class Bubbo_sort {
    public static void main(String[] args) {

        int[] a = {14, 12, 55, 45, 90};
        int[] b = new int[a.length + 1];
        int tmp =0;
        Scanner scanner = new Scanner(System.in);

//        System.out.println("输入新的int元素");
//        int num = scanner.nextInt();
        int num = 23;

        //输出原始的a
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();


        for (int i = 0; i < a.length; i++) {
            b[i]=a[i];
            b[a.length] = num;
        }
        a=b;

        //输出加了数字的a
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();

        //开始冒泡排序

         for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-i-1; j++) {
                if(a[j]>a[j+1]){
                    tmp = a[j];
                    a[j]=a[j+1];
                    a[j+1]=tmp;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }


    }
}
