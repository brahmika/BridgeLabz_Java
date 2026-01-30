//This class has a copy constructor that clones andother Person object attributes
public class Person{
    String name;
    int age;

    //Regular constructor defined
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    //Copy constructor
    public Person(Person p){
        this.name = p.name;
        this.age = p.age;
    }
    public void displayDetails(){
        System.out.println(name + ": " + age);
    }

    public static void main(String[] args){
        Person person1 = new Person("Bob", 25);
        Person person2 = new Person(person1);

        person1.displayDetails();
        person2.displayDetails();
    }

}