/*
 Problem Statement 5: Rethrowing Custom Exception
 Demonstrates rethrowing TransactionException.
*/
package exceptions;

class TransactionException extends Exception {
    public TransactionException(String msg) {
        super(msg);
    }
}

public class CustomContext {

    public void processTransaction(String id, double amount) throws TransactionException {
        try {
            if (amount < 0) {
                throw new IllegalArgumentException("Invalid amount.");
            }
            System.out.println("Transaction successful.");
        } catch (Exception e) {
            throw new TransactionException("Transaction Failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        CustomContext ts = new CustomContext();
        try {
            ts.processTransaction("TXN1", -100);
        } catch (TransactionException e) {
            System.out.println(e.getMessage());
        }
    }
}
