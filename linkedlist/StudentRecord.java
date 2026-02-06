class StudentNode {
    int rollNo;
    String name;
    int age;
    char grade;
    StudentNode next;

    StudentNode(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    StudentNode head;

    // Add at beginning
    void addAtBeginning(int rollNo, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    void addAtEnd(int rollNo, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);

        if (head == null) {
            head = newNode;
            return;
        }

        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add at specific position
    void addAtPosition(int rollNo, String name, int age, char grade, int position) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);

        if (position == 1) {
            newNode.next = head;
            head = newNode;
            return;
        }

        StudentNode temp = head;
        for (int i = 1; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }

        if (temp == null) return;

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete by roll number
    void deleteByRollNo(int rollNo) {
        if (head == null) return;

        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }

        StudentNode temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Search by roll number
    void searchByRollNo(int rollNo) {
        StudentNode temp = head;

        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Student Found:");
                System.out.println(temp.rollNo + " | " + temp.name + " | " + temp.age + " | " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    // Update grade
    void updateGrade(int rollNo, char newGrade) {
        StudentNode temp = head;

        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                return;
            }
            temp = temp.next;
        }
    }

    // Display all students
    void displayStudents() {
        StudentNode temp = head;

        while (temp != null) {
            System.out.println(
                    temp.rollNo + " | " +
                            temp.name + " | " +
                            temp.age + " | " +
                            temp.grade
            );
            temp = temp.next;
        }
    }
}

public class StudentRecord {
    public static void main(String[] args) {

        StudentLinkedList list = new StudentLinkedList();

        // Adding students
        list.addAtEnd(1, "Asha", 20, 'A');
        list.addAtEnd(2, "Ravi", 21, 'B');
        list.addAtBeginning(3, "Neha", 19, 'A');
        list.addAtPosition(4, "Karan", 22, 'C', 2);

        System.out.println("All Students:");
        list.displayStudents();

        // Search
        System.out.println("\nSearching for Roll No 2:");
        list.searchByRollNo(2);

        // Update grade
        list.updateGrade(2, 'A');

        // Delete a student
        list.deleteByRollNo(1);

        System.out.println("\nAfter Update and Deletion:");
        list.displayStudents();
    }
}
