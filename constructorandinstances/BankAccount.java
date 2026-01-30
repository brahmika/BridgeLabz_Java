/*
   This program demonstrates access modifiers using a Bank Account system.
   BankAccount is the parent class.
   SavingsAccount is a subclass that accesses public and protected members
   and accesses private members using public methods.
*/

public class BankAccount {

    // Access modifiers
    public int accountNumber;        // public
    protected String accountHolder;  // protected
    private double balance;           // private

    // Constructor
    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to access balance
    public double getBalance() {
        return balance;
    }

    // Public method to modify balance
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
class SavingsAccount extends BankAccount {

    double interestRate;

    public SavingsAccount(int accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Demonstrates access to public and protected members
    public void displaySavingsAccountDetails() {
        System.out.println("Account Number: " + accountNumber);      // public
        System.out.println("Account Holder: " + accountHolder);      // protected
        System.out.println("Balance: " + getBalance());             // private via getter
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    // main method in subclass
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(10101, "Rahul", 50000, 4.5);
        sa.displaySavingsAccountDetails();

        // Modifying balance using public method
        sa.setBalance(55000);
        System.out.println("Updated Balance: ₹" + sa.getBalance());
    }
}
