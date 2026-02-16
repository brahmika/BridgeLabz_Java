/*
 * This program implements a simple Banking System.
 * A HashMap is used to store customer accounts where
 * Account Number is the key and Balance is the value.
 * A TreeMap is used to display customers sorted by balance.
 * A Queue is used to process withdrawal requests in FIFO order.
 */
package collections;
import java.util.*;

class WithdrawalRequest {
    String accountNumber;
    double amount;

    // Constructor to initialize withdrawal details
    WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}

public class BankingSystem {

    private Map<String, Double> accounts = new HashMap<>();
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    // Creates a new account with initial balance
    public void createAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }

    // Deposits money into an account
    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber,
                    accounts.get(accountNumber) + amount);
        }
    }

    // Adds a withdrawal request to the queue
    public void requestWithdrawal(String accountNumber, double amount) {
        withdrawalQueue.add(new WithdrawalRequest(accountNumber, amount));
    }

    // Processes withdrawal requests in FIFO order
    public void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();

            double currentBalance = accounts.getOrDefault(request.accountNumber, 0.0);

            if (currentBalance >= request.amount) {
                accounts.put(request.accountNumber,
                        currentBalance - request.amount);
                System.out.println("Withdrawal successful for Account "
                        + request.accountNumber);
            } else {
                System.out.println("Insufficient funds for Account "
                        + request.accountNumber);
            }
        }
    }

    // Displays accounts sorted by balance using TreeMap
    public void displayAccountsSortedByBalance() {
        System.out.println("\nAccounts Sorted by Balance:");

        TreeMap<Double, List<String>> sorted = new TreeMap<>();

        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            sorted
                    .computeIfAbsent(entry.getValue(), k -> new ArrayList<>())
                    .add(entry.getKey());
        }

        for (Map.Entry<Double, List<String>> entry : sorted.entrySet()) {
            for (String acc : entry.getValue()) {
                System.out.println("Account: " + acc +
                        " - Balance: $" + entry.getKey());
            }
        }
    }

    // Displays all accounts from HashMap
    public void displayAllAccounts() {
        System.out.println("All Accounts:");
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            System.out.println("Account: " + entry.getKey() +
                    " - Balance: $" + entry.getValue());
        }
    }

    // Entry point to test the banking system
    public static void main(String[] args) {

        BankingSystem bank = new BankingSystem();

        bank.createAccount("A101", 5000);
        bank.createAccount("A102", 3000);
        bank.createAccount("A103", 7000);

        bank.requestWithdrawal("A101", 1000);
        bank.requestWithdrawal("A102", 4000);
        bank.requestWithdrawal("A103", 2000);

        bank.processWithdrawals();

        bank.displayAllAccounts();
        bank.displayAccountsSortedByBalance();
    }
}
