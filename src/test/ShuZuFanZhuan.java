package test;

import java.util.Arrays;

/**
 * 2021/10/28
 */
public class ShuZuFanZhuan {
    public static void main(String[] args) {

        int[] a = {1,2,3,4,5};
        reverse(a,a.length);

    }

    static void reverse(int[] a,int n){
        int[] b = new int[n];
        for (int i = 0,j = n; i < n; i++) {
            b[j-1] = a[i];
            j--;
        }
        System.out.println("----");
        System.out.println(Arrays.toString(b));

    }
}
