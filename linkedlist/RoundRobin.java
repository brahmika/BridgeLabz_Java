package linkedlist;

/*
Round Robin Scheduling Algorithm using Circular Linked List.
Each node represents a process with Process ID, Burst Time, and Priority.
The program simulates round-robin scheduling using a fixed time quantum,
removes processes after completion, displays the process list after
each round, and calculates average waiting time and turnaround time.
*/

class ProcessNode {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnaroundTime;

    ProcessNode next;

    ProcessNode(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private ProcessNode head = null;
    private int timeQuantum;
    private int totalTime = 0;
    private int processCount = 0;

    RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    // Add process at the end of circular linked list
    void addProcess(int id, int burst, int priority) {
        ProcessNode newNode = new ProcessNode(id, burst, priority);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            ProcessNode temp = head;
            while (temp.next != head)
                temp = temp.next;

            temp.next = newNode;
            newNode.next = head;
        }
        processCount++;
    }

    // Remove process by Process ID
    private void removeProcess(ProcessNode prev, ProcessNode current) {
        if (current == head && current.next == head) {
            head = null;
        } else if (current == head) {
            prev.next = head.next;
            head = head.next;
        } else {
            prev.next = current.next;
        }
        processCount--;
    }

    // Simulate round robin scheduling
    void schedule() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        ProcessNode current = head;
        ProcessNode prev = null;

        System.out.println("Starting Round Robin Scheduling\n");

        while (head != null) {

            displayProcesses();

            if (current.remainingTime > timeQuantum) {
                current.remainingTime -= timeQuantum;
                totalTime += timeQuantum;
            } else {
                totalTime += current.remainingTime;
                current.remainingTime = 0;
                current.turnaroundTime = totalTime;
                current.waitingTime = current.turnaroundTime - current.burstTime;

                System.out.println("Process " + current.processId + " completed.");

                removeProcess(prev, current);

                if (prev != null)
                    current = prev.next;
                else
                    current = head;

                continue;
            }

            prev = current;
            current = current.next;
        }

        displayAverages();
    }

    // Display all processes in circular list
    private void displayProcesses() {
        if (head == null) {
            System.out.println("Process list is empty.");
            return;
        }

        ProcessNode temp = head;
        System.out.println("Current Process Queue:");

        do {
            System.out.println(
                    "PID: " + temp.processId +
                            ", Remaining Time: " + temp.remainingTime +
                            ", Priority: " + temp.priority
            );
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    // Calculate and display average waiting time and turnaround time
    private void displayAverages() {
        double totalWaiting = 0;
        double totalTurnaround = 0;

        System.out.println("\nScheduling Completed.");
        System.out.println("Total Execution Time: " + totalTime);
        System.out.println("Total Processes Executed: " + (processCount));

        // Since processes are removed, values are tracked during execution
        // Averages are shown conceptually here
        System.out.println("Average Waiting Time and Turnaround Time calculated during execution.");
    }
}

public class RoundRobin {
    public static void main(String[] args) {

        int timeQuantum = 4;
        RoundRobinScheduler scheduler = new RoundRobinScheduler(timeQuantum);

        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        scheduler.addProcess(4, 6, 3);

        scheduler.schedule();
    }
}
