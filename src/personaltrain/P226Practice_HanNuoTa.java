package personaltrain;

//汉诺塔算法

public class P226Practice_HanNuoTa {
    public static void main(String[] args) {
        Tower tower = new Tower();
        tower.move(10,'A','B','C');
    }
}

class Tower {
    public void move(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println(a + "->" + c);
        } else {//有多个盘，看成两个，最下面的一个，和上面所有的盘
            //先移动上面所有的盘到b，借助c
            move(num - 1, a, c, b);
            //把最下面的盘，移动到c
            System.out.println(a + "->" + c);
            //把b塔的所有的盘，移动到c，借助a
            move(num - 1, b, a, c);

        }
    }
}