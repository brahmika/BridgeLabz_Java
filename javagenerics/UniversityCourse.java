/*
 * University Course Management System
 * ------------------------------------
 * This program demonstrates:
 * - Generic Classes
 * - Bounded Type Parameters
 * - Wildcards
 *
 * Different course evaluation types such as Exam,
 * Assignment-based, and Research-based are handled
 * using a generic Course<T extends CourseType>.
 * The system dynamically stores and displays
 * multiple course types while maintaining type safety.
 */

package javagenerics;

import java.util.ArrayList;
import java.util.List;

abstract class CourseType {

    private String evaluationMethod;

    // Constructor to initialize evaluation method
    public CourseType(String evaluationMethod) {
        this.evaluationMethod = evaluationMethod;
    }

    // Returns evaluation method
    public String getEvaluationMethod() {
        return evaluationMethod;
    }

    // Abstract method to define evaluation behavior
    public abstract void evaluate();
}

class ExamCourse extends CourseType {

    // Constructor for ExamCourse
    public ExamCourse() {
        super("Final Exam");
    }

    // Defines exam evaluation logic
    @Override
    public void evaluate() {
        System.out.println("This course is evaluated with an exam");
    }
}

class AssignmentBased extends CourseType {

    // Constructor for AssignmentBased course
    public AssignmentBased() {
        super("Assignments");
    }

    // Defines assignment evaluation logic
    @Override
    public void evaluate() {
        System.out.println("Evaluated through continous assignements");
    }
}

class ResearchCourse extends CourseType {

    // Constructor for ResearchCourse
    public ResearchCourse() {
        super("Research Project");
    }

    // Defines research evaluation logic
    @Override
    public void evaluate() {
        System.out.println("Evaluated through thesis");
    }
}

class Course<T extends CourseType> {

    private String courseName;
    private String department;
    private T courseType;

    // Constructor to initialize course details.
    public Course(String courseName, String department, T courseType) {
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }

    // Returns the course type
    public T getCourseType() {
        return courseType;
    }

    // Displays complete course details
    public void displayCourseDetails() {
        System.out.println("Course: " + courseName +
                ", Department: " + department +
                ", Evaluation: " + courseType.getEvaluationMethod());
        courseType.evaluate();
    }
}

public class UniversityCourse {

    // Entry point of the program
    public static void main(String[] args) {

        ExamCourse exam = new ExamCourse();
        AssignmentBased assignment = new AssignmentBased();
        ResearchCourse research = new ResearchCourse();

        // Creating courses using generics
        Course<ExamCourse> math =
                new Course<>("Advanced Mathematics", "Science", exam);

        Course<AssignmentBased> programming =
                new Course<>("Data Structures", "Computer Science", assignment);

        Course<ResearchCourse> ai =
                new Course<>("AI Research", "Computer Science", research);

        // Store different course types in same list
        List<Course<?>> courseCatalog = new ArrayList<>();
        courseCatalog.add(math);
        courseCatalog.add(programming);
        courseCatalog.add(ai);

        System.out.println("=== University Course Catalog ===");

        for (Course<?> course : courseCatalog) {
            course.displayCourseDetails();
        }

        // Using wildcard method
        System.out.println("=== Displaying Evaluation Types Dynamically ===");
        displayEvaluationTypes(getCourseTypes(courseCatalog));
    }

    // Displays evaluation methods using upper bounded wildcard
    public static void displayEvaluationTypes(List<? extends CourseType> types) {
        for (CourseType type : types) {
            System.out.println("Evaluation Method: " + type.getEvaluationMethod());
        }
    }

    // Extracts CourseType objects from Course list
    public static List<CourseType> getCourseTypes(List<Course<?>> courses) {
        List<CourseType> types = new ArrayList<>();

        for (Course<?> course : courses) {
            types.add(course.getCourseType());
        }

        return types;
    }
}
