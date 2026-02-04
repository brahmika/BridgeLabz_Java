/*
 Problem: Bank and Customer (Association)

 This program demonstrates an **association** relationship.
 A Bank is associated with multiple Customers.
 A Customer can have multiple Accounts, and each Account
 is linked to a Bank.

*/

import java.util.ArrayList;

// Account class (links Customer and Bank)
class Account {

    double balance;
    Bank bank;

    // Constructor to initialize account with bank and balance
    Account(Bank bank, double balance) {
        this.bank = bank;
        this.balance = balance;
    }

    // Method to return current balance
    double getBalance() {
        return balance;
    }
}

// Customer class
class Customer {

    String name;
    ArrayList<Account> accounts = new ArrayList<>();

    // Constructor to initialize customer name
    Customer(String name) {
        this.name = name;
    }

    // Method to add an account to the customer
    void addAccount(Account account) {
        accounts.add(account);
    }

    // Method to view balances of all accounts
    void viewBalance() {
        System.out.println("Balances for customer: " + name);
        for (Account account : accounts) {
            System.out.println("Bank: " + account.bank.bankName +
                    ", Balance: " + account.getBalance());
        }
    }
}

// Bank class
public class Bank {

    String bankName;
    ArrayList<Customer> customers = new ArrayList<>();

    // Constructor to initialize bank name
    Bank(String bankName) {
        this.bankName = bankName;
    }

    // Method to open an account for a customer
    void openAccount(Customer customer, double initialBalance) {

        // Create a new account linked to this bank
        Account account = new Account(this, initialBalance);

        // Associate account with customer
        customer.addAccount(account);

        // Add customer to bank if not already present
        if (!customers.contains(customer)) {
            customers.add(customer);
        }

        System.out.println("Account opened for " + customer.name +
                " in " + bankName);
    }

    public static void main(String[] args) {

        // Creating bank.
        Bank sbi = new Bank("SBI");

        // Creating customers
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        // Opening accounts
        sbi.openAccount(alice, 5000);
        sbi.openAccount(alice, 12000);
        sbi.openAccount(bob, 8000);

        // Customers viewing their balances
        alice.viewBalance();
        System.out.println();
        bob.viewBalance();
    }
}
