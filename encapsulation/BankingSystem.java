/*
 * This program demonstrates:
 * - Abstraction using an abstract BankAccount class
 * - Inheritance through SavingsAccount and CurrentAccount
 * - Interface implementation using Loanable
 * - Encapsulation to protect account details and balance
 * - Polymorphism by calculating interest dynamically for different accounts
 */

// Interface for loan-related functionality
interface Loanable {

    // Apply for a loan
    void applyForLoan();

    // Calculate loan eligibility amount
    double calculateLoanEligibility();
}

// Abstract base class for bank accounts
abstract class BankAccount {

    // Encapsulated fields
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }

    // Abstract method for interest calculation
    public abstract double calculateInterest();

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Getter for account holder name
    public String getHolderName() {
        return holderName;
    }
}

// Savings account class
class SavingsAccount extends BankAccount implements Loanable {

    // Constructor
    public SavingsAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    // Calculate interest for savings account
    @Override
    public double calculateInterest() {
        return getBalance() * 0.04;
    }

    // Apply for loan
    @Override
    public void applyForLoan() {
        System.out.println("Loan applied for Savings Account");
    }

    // Calculate loan eligibility
    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 5;
    }
}

// Current account class
class CurrentAccount extends BankAccount implements Loanable {

    // Constructor
    public CurrentAccount(String accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    // Calculate interest for current account
    @Override
    public double calculateInterest() {
        return getBalance() * 0.02;
    }

    // Apply for loan
    @Override
    public void applyForLoan() {
        System.out.println("Loan applied for Current Account");
    }

    // Calculate loan eligibility
    @Override
    public double calculateLoanEligibility() {
        return getBalance() * 3;
    }
}

// Main class to demonstrate polymorphism
public class BankingSystem {

    public static void main(String[] args) {

        // Polymorphic array of bank accounts
        BankAccount[] accounts = {
                new SavingsAccount("SA101", "Alice", 50000),
                new CurrentAccount("CA202", "Bob", 80000)
        };

        // Iterate through accounts
        for (BankAccount acc : accounts) {

            // Calculate interest dynamically
            double interest = acc.calculateInterest();

            // Cast to Loanable
            Loanable loanAccount = (Loanable) acc;

            // Print account details
            System.out.println(
                    acc.getHolderName() +
                            " | Interest: " + interest +
                            " | Loan Eligibility: " + loanAccount.calculateLoanEligibility()
            );
        }
    }
}
