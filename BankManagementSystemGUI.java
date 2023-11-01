package quiz.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class AccountDetails {
    private String accountNumber;
    private String userName;
    private String age;
    private String aadhaarNumber;
    private String phoneNumber;
    private String balance;

    public AccountDetails(String accountNumber, String userName, String age, String aadhaarNumber, String phoneNumber, String balance) {
        this.accountNumber = accountNumber;
        this.userName = userName;
        this.age = age;
        this.aadhaarNumber = aadhaarNumber;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }

    // Getters and setters for account details

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getAge() {
        return age;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getBalance() {
        return balance;
    }

    void withdraw(double withdrawalAmount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void deposit(double depositAmount) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

class SavingsAccount extends AccountDetails {
    private String interestRate;

    public SavingsAccount(String accountNumber, String userName, String age, String aadhaarNumber, String phoneNumber, String balance, String interestRate) {
        super(accountNumber, userName, age, aadhaarNumber, phoneNumber, balance);
        this.interestRate = interestRate;
    }

    public String getInterestRate() {
        return interestRate;
    }
}

// Create a subclass for CurrentAccount
class CurrentAccount extends AccountDetails {
    private String overdraftLimit;

    public CurrentAccount(String accountNumber, String userName, String age, String aadhaarNumber, String phoneNumber, String balance, String overdraftLimit) {
        super(accountNumber, userName, age, aadhaarNumber, phoneNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public String getOverdraftLimit() {
        return overdraftLimit;
    }
}

public class BankManagementSystemGUI extends JFrame {
    private ArrayList<AccountDetails> accounts = new ArrayList<>();
    private JTextField accountNumberField, userNameField, ageField, aadhaarField, phoneNumberField, balanceField, actionAmountField;
    private JTextArea outputTextArea;

    public BankManagementSystemGUI() {
        setTitle("Bank Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        outputTextArea = new JTextArea();
        outputTextArea.setEditable(false);
        add(new JScrollPane(outputTextArea), BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridLayout(0, 2));
        add(inputPanel, BorderLayout.NORTH);

        inputPanel.add(new JLabel("Account Number: "));
        accountNumberField = new JTextField(10);
        inputPanel.add(accountNumberField);

        inputPanel.add(new JLabel("User Name: "));
        userNameField = new JTextField(10);
        inputPanel.add(userNameField);

        inputPanel.add(new JLabel("Age: "));
        ageField = new JTextField(10);
        inputPanel.add(ageField);

        inputPanel.add(new JLabel("Aadhaar Number: "));
        aadhaarField = new JTextField(10);
        inputPanel.add(aadhaarField);

        inputPanel.add(new JLabel("Phone Number: "));
        phoneNumberField = new JTextField(10);
        inputPanel.add(phoneNumberField);

        inputPanel.add(new JLabel("Initial Balance: "));
        balanceField = new JTextField(10);
        inputPanel.add(balanceField);

        inputPanel.add(new JLabel("Amount: "));
        actionAmountField = new JTextField(10);
        inputPanel.add(actionAmountField);

        // Create Account button
        JButton createAccountButton = new JButton("Create Account");
        inputPanel.add(createAccountButton);
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createAccount();
            }
        });

        // Delete Account button
        JButton deleteAccountButton = new JButton("Delete Account");
        inputPanel.add(deleteAccountButton);
        deleteAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteAccount();
            }
        });

        // Account Details button
        JButton accountDetailsButton = new JButton("Account Details");
        inputPanel.add(accountDetailsButton);
        accountDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayAccountDetails();
            }
        });

        // Withdraw button
        JButton withdrawButton = new JButton("Withdraw");
        inputPanel.add(withdrawButton);
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                withdraw();
            }
        });

        // Deposit button
        JButton depositButton = new JButton("Deposit");
        inputPanel.add(depositButton);
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deposit();
            }
        });

        // Balance Inquiry button
        JButton balanceInquiryButton = new JButton("Balance Inquiry");
        inputPanel.add(balanceInquiryButton);
        balanceInquiryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                balanceInquiry();
            }
        });

        // Transfer button
        JButton transferButton = new JButton("Transfer");
        inputPanel.add(transferButton);
        transferButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                transfer();
            }
        });
        // Create Savings Account button
        JButton createSavingsAccountButton = new JButton("Create Savings Account");
        inputPanel.add(createSavingsAccountButton);
        createSavingsAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createSavingsAccount();
            }
        });

        // Create Current Account button
        JButton createCurrentAccountButton = new JButton("Create Current Account");
        inputPanel.add(createCurrentAccountButton);
        createCurrentAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createCurrentAccount();
            }
        });
    }


    
    private void listAllAccounts() {
        outputTextArea.append("List of All Accounts:\n");
        for (AccountDetails account : accounts) {
            outputTextArea.append("Account Number: " + account.getAccountNumber() + "\n");
            outputTextArea.append("User Name: " + account.getUserName() + "\n");
            outputTextArea.append("Balance: " + account.getBalance() + "\n\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BankManagementSystemGUI().setVisible(true);
        });
    }
    private void deleteAccount() {
    String accountNumberToDelete = accountNumberField.getText();

    // Find the account by account number
    AccountDetails account = findAccount(accountNumberToDelete);

    if (account != null) {
        // Remove the account from the list
        accounts.remove(account);

        // Clear the input field
        accountNumberField.setText("");

        // Display a success message
        outputTextArea.append("Account " + accountNumberToDelete + " deleted successfully.\n");
    } else {
        // Display an error message
        outputTextArea.append("Account not found.\n");
    }
}

private void displayAccountDetails() {
    String accountNumberToDetails = accountNumberField.getText();

    // Find the account by account number
    AccountDetails account = findAccount(accountNumberToDetails);

    if (account != null) {
        // Display account details in the text area
        outputTextArea.append("Account Number: " + account.getAccountNumber() + "\n");
        outputTextArea.append("User Name: " + account.getUserName() + "\n");
        outputTextArea.append("Age: " + account.getAge() + "\n");
        outputTextArea.append("Aadhaar Number: " + account.getAadhaarNumber() + "\n");
        outputTextArea.append("Phone Number: " + account.getPhoneNumber() + "\n");
        outputTextArea.append("Balance: " + account.getBalance() + "\n");
    } else {
        // Display an error message
        outputTextArea.append("Account not found.\n");
    }
}

private void withdraw() {
    String accountNumberToWithdraw = accountNumberField.getText();
    String withdrawalAmountText = actionAmountField.getText();

    // Find the account by account number
    AccountDetails account = findAccount(accountNumberToWithdraw);

    if (account != null) {
        try {
            double withdrawalAmount = Double.parseDouble(withdrawalAmountText);

            if (account.getBalance() < withdrawalAmount) {
                // Insufficient funds
                outputTextArea.append("Insufficient funds.\n");
            } else {
                // Withdrawal successful
                account.withdraw(withdrawalAmount);

                // Display the new balance
                outputTextArea.append("Withdrawal successful. New balance: " + account.getBalance() + "\n");
            }
        } catch (NumberFormatException e) {
            // Invalid amount
            outputTextArea.append("Invalid withdrawal amount.\n");
        }
    } else {
        // Account not found
        outputTextArea.append("Account not found.\n");
    }
}

private void deposit() {
    String accountNumberToDeposit = accountNumberField.getText();
    String depositAmountText = actionAmountField.getText();

    // Find the account by account number
    AccountDetails account = findAccount(accountNumberToDeposit);

    if (account != null) {
        try {
            double depositAmount = Double.parseDouble(depositAmountText);

            // Deposit successful
            account.deposit(depositAmount);

            // Display the new balance
            outputTextArea.append("Deposit successful. New balance: " + account.getBalance() + "\n");
        } catch (NumberFormatException e) {
            // Invalid amount
            outputTextArea.append("Invalid deposit amount.\n");
        }
    } else {
        // Account not found
        outputTextArea.append("Account not found.\n");
    }
}

private void balanceInquiry() {
    String accountNumberToInquire = accountNumberField.getText();

    // Find the account by account number
    AccountDetails account = findAccount(accountNumberToInquire);

    if (account != null) {
        // Display account number and balance
        outputTextArea.append("Account Number: " + account.getAccountNumber() + "\n");
        outputTextArea.append("Balance: " + account.getBalance() + "\n");
    } else {
        // Account not found
        outputTextArea.append("Account not found.\n");
    }
}


// Helper method to find an account by account number
private AccountDetails findAccount(String accountNumber) {
    for (AccountDetails account : accounts) {
        if (account.getAccountNumber().equals(accountNumber)) {
            return account;
        }
    }
    return null;
}
void withdraw(double withdrawalAmount) {
        try {
            String balance = null;
            double amount = Double.parseDouble(balance);
            if (amount >= withdrawalAmount) {
                amount -= withdrawalAmount;
                balance = String.valueOf(amount);
            } else {
                // Insufficient funds
                System.out.println("Insufficient funds.");
            }
        } catch (NumberFormatException e) {
            // Invalid amount
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Implement the deposit method
    void deposit(double depositAmount) {
        try {
            String balance = null;
            double amount = Double.parseDouble(balance);
            amount += depositAmount;
            balance = String.valueOf(amount);
        } catch (NumberFormatException e) {
            // Invalid amount
            System.out.println("Invalid deposit amount.");
        }
    }
      private void createAccount() {
        String accountNumber = accountNumberField.getText();
        String userName = userNameField.getText();
        String age = ageField.getText();
        String aadhaarNumber = aadhaarField.getText();
        String phoneNumber = phoneNumberField.getText();
        String initialBalance = balanceField.getText();

        try {
            double initialBalanceAmount = Double.parseDouble(initialBalance);

            // Create a new account and add it to the list
            AccountDetails account = new AccountDetails(accountNumber, userName, age, aadhaarNumber, phoneNumber, String.valueOf(initialBalanceAmount));
            accounts.add(account);

            // Clear the input fields
            accountNumberField.setText("");
            userNameField.setText("");
            ageField.setText("");
            aadhaarField.setText("");
            phoneNumberField.setText("");
            balanceField.setText("");

            // Display a success message
            outputTextArea.append("Account created successfully.\n");
        } catch (NumberFormatException e) {
            // Handle invalid initial balance
            outputTextArea.append("Invalid initial balance.\n");
        }
    }

    private void createSavingsAccount() {
        String accountNumber = accountNumberField.getText();
        String userName = userNameField.getText();
        String age = ageField.getText();
        String aadhaarNumber = aadhaarField.getText();
        String phoneNumber = phoneNumberField.getText();
        String initialBalance = balanceField.getText();

        String interestRate = actionAmountField.getText();

        try {
            double initialBalanceAmount = Double.parseDouble(initialBalance);
            double interestRateAmount = Double.parseDouble(interestRate);

            // Create a new savings account and add it to the list
            SavingsAccount savingsAccount = new SavingsAccount(accountNumber, userName, age, aadhaarNumber, phoneNumber, String.valueOf(initialBalanceAmount), String.valueOf(interestRateAmount));
            accounts.add(savingsAccount);

            // Clear the input fields
            accountNumberField.setText("");
            userNameField.setText("");
            ageField.setText("");
            aadhaarField.setText("");
            phoneNumberField.setText("");
            balanceField.setText("");
            actionAmountField.setText("");

            // Display a success message
            outputTextArea.append("Savings account created successfully.\n");
        } catch (NumberFormatException e) {
            // Handle invalid initial balance or interest rate
            outputTextArea.append("Invalid initial balance or interest rate.\n");
        }
    }

    private void createCurrentAccount() {
        String accountNumber = accountNumberField.getText();
        String userName = userNameField.getText();
        String age = ageField.getText();
        String aadhaarNumber = aadhaarField.getText();
        String phoneNumber = phoneNumberField.getText();
        String initialBalance = balanceField.getText();

        String overdraftLimit = actionAmountField.getText();

        try {
            double initialBalanceAmount = Double.parseDouble(initialBalance);
            double overdraftLimitAmount = Double.parseDouble(overdraftLimit);

            // Create a new current account and add it to the list
            CurrentAccount currentAccount = new CurrentAccount(accountNumber, userName, age, aadhaarNumber, phoneNumber, String.valueOf(initialBalanceAmount), String.valueOf(overdraftLimitAmount));
            accounts.add(currentAccount);

            // Clear the input fields
            accountNumberField.setText("");
            userNameField.setText("");
            ageField.setText("");
            aadhaarField.setText("");
            phoneNumberField.setText("");
            balanceField.setText("");
            actionAmountField.setText("");

            // Display a success message
            outputTextArea.append("Current account created successfully.\n");
        } catch (NumberFormatException e) {
            // Handle invalid initial balance or overdraft limit
            outputTextArea.append("Invalid initial balance or overdraft limit.\n");
        }
    }

    private void transfer() {
        String sourceAccountNumberText = accountNumberField.getText();
        String destinationAccountNumberText = actionAmountField.getText();

        // Find the source and destination accounts by account number
        AccountDetails sourceAccount = findAccount(sourceAccountNumberText);
        AccountDetails destinationAccount = findAccount(destinationAccountNumberText);

        if (sourceAccount != null && destinationAccount != null) {
            try {
                double transferAmount = Double.parseDouble(actionAmountField.getText());

                // Check if source account has sufficient balance
                double sourceBalance = Double.parseDouble(sourceAccount.getBalance());

                if (sourceBalance >= transferAmount) {
                    // Perform the transfer
                    sourceAccount.withdraw(transferAmount);
                    destinationAccount.deposit(transferAmount);

                    // Display success message
                    outputTextArea.append("Transfer successful.\n");
                } else {
                    // Insufficient funds in the source account
                    outputTextArea.append("Insufficient funds in the source account.\n");
                }
            } catch (NumberFormatException e) {
                // Handle invalid transfer amount
                outputTextArea.append("Invalid transfer amount.\n");
            }
        } else {
            // Source or destination account not found
            outputTextArea.append("Source or destination account not found.\n");
        } 
    }
}