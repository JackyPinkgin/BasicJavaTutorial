package personaltrain;

/**
 * @author Jacky
 * @version 1.0
 * @date 2021/10/23
 */
public class FeiboPractice {
    public static void main(String[] args) {
        for (int i = 3; i < 10; i++) {
            System.out.println("第"+i+"个:"+Solution.Fibonacci(i));
        }
//        System.out.println(Solution.Fibonacci(10));

    }
}

class Solution {
    public static int Fibonacci(int n) {
        if (n == 1||n==2) {
            return 1;
        }else {
            return Fibonacci(n-1)+Fibonacci(n-2);
        }
    }
}
