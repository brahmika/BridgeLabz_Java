/*
 Problem Statement 7: Exception Handling with Resource Cleanup
 Demonstrates cleanup using finally block.
*/
package exceptions;

public class ConnectionManager {

    static class Connection {
        void open() {
            System.out.println("Connection opened.");
        }

        void close() {
            System.out.println("Connection closed.");
        }
    }

    public void manageConnection() {
        Connection connection = new Connection();
        try {
            connection.open();
            throw new RuntimeException("Unexpected error.");
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            connection.close();
        }
    }

    public static void main(String[] args) {
        ConnectionManager cm = new ConnectionManager();
        cm.manageConnection();
    }
}
