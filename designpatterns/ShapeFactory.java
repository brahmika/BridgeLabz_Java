package designpatterns;

public class ShapeFactory {

    public static Shape getShape(String type) {

        if (type == null) {
            return null;
        }

        if (type.equalsIgnoreCase("circle")) {
            return new Circle();
        }

        if (type.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        }

        return null;
    }
}