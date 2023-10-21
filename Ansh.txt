import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: RS" + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Bank Management System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Info");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accountNumber = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Account Holder's Name: ");
                    String accountHolder = sc.nextLine();
                    System.out.print("Enter Initial Balance: RS");
                    double initialBalance = sc.nextDouble();
                    BankAccount account = new BankAccount(accountNumber, accountHolder, initialBalance);
                    accounts.add(account);
                    System.out.println("Account created successfully.");
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    int depositAccountNumber = sc.nextInt();
                    System.out.print("Enter Deposit Amount: RS");
                    double depositAmount = sc.nextDouble();
                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber() == depositAccountNumber) {
                            acc.deposit(depositAmount);
                            System.out.println("Deposit successful.");
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    int withdrawAccountNumber = sc.nextInt();
                    System.out.print("Enter Withdraw Amount: RS");
                    double withdrawAmount = sc.nextDouble();
                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber() == withdrawAccountNumber) {
                            acc.withdraw(withdrawAmount);
                            System.out.println("Withdrawal successful.");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    int checkBalanceAccountNumber = sc.nextInt();
                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber() == checkBalanceAccountNumber) {
                            System.out.println("Balance: rs" + acc.getBalance());
                            break;
                        }
                    }
                    break;
                case 5:
                    System.out.print("Enter Account Number: ");
                    int displayAccountNumber = sc.nextInt();
                    for (BankAccount acc : accounts) {
                        if (acc.getAccountNumber() == displayAccountNumber) {
                            acc.displayAccountInfo();
                            break;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
