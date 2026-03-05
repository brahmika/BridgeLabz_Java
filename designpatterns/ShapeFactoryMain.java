package designpatterns;

public class ShapeFactoryMain {

    public static void main(String[] args) {

        Shape shape1 = ShapeFactory.getShape("circle");
        shape1.draw();

        Shape shape2 = ShapeFactory.getShape("rectangle");
        shape2.draw();
    }
}