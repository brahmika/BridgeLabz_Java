//Object L102

/* Problem Statement: Write a program to create a Circle class with an attribute radius. Add methods to calculate and display the area and circumference of the circle.*/

public class Circle{
	double radius;
	double PI_VALUE = 3.14;
	
	Circle(double radius){
		this.radius = radius;
	}
	void circleArea(double radius){
		double area = PI_VALUE * Math.pow(radius, 2);
		System.out.println(area);
	}
	void circleCircumference(double radius){
		double circumference = 2 * PI_VALUE * radius;
		System.out.println(circumference);
	}
	
	public static void main(String[] args){
		Circle circle = new Circle(7);
		circle.circleArea(7);
		circle.circleCircumference(7);
		
	}
}