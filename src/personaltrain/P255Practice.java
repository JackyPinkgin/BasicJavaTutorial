package personaltrain;

public class P255Practice {
    public static void main(String[] args) {
        A03 c = new A03();
        int[] d={1,5,3,8,6,44};
        int[] f = c.copyArr(d);

        for (int i = 0; i < f.length; i++) {
            System.out.print(f[i]+" ");
        }

    }
}


class A03{

    public int[] copyArr(int[] a){
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i]=a[i];
        }
        return b;

    }

}