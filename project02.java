import java.util.HashMap;
import java.util.Map;

class Bank {
    private Map<String, Double> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber, double initialBalance) {
        accounts.put(accountNumber, initialBalance);
        System.out.println("Account created successfully.");
    }

    public void deposit(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            accounts.put(accountNumber, currentBalance + amount);
            System.out.println("Deposit successful. Current balance: " + accounts.get(accountNumber));
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        if (accounts.containsKey(accountNumber)) {
            double currentBalance = accounts.get(accountNumber);
            if (currentBalance >= amount) {
                accounts.put(accountNumber, currentBalance - amount);
                System.out.println("Withdrawal successful. Current balance: " + accounts.get(accountNumber));
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    public void checkBalance(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Current balance: " + accounts.get(accountNumber));
        } else {
            System.out.println("Account not found.");
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Creating accounts
        bank.createAccount("12345", 1000.0);
        bank.createAccount("67890", 500.0);

        // Performing transactions
        bank.deposit("12345", 200.0);
        bank.withdraw("67890", 100.0);

        // Checking balances
        bank.checkBalance("12345");
        bank.checkBalance("67890");
        bank.checkBalance("00000"); // Non-existent account
    }
}
