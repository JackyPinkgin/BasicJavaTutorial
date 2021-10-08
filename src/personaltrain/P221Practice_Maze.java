package personaltrain;

public class P221Practice_Maze {
    public static void main(String[] args) {
        //设置迷宫地图
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }

        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
//        map[1][2] = 1;
//        map[2][1] = 1;
        map[2][2] = 1;

//        //把第五行全部弄成障碍物
//        for (int i = 0; i < 7; i++) {
//            map[5][i]=1;
//        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        //使用findWay来招录
        T t = new T();
        boolean a = t.findWay(map, 1, 1);
        System.out.println(a);
        System.out.println("----------找路情况如下---------");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class T {
    //0表示可以走，1表示障碍物，2表示可以走，3表示走过，但是走不通
    public boolean findWay(int[][] map, int i, int j) {
        if (map[6][1] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {//当前这个位置0，说明未知可以走
                //假定可以走通
                map[i][j] = 2;
                //假定探测的方向是  下右上左
                if (findWay(map, i + 1, j)) {
                    return true;
                } else if (findWay(map, i, j + 1)) {
                    return true;
                } else if (findWay(map, i - 1, j)) {
                    return true;
                } else if (findWay(map, i, j - 1)) {
                    return true;
                } else {
                    //说明当前的路 走不通，置为3
                    map[i][j] = 3;
                    return false;
                }

            } else {//map[i][j]==1,2,3
                return false;
            }
        }
    }
}
