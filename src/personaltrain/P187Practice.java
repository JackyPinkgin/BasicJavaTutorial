package personaltrain;

/*
* P187的题目
*
* */

public class P187Practice {
    public static void main(String[] args) {

        int[] a = {10, 12, 45, 55, 90, 150};
        int[] b = new int[a.length + 1];

        int num = 50;
        int newindex = -1;
        for (int i = 0; i < a.length; i++) {
            if (num <= a[i]) {
                newindex = i;
                break;
            }
        }

        if (newindex == -1) {
            newindex = a.length;
        }
        
        
        System.out.println();

        for (int i = 0,j = 0; i < b.length; i++) {
            if (i != newindex) {
                b[i]=a[j];
                j++;
            }else {
                b[i]=num;
            }
        }

        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }

    }
}
