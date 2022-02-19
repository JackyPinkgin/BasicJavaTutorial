package personaltrain;

public class P219Practice_feibonaqie {
    public static void main(String[] args) {

        System.out.println(F.feibo(9));

    }
}

class F{
    public static int feibo(int n){
        if (n == 1||n==2) {
            return 1;
        }else {
            return feibo(n-1)+feibo(n-2);
        }
    }
}
