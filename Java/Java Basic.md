# Basic Java Programming Challenges :coffee:

## 1: Simple Banking Operations with `switch` :money_with_wings:

### Description ✍️
Simulation of basic banking operations such as deposits, withdrawals, and balance inquiries in a virtual bank account.

### Input ⬇️:
- The program displays a menu with the following options:
  1. Deposit
  2. Withdraw
  3. Check Balance
  4. End
- The user chooses an option by typing the corresponding number.

### Output ⬆️:
- Using `switch`, the program executes the chosen operation.
- **Deposit**: Requests the amount and updates the balance.
- **Withdraw**: Checks if there is enough balance.
- **Check Balance**: Displays the current balance.
- **End**: Terminates the program execution.

### Examples :clipboard:
| Input | Output |
| ----- | ------ |
| 1<br>50<br>2<br>100<br>0 | Current balance: 50.0<br>Insufficient balance.<br>Program ended. |
| 3<br>1<br>550<br>0 | Current balance: 0.0<br>Current balance: 550.0<br>Program ended. |
| 1<br>1000<br>2<br>500<br>0 | Current balance: 1000.0<br>Current balance: 500.0<br>Program ended. |

### Code :scroll:
```java
import java.util.Scanner;

public class BankingSimulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double balance = 0;
        boolean continueOperation = true;

        while (continueOperation) {
            // Request option from user
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Read the deposit amount and update/print the balance.
                    System.out.println();
                    double deposit = scanner.nextDouble();
                    balance += deposit;
                    System.out.printf("Current balance: %.1f%n", balance);
                    break;
                case 2:
                    // Read the withdrawal amount and check/print if there is enough balance.
                    System.out.println();
                    double withdrawal = scanner.nextDouble();
                    if (withdrawal <= balance) {
                        balance -= withdrawal;
                        System.out.printf("Current balance: %.1f%n", balance);
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 3:
                    // Display the current balance of the account.
                    System.out.printf("Current balance: %.1f%n", balance);
                    break;
                case 0:
                    // End the program.
                    System.out.println("Program ended.");
                    continueOperation = false;  // Update the control variable to end the loop
                    break;
                default:
                    // Invalid option.
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
```
## 2: Bank Account Number Verification Challenge 🏦

### Description ✍️
Verify the validity of a bank account number, which must have exactly 8 digits.

### Input ⬇️
- The program requests the bank account number.

### Output ⬆️
- Uses `try-catch` to validate the account number.
- Informs whether the number is valid or invalid.

### Examples 📋
| Input     | Output |
| --------- | ------ |
| 01020304  | Valid account number. |
| 1234568   | Error: Invalid account number. Please enter exactly 8 digits. |
| 3231      | Error: Invalid account number. Please enter exactly 8 digits. |

### Code :scroll:
```java
import java.util.Scanner;

public class AccountNumberVerifier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt for the account number
            System.out.print("Enter your account number: ");
            String accountNumber = scanner.nextLine();

            // Call the method to verify if the account number is valid
            verifyAccountNumber(accountNumber);

            // If no exception is thrown, print the success message
            System.out.println("Valid account number. ✅");
        } catch (IllegalArgumentException e) {
            // Inform that the account number is invalid and display the error message
            System.out.println("Error: " + e.getMessage() + " ❌");
        } finally {
            // Close the scanner to prevent resource leaks
            scanner.close();
        }
    }

    // Method to verify if the account number has exactly 8 digits
    private static void verifyAccountNumber(String accountNumber) {
        if (accountNumber.length() != 8) {
            // Throw an IllegalArgumentException with the appropriate message
            throw new IllegalArgumentException("Invalid account number. Please enter exactly 8 digits.");
        }
        // Additional check for non-digit characters
        if (!accountNumber.matches("\\d{8}")) {
            throw new IllegalArgumentException("Invalid account number. It must contain only digits.");
        }
    }
}
```
## 3: Bank Account Age Verification Challenge 🎂

### Description ✍️
Verify whether a client is eligible to create a bank account based on their age, which must be at least 18 years old.

### Input ⬇️
- The program requests the user to enter their age.

### Output ⬆️
- Using `if-else`, the program checks if the age is 18 or older.
- **Eligible**: Informs that the client can create a bank account.
- **Not Eligible**: Informs that the client cannot create a bank account.

### Examples 📋
| Input | Output |
| ----- | ------ |
| 17    | You are not eligible to create a bank account. |
| 26    | You are eligible to create a bank account. |
| 18    | You are eligible to create a bank account. |

### Code 📜
```java
import java.util.Scanner;

public class BankAccountAgeVerifier {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for their age
        System.out.print("Please enter your age: ");
        int age = scanner.nextInt();

        // Check if the client is 18 or older
        if (age >= 18) {
            // If eligible, print the confirmation message
            System.out.println("You are eligible to create a bank account.");
        } else {
            // If not eligible, print the denial message
            System.out.println("You are not eligible to create a bank account.");
        }

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}
```

## 4: Overdraft Verification Challenge 💰

### Description ✍️
Develop a Java program to check if a bank account has exceeded the overdraft limit after making a withdrawal.

### Input ⬇️
- Current bank account balance.
- Desired withdrawal amount by the client.

### Output ⬆️
- The program checks if the withdrawal exceeds the available balance.
- If the withdrawal does not exceed the balance, it informs that the transaction was successful.
- If the withdrawal exceeds the balance but not the overdraft limit (500 monetary units), it informs that the transaction was successful using the overdraft.
- If the withdrawal exceeds the overdraft limit, it informs that the transaction cannot be performed.

### Examples 📋
| Input       | Output |
| ----------- | ------ |
| 1000<br>100 | Transaction successful. |
| 2500<br>2750| Transaction successful using overdraft. |
| 300<br>1500 | Transaction not performed. Overdraft limit exceeded. |

### Code 📜
```java
import java.util.Scanner;

public class OverdraftChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for the current balance and withdrawal amount
        System.out.print("Enter your current balance: ");
        double balance = scanner.nextDouble();
        System.out.print("Enter the withdrawal amount: ");
        double withdrawal = scanner.nextDouble();

        // Define the overdraft limit
        double overdraftLimit = 500;
        // Calculate the total available balance including overdraft
        double totalAvailable = overdraftLimit + balance;

        // Check if the withdrawal exceeds the balance
        if (withdrawal <= balance) {
            // If within balance, confirm the successful transaction
            System.out.println("Transaction successful.");
        } else if (withdrawal <= totalAvailable) {
            // If within overdraft limit, confirm the successful transaction with overdraft
            System.out.println("Transaction successful using overdraft.");
        } else {
            // If exceeding overdraft limit, deny the transaction
            System.out.println("Transaction not performed. Overdraft limit exceeded.");
        }

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}
```
## 5: Daily Withdrawal Limit Control Challenge 🚫

### Description ✍️
A Java program to assist a client in making withdrawals from a bank account, respecting a predefined daily limit.

### Input ⬇️
- Daily withdrawal limit.
- Amount of the first withdrawal.

### Output ⬆️
- The program iterates over the withdrawals and checks if the value exceeds the daily limit.
- If the withdrawal amount exceeds the limit, it informs that the limit has been reached and ends the loop.
- If the withdrawal amount does not exceed the limit, it informs that the withdrawal was successful and updates the remaining limit.

### Examples 📋
| Input          | Output |
| -------------- | ------ |
| 1500<br>430<br>0 | Withdrawal successful. Remaining limit: 1070.0<br>Transactions ended. |
| 500<br>1500    | Daily withdrawal limit reached. Transactions ended. |
| 80<br>40<br>0  | Withdrawal successful. Remaining limit: 40.0<br>Transactions ended. |

### Code 📜
```java
import java.util.Scanner;

public class DailyWithdrawalLimitController {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Request the daily withdrawal limit
        System.out.print("Enter the daily withdrawal limit: ");
        double dailyLimit = scanner.nextDouble();

        // Loop to handle multiple withdrawal attempts
        while (true) {

            // Ask for the withdrawal amount or 0 to end
            System.out.print("Enter the withdrawal amount (or 0 to end): ");
            double withdrawalAmount = scanner.nextDouble();

            // Check if the user wants to end the transactions
            if (withdrawalAmount == 0) {
                // Confirm the end of transactions
                System.out.println("Transactions ended.");
                break;
            } else if (withdrawalAmount > dailyLimit) {
                // If the withdrawal exceeds the limit, deny the transaction
                System.out.println("Daily withdrawal limit reached. Transactions ended.");
                break;
            } else {
                // If within the limit, proceed with the withdrawal and update the remaining limit
                dailyLimit -= withdrawalAmount;
                System.out.printf("Withdrawal successful. Remaining limit: %.1f%n", dailyLimit);
            }
        }
        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}
```
