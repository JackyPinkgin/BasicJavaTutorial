package personaltrain;

public class P220Practice_MonkeyEatPeach {
    public static void main(String[] args){
        houzi a = new houzi();
        int res = a.f(1);
        if(res==-1){
            System.out.println("wrong number");
        }else {
            System.out.println(res);
        }
    }
}


class houzi{
    public int f(int n){
        if (n >10 || n<1) {
            return -1;
        }else if (n == 10) {
            return 1;
        }else {
            return (f(n+1)+1)*2;
        }
    }
}