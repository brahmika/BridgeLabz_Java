/*

 This program demonstrates two relationships:
 - Composition between University and Department
 - Aggregation between University and Faculty

 Deleting a University deletes all its Departments,
 but Faculty members can exist independently..
*/

import java.util.ArrayList;

// Faculty class (can exist independently)
class Faculty {

    String name;
    String specialization;

    Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    void displayFaculty() {
        System.out.println("Faculty Name: " + name + ", Specialization: " + specialization);
    }
}

// Department class (cannot exist without University)
class Department {

    String departmentName;

    Department(String departmentName) {
        this.departmentName = departmentName;
    }

    void displayDepartment() {
        System.out.println("Department: " + departmentName);
    }
}

// University class
public class University {

    String universityName;
    ArrayList<Department> departments = new ArrayList<>();
    ArrayList<Faculty> facultyMembers = new ArrayList<>();

    University(String universityName) {
        this.universityName = universityName;
    }

    void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    void displayUniversity() {
        System.out.println("University: " + universityName);
        for (Department department : departments) {
            department.displayDepartment();
        }
        for (Faculty faculty : facultyMembers) {
            faculty.displayFaculty();
        }
    }

    public static void main(String[] args) {

        University university = new University("Global Tech University");

        university.addDepartment("Computer Science");
        university.addDepartment("Mechanical Engineering");

        Faculty f1 = new Faculty("Dr. Rao", "Artificial Intelligence");
        Faculty f2 = new Faculty("Dr. Mehta", "Thermodynamics");

        university.addFaculty(f1);
        university.addFaculty(f2);

        university.displayUniversity();

        university = null;

        System.out.println("\nUniversity deleted. Departments are deleted, faculty can still exist.");

        f1.displayFaculty();
        f2.displayFaculty();
    }
}
