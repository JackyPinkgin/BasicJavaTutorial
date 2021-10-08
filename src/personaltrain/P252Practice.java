package personaltrain;

public class P252Practice {
    public static void main(String[] args) {

        double[] c = {10.1, 5.5, 8.9, 0.2, 66.3};

        A01 a = new A01();
        System.out.println(a.max(c));
    }
}

class A01 {
    public double max(double[] a) {
        double b = 0;
        for (int i = 0; i < a.length; i++) {
            b = b > a[i] ? b : a[i];
        }
        return b;
    }
}