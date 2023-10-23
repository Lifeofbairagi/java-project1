import java.util.ArrayList;
import java.util.Scanner;

class AccountDetails {
    private long phoneNumber;
    private static int accountNumberCounter = 10000;
    private int accountNumber;
    private String userName;
    private int age;
    private int pin;
    private long adhaarNumber;
    private double balance;

    public AccountDetails(String userName, int age, int pin, long adhaarNumber, double initialBalance) {
        this.phoneNumber = phoneNumber;
        this.accountNumber = accountNumberCounter++;
        this.userName = userName;
        this.age = age;
        this.pin = pin;
        this.adhaarNumber = adhaarNumber;
        this.balance = initialBalance;
    }
     public long getphoneNumber() {
        return phoneNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    public int getPin() {
        return pin;
    }

    public long getAdhaarNumber() {
        return adhaarNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("User Name: " + userName);
        System.out.println("Age: " + age);
        System.out.println("Adhaar Number: " + adhaarNumber);
        System.out.println("Balance: " + balance);
        System.out.println("phone: " + phoneNumber);
    }
}

public class Main {
    private static ArrayList<AccountDetails> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Bank Management System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Delete Account");
            System.out.println("3. Account Details");
            System.out.println("4. Withdraw");
            System.out.println("5. Deposit");
            System.out.println("6. Balance Inquiry");
            System.out.println("7. Transfer");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deleteAccount();
                    break;
                case 3:
                    accountDetails();
                    break;
                case 4:
                    withdraw();
                    break;
                case 5:
                    deposit();
                    break;
                case 6:
                    balanceInquiry();
                    break;
                case 7:
                    transfer();
                    break;
                case 8:
                    System.out.println("Exiting Bank Management System. Have a great day!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter User Name: "
        );
        String userName = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();
        System.out.print("Enter Aadhaar Number: ");
        long adhaarNumber = scanner.nextLong();
        System.out.print("Enter phone number: ");
        long phoneNumber = scanner.nextLong();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();
        AccountDetails account = new AccountDetails(userName, age, pin, adhaarNumber, initialBalance);
        accounts.add(account);
        System.out.println("Account created successfully. Account number: " + account.getAccountNumber());
    }

    private static void deleteAccount() {
        System.out.print("Enter Account Number to Delete: ");
        int accountNumberToDelete = scanner.nextInt();
        AccountDetails account = findAccount(accountNumberToDelete);
        if (account != null) {
            accounts.remove(account);
            System.out.println("Account " + accountNumberToDelete + " deleted successfully.");
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void accountDetails() {
        System.out.print("Enter Account Number for Details: ");
        int accountNumberToDetails = scanner.nextInt();
        AccountDetails account = findAccount(accountNumberToDetails);
        if (account != null) {
            account.displayAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw() {
        System.out.print("Enter Account Number for Withdrawal: ");
        int accountNumberToWithdraw = scanner.nextInt();
        System.out.print("Enter Withdrawal Amount: ");
        double withdrawalAmount = scanner.nextDouble();
        AccountDetails account = findAccount(accountNumberToWithdraw);
        if (account != null) {
            if (account.getBalance() >= withdrawalAmount) {
                account.withdraw(withdrawalAmount);
                System.out.println("Withdrawal successful. New balance: " + account.getBalance());
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void deposit() {
        System.out.print("Enter Account Number for Deposit: ");
        int accountNumberToDeposit = scanner.nextInt();
        System.out.print("Enter Deposit Amount: ");
        double depositAmount = scanner.nextDouble();
        AccountDetails account = findAccount(accountNumberToDeposit);
        if (account != null) {
            account.deposit(depositAmount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void balanceInquiry() {
        System.out.print("Enter Account Number for Balance Inquiry: ");
        int accountNumberToInquire = scanner.nextInt();
        AccountDetails account = findAccount(accountNumberToInquire);
        if (account != null) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void transfer() {
        System.out.print("Enter Source Account Number: ");
        int sourceAccountNumber = scanner.nextInt();
        System.out.print("Enter Destination Account Number: ");
        int destinationAccountNumber = scanner.nextInt();
        AccountDetails sourceAccount = findAccount(sourceAccountNumber);
        AccountDetails destinationAccount = findAccount(destinationAccountNumber);

        if (sourceAccount == null || destinationAccount == null) {
            System.out.println("Source or destination account not found.");
            return;
        }

        System.out.print("Enter Transfer Amount: ");
        double transferAmount = scanner.nextDouble();
        if (sourceAccount.getBalance() >= transferAmount) {
            sourceAccount.withdraw(transferAmount);
            destinationAccount.deposit(transferAmount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient funds for the transfer.");
        }
    }

    private static AccountDetails findAccount(int accountNumber) {
        for (AccountDetails account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}

