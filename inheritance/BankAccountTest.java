/*
 Sample Problem 1: Bank Account Types
 Description: Demonstrates hierarchical inheritance using BankAccount as the superclass
 Goal: Show how multiple account types share common features and have unique behavior
*/

class BankAccount {
    int accountNumber;
    double balance;

    // Constructor to initialize common bank account details
    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to display basic account details
    void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    double interestRate;

    // Constructor to initialize savings account details
    SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    // Method to display account type
    void displayAccountType() {
        System.out.println("Account Type: Savings Account");
    }
}

class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    // Constructor to initialize checking account details
    CheckingAccount(int accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    // Method to display account type
    void displayAccountType() {
        System.out.println("Account Type: Checking Account");
    }
}

class FixedDepositAccount extends BankAccount {
    int tenureYears;

    // Constructor to initialize fixed deposit account details
    FixedDepositAccount(int accountNumber, double balance, int tenureYears) {
        super(accountNumber, balance);
        this.tenureYears = tenureYears;
    }

    // Method to display account type
    void displayAccountType() {
        System.out.println("Account Type: Fixed Deposit Account");
    }
}

public class BankAccountTest {
    public static void main(String[] args) {

        // Creating objects of different bank account types
        SavingsAccount savings = new SavingsAccount(1001, 50000, 4.5);
        CheckingAccount checking = new CheckingAccount(1002, 30000, 10000);
        FixedDepositAccount fd = new FixedDepositAccount(1003, 200000, 5);

        // Displaying savings account details
        savings.displayAccountType();
        savings.displayDetails();

        // Displaying checking account details
        checking.displayAccountType();
        checking.displayDetails();

        // Displaying fixed deposit account details
        fd.displayAccountType();
        fd.displayDetails();
    }
}
