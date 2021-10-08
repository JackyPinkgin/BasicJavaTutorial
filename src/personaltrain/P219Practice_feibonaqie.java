package personaltrain;

public class P219Practice_feibonaqie {
    public static void main(String[] args) {

        F a =new F();
        int res = a.feibo(9);
        System.out.println(res);
    }
}

class F{
    public int feibo(int n){
        if (n == 1||n==2) {
            return 1;
        }else {
            return feibo(n-1)+feibo(n-2);
        }
    }
}
