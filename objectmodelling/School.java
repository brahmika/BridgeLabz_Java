/*

 Goal:
 - Students can enroll in multiple courses
 - Courses can have multiple students
 - Objects exist independently
*/

import java.util.ArrayList;

// Course class
class Course {

    String courseName;
    ArrayList<Student> students = new ArrayList<>();

    // Constructor to initialize course name
    Course(String courseName) {
        this.courseName = courseName;
    }

    // Method to add student to the course.
    void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    // Method to display students enrolled in this course
    void displayStudents() {
        System.out.println("Course: " + courseName);
        for (Student student : students) {
            System.out.println("Student: " + student.name);
        }
    }
}

// Student class
class Student {

    String name;
    ArrayList<Course> courses = new ArrayList<>();

    // Constructor to initialize student name
    Student(String name) {
        this.name = name;
    }

    // Method to enroll in a course
    void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this); // association link
        }
    }

    // Method to display enrolled courses
    void viewCourses() {
        System.out.println("Courses enrolled by " + name + ":");
        for (Course course : courses) {
            System.out.println(course.courseName);
        }
    }
}

// School class
public class School {

    String schoolName;
    ArrayList<Student> students = new ArrayList<>();

    // Constructor to initialize school name
    School(String schoolName) {
        this.schoolName = schoolName;
    }

    // Method to add student to the school
    void addStudent(Student student) {
        students.add(student);
    }

    public static void main(String[] args) {

        // Creating school
        School school = new School("Green Valley School");

        // Creating students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        // Creating courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Aggregation: school has students
        school.addStudent(alice);
        school.addStudent(bob);

        // Association: stud
