package personaltrain;

/*
* P187的题目
*
* */

public class P188Practice_bubbo_sort {
    public static void main(String[] args) {


        //重新写冒泡排序
        int[] a={1,88,462,4561,8945,321,115};
        int tmp = 0;

        for(int i =0; i <a.length-1;i++){
            for (int j = 0; j < a.length-i-1; j++) {
                if (a[j] > a[j+1]) {
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
