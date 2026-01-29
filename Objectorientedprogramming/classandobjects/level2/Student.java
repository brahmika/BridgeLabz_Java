// Objects L106
class Student {

    String name;
    int rollNumber;
    double marks;
    char grade;

    Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    void calculateGrade() {
        if (marks >= 90) {
            grade = 'A';
        } else if (marks >= 75) {
            grade = 'B';
        } else if (marks >= 60) {
            grade = 'C';
        } else if (marks >= 40) {
            grade = 'D';
        } else {
            grade = 'F';
        }
    }

    void displayDetails() {
        System.out.println(name);
        System.out.println(rollNumber);
        System.out.println(marks);
        System.out.println(grade);
    }

    public static void main(String[] args) {

        Student student = new Student("Brahmika", 105, 82);

        student.calculateGrade();
        student.displayDetails();
    }
}
