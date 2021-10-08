package personaltrain;


import java.util.Scanner;

public class ScannerPractice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入名字");
        String name = scanner.next();//接收用户输入

        System.out.println("请输入年龄");
        int age = scanner.nextInt();

        System.out.println("请输入工资");
        double salary = scanner.nextDouble();

        System.out.println("人的信息如下");
        System.out.println("name= " + name + " age=" + age + " salary= " + salary);


    }
}
