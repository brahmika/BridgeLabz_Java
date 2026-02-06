package linkedlist;
/*
Task Scheduler using Circular Linked List.
Each task contains Task ID, Name, Priority, and Due Date.
The program supports insertion, deletion, searching,
traversal, and circular task scheduling operations.
*/

class TaskNode {
    int taskId;
    String taskName;
    String dueDate;
    int priority;

    TaskNode next;

    TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class CircularTaskScheduler {
    private TaskNode head = null;
    private TaskNode current = null;

    // 1️⃣ Add at Beginning
    void addAtBeginning(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        TaskNode temp = head;
        while (temp.next != head)
            temp = temp.next;

        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    // 2️⃣ Add at End
    void addAtEnd(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        TaskNode temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = newNode;
        newNode.next = head;
    }

    // 3️⃣ Add at Specific Position (1-based)
    void addAtPosition(int pos, int id, String name, int priority, String date) {
        if (pos <= 1) {
            addAtBeginning(id, name, priority, date);
            return;
        }

        TaskNode newNode = new TaskNode(id, name, priority, date);
        TaskNode temp = head;
        int count = 1;

        while (temp.next != head && count < pos - 1) {
            temp = temp.next;
            count++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // 4️⃣ Remove by Task ID
    void removeById(int id) {
        if (head == null) return;

        TaskNode temp = head;
        TaskNode prev = null;

        do {
            if (temp.taskId == id) {
                if (temp == head) {
                    TaskNode last = head;
                    while (last.next != head)
                        last = last.next;

                    head = head.next;
                    last.next = head;
                } else {
                    prev.next = temp.next;
                }
                System.out.println("Task removed: " + id);
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task not found.");
    }

    // 5️⃣ View Current Task & Move to Next
    void viewNextTask() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        displayTask(current);
        current = current.next;
    }

    // 6️⃣ Display All Tasks
    void displayAll() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        TaskNode temp = head;
        System.out.println("\nTask List:");
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // 7️⃣ Search by Priority
    void searchByPriority(int priority) {
        if (head == null) return;

        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No task with priority: " + priority);
    }

    // Helper Method
    private void displayTask(TaskNode t) {
        System.out.println(
                "ID: " + t.taskId +
                        ", Name: " + t.taskName +
                        ", Priority: " + t.priority +
                        ", Due: " + t.dueDate
        );
    }
}

public class TaskScheduler {
    public static void main(String[] args) {

        CircularTaskScheduler scheduler = new CircularTaskScheduler();

        scheduler.addAtEnd(1, "Assignment", 1, "10-02-2026");
        scheduler.addAtEnd(2, "Project", 2, "15-02-2026");
        scheduler.addAtBeginning(3, "Exam Prep", 1, "08-02-2026");
        scheduler.addAtPosition(2, 4, "Meeting", 3, "09-02-2026");

        scheduler.displayAll();

        System.out.println("\nCurrent Task Rotation:");
        scheduler.viewNextTask();
        scheduler.viewNextTask();

        System.out.println("\nSearch by Priority:");
        scheduler.searchByPriority(1);

        scheduler.removeById(2);
        scheduler.displayAll();
    }
}
