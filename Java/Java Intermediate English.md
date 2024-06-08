# Intermediate Java Programming Challenges :computer:

## Challenge 1: Bank Transaction Records :bank:
Develop a simple Java program to maintain a record of bank transactions, storing each transaction in a list.

### Input :inbox_tray:
- The program requests the initial balance of the account.
- Then, it requests the total number of transactions the customer wishes to perform.

### Output :outbox_tray:
- The `BankAccount` class contains methods to perform deposits and withdrawals, updating the account balance.
- The current balance is displayed after each transaction.
- If the withdrawal amount is greater than the available balance, print: "Insufficient balance. Withdrawal not performed."

### Examples :page_with_curl:
| Input | Output |
| ----- | ------ |
| 50<br>50<br>100 | Deposit made.<br>Balance current: 100.0<br>Withdrawal made.<br>Balance current: 0.0 |
| 90<br>90<br>12 | Deposit made.<br>Balance current: 180.0<br>Withdrawal made.<br>Balance current: 168.0 |

### Code :scroll:
```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankTransactionRecords {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the initial balance of the account from the user input
        double balance = scanner.nextDouble();

        // Read the total number of transactions from the user input
        int totalTransactions = scanner.nextInt();

        // List to store the transactions as strings
        List<String> transactions = new ArrayList<>();

        // Loop to iterate over each transaction
        for (int i = 1; i <= totalTransactions; i++) {
            // Read the transaction type ('D' for deposit, 'S' for withdrawal) and standardize it to uppercase
            char transactionType = scanner.next().toUpperCase().charAt(0);
            // Read the transaction amount from the user input
            double transactionAmount = scanner.nextDouble();

            // Update the account balance and add the transaction to the list
            if (transactionType == 'D') {
                balance += transactionAmount;
                transactions.add("Deposit of " + transactionAmount);
            } else if (transactionType == 'S') {
                balance -= transactionAmount;
                transactions.add("Withdrawal of " + transactionAmount);
            } else {
                // Handle invalid transaction type input
                System.out.println("Invalid option. Use 'D' for deposit or 'S' for withdrawal.");
                i--; // Decrement the index to repeat the iteration for this transaction
            }
        }

        // Display the final balance and the list of transactions
        System.out.printf("Balance: %.1f%n", balance);
        System.out.println("Transactions: ");
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println((i + 1) + ". " + transactions.get(i));
        }

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}
```
## Challenge 2: Bank Transaction Records with Stream API :zap:
Enhance the previous program to use Java's Stream API to process bank transactions more efficiently.

### Input :inbox_tray:
- The program requests the initial balance of the account.
- Then, it requests the total number of transactions the customer wishes to perform.

### Output :outbox_tray:
- Using the Stream API, the program stores each transaction, including a type (Deposit or Withdrawal) and a value.
- At the end of the transactions, it displays the final balance of the account and the list of transactions.

### Examples :page_with_curl:
| Input | Output |
| ----- | ------ |
| 100<br>2<br>D<br>10<br>S<br>20 | Balance: 90.0<br>Transactions:<br>D of 10.0<br>S of 20.0 |
| 5000<br>1<br>D<br>500 | Balance: 5500.0<br>Transactions:<br>D of 500.0 |

### Code :scroll:
```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TransactionRecordsWithStream {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the initial account balance
        double balance = scanner.nextDouble();
        // Read the total number of transactions
        int totalTransactions = scanner.nextInt();

        // List to store the transactions
        List<Transaction> transactions = new ArrayList<>();

        // Loop to process each transaction
        for (int i = 1; i <= totalTransactions; i++) {
            // Read the transaction type ('D' for deposit, 'S' for withdrawal)
            char transactionType = scanner.next().charAt(0);
            // Read the transaction value
            double transactionValue = scanner.nextDouble();

            // Create a new transaction and add it to the list
            Transaction transaction = new Transaction(transactionType, transactionValue);
            transactions.add(transaction);

            // Update the account balance based on the transaction type
            if (Character.toLowerCase(transaction.getType()) == 'd') {
                balance += transaction.getValue();
            } else if (Character.toLowerCase(transaction.getType()) == 's') {
                balance -= transaction.getValue();
            }
        }

        // Print the final account balance
        System.out.printf("\nBalance: " + balance);
        // Print the list of transactions
        System.out.println("\nTransactions:");
        String formattedTransactions = transactions.stream()
                .map(t -> String.format("%c of %.1f", t.getType(), t.getValue()))
                .collect(Collectors.joining("\n"));

        System.out.println(formattedTransactions);

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}

// Transaction class to represent a transaction
class Transaction {
    private char type;
    private double value;

    public Transaction(char type, double value) {
        this.type = type;
        this.value = value;
    }

    public char getType() {
        return type;
    }

    public double getValue() {
        return value;
    }
}
```
## Challenge 3: Bank Account with Constructor in OOP :moneybag:
Develop a simple Java program to represent a bank account using object-oriented programming (OOP), with a constructor for initializing the account with an initial balance.

### Input :inbox_tray:
- The program requests the initial balance of the account.
- Then, it requests the user to perform deposit and withdrawal transactions.

### Output :outbox_tray:
- The `BankAccount` class contains methods to perform deposits and withdrawals, updating the account balance.
- The current balance is displayed after each transaction.
- If the withdrawal amount is greater than the available balance, print: "Insufficient balance. Withdrawal not performed."

### Examples :ledger:
| Input | Output |
| ----- | ------ |
| 50<br>50<br>100 | Deposit made.<br>Balance current: 100.0<br>Withdrawal made.<br>Balance current: 0.0 |
| 90<br>90<br>12 | Deposit made.<br>Balance current: 180.0<br>Withdrawal made.<br>Balance current: 168.0 |

### Code :scroll:
```java
class BankAccount {
    private double balance; // The balance of the bank account

    // Constructor that initializes the bank account with an initial balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to deposit money into the bank account
    public void deposit(double amount) {
        // Increment the balance by the deposit amount and print a confirmation message
        this.balance += amount;
        System.out.println("Deposit made.");
      
        // Print the current balance
        printBalance();
    }

    // Method to withdraw money from the bank account
    public void withdraw(double amount) {
        // Check if the balance is sufficient for the withdrawal:
        // If yes, update the balance and print a confirmation message
        // If not, print an insufficient balance message
        if (this.balance >= amount) {
            this.balance -= amount;
            System.out.println("Withdrawal made.");
        } else {
            System.out.println("Insufficient balance. Withdrawal not performed.");
        }
        // Print the current balance
        printBalance();
    }
    
    // Private helper method to print the current balance
    private void printBalance() {
        System.out.printf("Current balance: %.1f\n", this.balance);
    }
}

//Class for testing, which was not necessary for the Challenge on DIO platform
public class BankAccountTest {
    public static void main(String[] args) {
        // Create a new BankAccount object with an initial balance of 100.0
        BankAccount account = new BankAccount(100.0);

        // Test deposit method
        account.deposit(50.0); // Deposit 50.0 into the account
        account.deposit(25.0); // Deposit 25.0 into the account

        // Test withdraw method
        account.withdraw(30.0); // Withdraw 30.0 from the account
        account.withdraw(150.0); // Attempt to withdraw 150.0 (should fail due to insufficient balance)

        // The output should reflect the transactions made and the final balance
    }
}

```
## Challenge 4: Banking Inheritance: Understanding Inheritance and Polymorphism :family:
After the success of the basic bank account opening system, the bank decided to expand its services to offer different types of accounts. Now, in addition to common bank accounts, they also offer savings accounts. Your task is to implement inheritance and polymorphism in the system, creating a "SavingsAccount" class that inherits from the previously created "BankAccount" class. The "SavingsAccount" class should add a new attribute, interest rate, in addition to the inherited attributes.

### Input :inbox_tray:
- The program requests information necessary to open a savings account, including account number, account holder's name, initial balance, and savings account interest rate.

### Output :outbox_tray:
- After receiving the savings account information, the program creates a "SavingsAccount" object and displays the account information, including account number, holder's name, current balance, and interest rate.

### Examples :ledger:
| Input | Output |
| ----- | ------ |
| Joao<br>123456<br>1000.0<br>1.5 | Savings Account:<br>Joao<br>123456<br>Balance: $1000.0<br>Interest rate: 1.5% |
| Ana<br>789012<br>2500.0<br>3.0 | Savings Account:<br>Ana<br>789012<br>Balance: $2500.0<br>Interest rate: 3.0% |
| Maria<br>987654<br>500.0<br>2.5 | Savings Account:<br>Maria<br>987654<br>Balance: $500.0<br>Interest rate: 2.5% |

### Code :scroll:
```java
import java.text.DecimalFormat;
import java.util.Scanner;

// Main class for the savings account challenge
public class Challenge {

    public static void main(String[] args) {
        // Reading input data:
        Scanner scanner = new Scanner(System.in);
        String accountHolder = scanner.next();
        int accountNumber = scanner.nextInt();
        double balance = scanner.nextDouble();
        double interestRate = scanner.nextDouble();

        // Creating a savings account object with the provided details
        SavingsAccount savingsAccount = new SavingsAccount(accountNumber, accountHolder, balance, interestRate);

        // Displaying savings account information
        System.out.println("Savings Account:");
        savingsAccount.displayInformation();
    }
}

// Base class for a bank account
class BankAccount {
    protected int number;
    protected String holder;
    protected double balance;

    // Constructor for bank account
    public BankAccount(int number, String holder, double balance) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
    }

    // Method to display account information
    public void displayInformation() {
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        System.out.println(holder);
        System.out.println(number);
        System.out.println("Balance: R$ " + decimalFormat.format(balance));
    }
}

// Derived class for a savings account
class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor for savings account
    public SavingsAccount(int number, String holder, double balance, double interestRate) {
        super(number, holder, balance);
        this.interestRate = interestRate;
    }

    // Overridden method to display savings account information including interest rate
    @Override
    public void displayInformation() {
        super.displayInformation();
        DecimalFormat decimalFormat = new DecimalFormat("#.0");
        System.out.println("Interest rate: " + decimalFormat.format(interestRate) + "%");
    }
}

```

## Challenge 5: Safe Vaults: Mastering Encapsulation and Abstraction :closed_lock_with_key:
You have been hired to develop a system of safe vaults. The goal is to create two types of vaults: a Digital Vault, which is opened by a password, and a Physical Vault, which is opened by a key.

### Input :key:
- The program will request the user to type the kind of vault to be created: "digital" or "physical". If "digital" is chosen, the program will request the vault's password and password confirmation (both numeric only). If "physical" is chosen, no further input is needed.

### Output :lock:
- The program will display the information of the created vault. For the Digital Vault, it will show the type and opening method (password). For the Physical Vault, it will show only the type and opening method (key).

### Examples :memo:
| Input | Output |
| ----- | ------ |
| digital<br>12345<br>1234 | Type: Digital Vault<br>Opening method: Password<br>Incorrect password! :x: |
| physical | Type: Physical Vault<br>Opening method: Key :old_key: |
| digital<br>2525<br>2525 | Type: Digital Vault<br>Opening method: Password<br>Vault opened! :white_check_mark: |

### Code :scroll:
```java
import java.util.Scanner;

// Abstract class representing a general safe
abstract class Safe {
    protected String type;
    protected String openingMethod;

    // Constructor for the safe
    public Safe(String type, String openingMethod) {
        this.type = type;
        this.openingMethod = openingMethod;
    }

    // Method to print information about the safe
    public void printInformation() {
        System.out.println("Type: " + this.type);
        System.out.println("Opening method: " + this.openingMethod);
    }
}

// Class representing a digital safe
class DigitalSafe extends Safe {

    private int password;

    // Constructor for the digital safe
    public DigitalSafe(int password) {
        super("Digital Safe", "Password");
        this.password = password;
    }

    // Method to validate the password
    public boolean validatePassword(int confirmPassword) {
        return confirmPassword == this.password;
    }
}

// Class representing a physical safe
class PhysicalSafe extends Safe {

    // Constructor for the physical safe
    public PhysicalSafe() {
        super("Physical Safe", "Key");
    }

}

// Main class for the safe challenge
public class Challenge {
    public static void main(String[] args) {
        // Read the type of safe from the input
        Scanner scanner = new Scanner(System.in);
        String safeType = scanner.nextLine();
        
        // Check the type of safe and proceed accordingly
        if (safeType.equalsIgnoreCase("digital")) {
            // Create a digital safe by requesting the password
            int password = scanner.nextInt();
            int confirmPassword = scanner.nextInt();
            // Create the digital safe
            DigitalSafe digitalSafe = new DigitalSafe(password);
            digitalSafe.printInformation();

            // Validate the password and respond
            if (digitalSafe.validatePassword(confirmPassword)) {
                System.out.println("Safe opened!");
            } else {
                System.out.println("Incorrect password!");
            }
            
        } else if (safeType.equalsIgnoreCase("physical")) {
            // Create a physical safe
            PhysicalSafe physicalSafe = new PhysicalSafe();
            physicalSafe.printInformation();
          
        } else {
            // Handle unknown safe type
            System.out.println("Unknown safe type!");
        }
    }
}

```
