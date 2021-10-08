package personaltrain;

public class P256Practice {
    public static void main(String[] args) {
        Circle c = new Circle();
        System.out.println(c.Perimeter(5));
    }
}


class Circle{

    public double Perimeter(double radius){
        return 2*Math.PI*radius;
    }

}