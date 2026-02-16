package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This program groups Employee objects based on their department.
 * It uses a Map<Department, List<Employee>> where the key is the department
 * and the value is a list of employees belonging to that department.
 * If multiple employees belong to the same department, they are stored
 * together in the same list.
 */

class Employee {
    String name;
    String department;

    // Constructor to initialize employee details
    Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Returns employee name and department in readable format
    @Override
    public String toString() {
        return name;
    }
}

public class GroupObjects {

    // Groups employees by department and returns the resulting map
    public static Map<String, List<Employee>> groupByDepartment(List<Employee> employees) {

        Map<String, List<Employee>> groupedMap = new HashMap<>();

        for (Employee emp : employees) {
            groupedMap
                    .computeIfAbsent(emp.department, k -> new ArrayList<>())
                    .add(emp);
        }

        return groupedMap;
    }

    // Entry point of the program to test grouping functionality
    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", "HR"));
        employees.add(new Employee("Bob", "IT"));
        employees.add(new Employee("Carol", "HR"));

        Map<String, List<Employee>> result = groupByDepartment(employees);

        System.out.println(result);
    }
}
