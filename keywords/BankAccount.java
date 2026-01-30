// This bank account class demonstrates:
//   - static variable and method
//   - this keyword
//   - final variable
//   - instanceof operator
public class BankAccount {

    // Static variable shared across all accounts
    static String bankName = "Global Bank";

    // Final variable: cannot be changed once assigned
    final int accountNumber;

    // Instance variables
    String accountHolderName;
    double balance;

    // Static variable to count total accounts
    static int totalAccounts = 0;

    // Constructor using 'this' to resolve ambiguity
    public BankAccount(String accountHolderName, int accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }

    // Static method to display total accounts
    public static void getTotalAccounts() {
        System.out.println("Total accounts: " + totalAccounts);
    }

    // Method to display account details → must be public for subclass access
    public void displayAccountDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

// Subclass with main method
class SavingsAccount extends BankAccount {

    double interestRate;

    public SavingsAccount(String accountHolderName, int accountNumber, double balance, double interestRate) {
        super(accountHolderName, accountNumber, balance);
        this.interestRate = interestRate;
    }

    public static void main(String[] args) {

        SavingsAccount sa1 = new SavingsAccount("Alice", 101, 50000, 4.5);
        SavingsAccount sa2 = new SavingsAccount("Bob", 102, 75000, 5.0);

        // instanceof check (optional, sa1 is already BankAccount)
        if (sa1 instanceof BankAccount) sa1.displayAccountDetails();
        if (sa2 instanceof BankAccount) sa2.displayAccountDetails();

        // Display total accounts using static method
        BankAccount.getTotalAccounts();
    }
}
