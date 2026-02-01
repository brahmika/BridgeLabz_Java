/* This program demonstrates inheritance by creating an Animal superclass and Dog, Cat, and Bird subclasses that override the makeSound() method to show polymorphism.*/

//Superclass for Animal Class
public class Animal {
    String name;
    int age;

    //Constructor to initialise name and age
    Animal(String name, int age){
        this.name = name;
        this.age = age;
    }
    //Method to be overriden by subclasses
    void makeSound(){
        System.out.println("Animal makes a sound");
    }
}

//Dog class inherits from Animal
class Dog extends Animal{
    //Constructor calling the superclass constructor
    Dog(String name, int age){
        super(name, age);
    }

    //overriding makeSound method for Dog
    @java.lang.Override
    void makeSound() {
        super.makeSound("Dog Barks");
    }
}

//Cat class inherits from the Animal class
class Cat extends Animal {
    Cat(String name, int age){
        super(name, age);
    }

    // Overriding makeSound method for Cat
    @java.lang.Override
    void makeSound() {
        super.makeSound("Cat meows");
    }
}

class Bird extends Animal{
    Bird(String name, int age){
        super(name, age);
    }

    @java.lang.Override
    void makeSound() {
        super.makeSound("Bird Chirps");
    }
}

class AnimalTest {
    public static void main(String[] args){
        Animal a1 = new Dog("Buddy", 3);  // Animal reference holding Dog object
        Animal a2 = new Cat("Kitty", 2);  // Animal reference holding Cat object
        Animal a3 = new Bird("Chirpy", 1); // Animal reference holding Bird object

        a1.makeSound();
        a2.makeSound();
        a3.makeSound();
    }
}