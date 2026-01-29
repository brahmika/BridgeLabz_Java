// Circle class demonstrating constructor chaining with default and user-provided radius

public class Circl{
    double radius;

    public Circl(){
        this(5.2);
    }
    public Circl(double radius){
        this.radius = radius;
    }
    public void displayCircle(){
        System.out.println(radius);
    }
    public static void main(String[] args){
        Circl circle1 = new Circl();
        circle1.displayCircle();
        System.out.println();

        Circl circle2 = new Circl();
        circle2.displayCircle();
        System.out.println();
    }

}