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
    public static String balance;

    public AccountDetails(String accountNumber, String userName, String age, String aadhaarNumber, String phoneNumber, String balance) {
        this.accountNumber = accountNumber;
        this.userName = userName;
        this.age = age;
        this.aadhaarNumber = aadhaarNumber;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }


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
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    void deposit(double depositAmount) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

// Create a subclass for SavingsAccount
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

        // Clear the input
        accountNumberField.setText("");

      
        outputTextArea.append("Account " + accountNumberToDelete + " deleted successfully.\n");
    } else {
        
        outputTextArea.append("Account not found.\n");
    }
}

private void displayAccountDetails() {
    String accountNumberToDetails = accountNumberField.getText();

    // Find the account by account number
    AccountDetails account = findAccount(accountNumberToDetails);

    if (account != null) {
        // Display account details 
        outputTextArea.append("Account Number: " + account.getAccountNumber() + "\n");
        outputTextArea.append("User Name: " + account.getUserName() + "\n");
        outputTextArea.append("Age: " + account.getAge() + "\n");
        outputTextArea.append("Aadhaar Number: " + account.getAadhaarNumber() + "\n");
        outputTextArea.append("Phone Number: " + account.getPhoneNumber() + "\n");
        outputTextArea.append("Balance: " + account.getBalance() + "\n");
    } else {
        
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
        outputTextArea.append("Account not found.\n");
    }
}

//  method to find an account by account number
private AccountDetails findAccount(String accountNumber) {
    for (AccountDetails account : accounts) {
        if (account.getAccountNumber().equals(accountNumber)) {
            return account;
        }
    }
    return null;
}
void withdraw() {
    try {
        double withdrawalAmount = Double.parseDouble(actionAmountField.getText());
        double currentBalance = Double.parseDouble(AccountDetails.balance);

        if (currentBalance >= withdrawalAmount) {
            currentBalance -= withdrawalAmount;
            AccountDetails.balance = String.valueOf(currentBalance);
            outputTextArea.append("Withdrawal successful. New balance: " + AccountDetails.balance + "\n");
        } else {
          
            outputTextArea.append("Insufficient funds.\n");
        }
    } catch (NumberFormatException e) {
    
        outputTextArea.append("Invalid withdrawal amount.\n");
    }
}

void deposit() {
    try {
        double depositAmount = Double.parseDouble(actionAmountField.getText());
        double currentBalance = Double.parseDouble(AccountDetails.balance);

        currentBalance += depositAmount;
        AccountDetails.balance = String.valueOf(currentBalance);
        outputTextArea.append("Deposit successful. New balance: " + AccountDetails.balance + "\n");
    } catch (NumberFormatException e) {
     
        outputTextArea.append("Invalid deposit amount.\n");
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

            // Clear the input 
            accountNumberField.setText("");
            userNameField.setText("");
            ageField.setText("");
            aadhaarField.setText("");
            phoneNumberField.setText("");
            balanceField.setText("");

            outputTextArea.append("Account created successfully.\n");
        } catch (NumberFormatException e) {
            
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

            // Clear the input 
            accountNumberField.setText("");
            userNameField.setText("");
            ageField.setText("");
            aadhaarField.setText("");
            phoneNumberField.setText("");
            balanceField.setText("");
            actionAmountField.setText("");

            outputTextArea.append("Savings account created successfully.\n");
        } catch (NumberFormatException e) {
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

            // Clear the input 
            accountNumberField.setText("");
            userNameField.setText("");
            ageField.setText("");
            aadhaarField.setText("");
            phoneNumberField.setText("");
            balanceField.setText("");
            actionAmountField.setText("");

            outputTextArea.append("Current account created successfully.\n");
        } catch (NumberFormatException e) {
            outputTextArea.append("Invalid initial balance or overdraft limit.\n");
        }
    }
}
