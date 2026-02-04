/*
 Problem 5: University Management System

 This program demonstrates aggregation and association.
 - Students enroll in Courses
 - Professors teach Courses
 - Students and Professors communicate via methods
   like enrollCourse() and assignProfessor()
*/

import java.util.ArrayList;

// Course class
class Course {

    String courseName;
    Professor professor;  // Association: professor assigned to course
    ArrayList<Student> students = new ArrayList<>(); // Students enrolled

    Course(String courseName) {
        this.courseName = courseName;
    }

    // Assign a professor to this course
    void assignProfessor(Professor professor) {
        this.professor = professor;
        professor.addCourse(this);
    }

    // Add a student to this course
    void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    // Display course details
    void displayCourseDetails() {
        System.out.println("Course: " + courseName);
        if (professor != null) {
            System.out.println("Professor: " + professor.name);
        }
        System.out.println("Enrolled Students:");
        for (Student s : students) {
            System.out.println("- " + s.name);
        }
    }
}

// Student class
class Student {

    String name;
    ArrayList<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    // Enroll in a course
    void enrollCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this); // Association link
        }
    }

    // Display courses student is enrolled in
    void viewCourses() {
        System.out.println("Student: " + name + " is enrolled in:");
        for (Course c : courses) {
            System.out.println("- " + c.courseName);
        }
    }
}

// Professor class
class Professor {

    String name;
    ArrayList<Course> courses = new ArrayList<>();

    Professor(String name) {
        this.name = name;
    }

    // Assign professor to a course
    void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    // View courses professor teaches
    void viewCourses() {
        System.out.println("Professor: " + name + " teaches:");
        for (Course c : courses) {
            System.out.println("- " + c.courseName);
        }
    }
}

// University demonstration
public class Student {

    public static void main(String[] args) {

        // Professors
        Professor prof1 = new Professor("Dr. Sharma");
        Professor prof2 = new Professor("Dr. Mehta");

        // Students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Courses
        Course course1 = new Course("Data Structures");
        Course course2 = new Course("Algorithms");

        // Assign professors to courses
        course1.assignProfessor(prof1);
        course2.assignProfessor(prof2);

        // Students enroll in courses
        student1.enrollCourse(course1);
        student1.enrollCourse(course2);
        student2.enrollCourse(course1);

        // Display course details
        course1.displayCourseDetails();
        course2.displayCourseDetails();

        // Display student course enrollment
        student1.viewCourses();
        student2.viewCourses();

        // Display professor courses
        prof1.viewCourses();
        prof2.viewCourses();
    }
}
