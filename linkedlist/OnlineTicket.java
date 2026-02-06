package linkedlist;

/*
Problem Statement:
Design an online ticket reservation system using a circular linked list.
Each node represents a booked ticket with Ticket ID, Customer Name,
Movie Name, Seat Number, and Booking Time.

Operations:
- Add a new ticket at the end
- Remove a ticket by Ticket ID
- Display all booked tickets
- Search ticket by Customer Name or Movie Name
- Count total booked tickets
*/

class TicketSystem {

    // Circular Linked List Node
    class TicketNode {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        TicketNode next;

        TicketNode(int ticketId, String customerName, String movieName,
                   String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    private TicketNode head = null;
    private TicketNode tail = null;

    // Add ticket at end
    public void addTicket(int id, String customer, String movie,
                          String seat, String time) {
        TicketNode newNode = new TicketNode(id, customer, movie, seat, time);

        if (head == null) {
            head = tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Remove ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove");
            return;
        }

        TicketNode current = head;
        TicketNode previous = tail;

        do {
            if (current.ticketId == ticketId) {

                // Only one node
                if (current == head && current == tail) {
                    head = tail = null;
                }
                // Removing head
                else if (current == head) {
                    head = head.next;
                    tail.next = head;
                }
                // Removing tail
                else if (current == tail) {
                    tail = previous;
                    tail.next = head;
                }
                // Removing middle node
                else {
                    previous.next = current.next;
                }

                System.out.println("Ticket " + ticketId + " removed");
                return;
            }

            previous = current;
            current = current.next;

        } while (current != head);

        System.out.println("Ticket not found");
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        TicketNode temp = head;
        do {
            System.out.println(
                    "ID: " + temp.ticketId +
                            ", Customer: " + temp.customerName +
                            ", Movie: " + temp.movieName +
                            ", Seat: " + temp.seatNumber +
                            ", Time: " + temp.bookingTime
            );
            temp = temp.next;
        } while (temp != head);
    }

    // Search by Customer Name or Movie Name
    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        TicketNode temp = head;
        boolean found = false;

        do {
            if (temp.customerName.equalsIgnoreCase(keyword) ||
                    temp.movieName.equalsIgnoreCase(keyword)) {

                System.out.println(
                        "ID: " + temp.ticketId +
                                ", Customer: " + temp.customerName +
                                ", Movie: " + temp.movieName +
                                ", Seat: " + temp.seatNumber +
                                ", Time: " + temp.bookingTime
                );
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No matching ticket found");
        }
    }

    // Count total tickets
    public int countTickets() {
        if (head == null) return 0;

        int count = 0;
        TicketNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }
}

public class OnlineTicket {
    public static void main(String[] args) {

        TicketSystem system = new TicketSystem();

        system.addTicket(101, "Aarav", "Inception", "A10", "10:30 AM");
        system.addTicket(102, "Diya", "Interstellar", "B12", "01:00 PM");
        system.addTicket(103, "Rahul", "Inception", "C05", "04:00 PM");

        System.out.println("All Tickets:");
        system.displayTickets();

        System.out.println("\nSearch by Movie Name:");
        system.searchTicket("Inception");

        System.out.println("\nRemoving Ticket ID 102:");
        system.removeTicket(102);

        System.out.println("\nTickets After Removal:");
        system.displayTickets();

        System.out.println("\nTotal Tickets Booked: " + system.countTickets());
    }
}
