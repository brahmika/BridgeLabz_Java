/*
 Program to Simulate an ATM
 Description: Allows depositing money, withdrawing money, and displaying balance
*/

class BankAccount {
    String accountHolder;
    int accountNumber;
    double balance;

    // Constructor to initialize bank account details
    BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit money into the account
    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited Amount: " + amount);
    }

    // Method to withdraw money if sufficient balance exists
    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn Amount: " + amount);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    // Method to display current balance
    void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

public class ATMSystem {
    public static void main(String[] args) {

        // Creating a bank account object
        BankAccount account = new BankAccount("Brahmika", 123456, 10000);

        // Depositing money
        account.deposit(2000);

        // Withdrawing money
        account.withdraw(3000);

        // Attempting to withdraw more than balance
        account.withdraw(15000);

        // Displaying final balance
        account.displayBalance();
    }
}
