/*
 Sample Problem 2: Educational Course Hierarchy
 Description: Demonstrates multilevel inheritance using Course → OnlineCourse → PaidOnlineCourse
 Goal: Show how each inheritance level builds upon the previous one
*/

class Course {
    String courseName;
    int duration;

    // Constructor to initialize base course details
    Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Method to display basic course information
    void displayInfo() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " weeks");
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    // Constructor to initialize online course details
    OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    // Overriding displayInfo to add online-specific details
    void displayInfo() {
        super.displayInfo();
        System.out.println("Platform: " + platform);
        System.out.println("Recorded: " + isRecorded);
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    // Constructor to initialize paid online course details
    PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    // Overriding displayInfo to add payment-related details
    void displayInfo() {
        super.displayInfo();
        System.out.println("Fee: " + fee);
        System.out.println("Discount: " + discount + "%");
    }
}

public class CourseDemo {
    public static void main(String[] args) {

        // Creating object of the most derived class
        PaidOnlineCourse course =
                new PaidOnlineCourse("Java Programming", 8, "Coursera", true, 5000, 10);

        // Calling overridden method using subclass object
        course.displayInfo();
    }
}
