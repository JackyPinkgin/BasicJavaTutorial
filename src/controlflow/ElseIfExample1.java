package controlflow;

public class ElseIfExample1 {
    public static void main(String[] args) {
        int score = 890;
        System.out.println("your score is " + score);

        if (score < 50) {
            System.out.println("you have not pass");
        } else if (score >= 50 && score < 80) {
            System.out.println("you have passed");
        } else {
            System.out.println("you have good grades");
        }

    }
}
