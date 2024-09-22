
import java.util.ArrayList;
import java.util.Scanner;

public class octanetATM  {

    private static int balance = 1000; 
    private static int pin = 7181;
    
    private static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome");

        while (true) {
            System.out.print(" enter your PIN: ");
            int enteredPin = scanner.nextInt();

            if (enteredPin == pin) {
                showMenu(scanner);
            } else {
                System.out.println("Incorrect PIN.  try again.");
            }
        }
    }

    private static void showMenu(Scanner scanner) {
        System.out.println("\nATM Menu:");
        System.out.println("1. Withdraw money ");
        System.out.println("2. Deposit money");
        System.out.println("3. Check  your Balance");
        System.out.println("4. Change your  PIN");
        System.out.println("5. View Transaction History");
        System.out.println("6. Exit");

        System.out.print("Please select an option: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                withdraw(scanner);
                break;
            case 2:
                deposit(scanner);
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                changePin(scanner);
                break;
            case 5:
                viewTransactionHistory();
                break;
            case 6:
                System.out.println("Transaction Completed!");
                System.exit(0);
            default:
                System.out.println("Invalid. Try Again");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        int amount = scanner.nextInt();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawal: -" + amount);
            System.out.println(" Successful. Remaining Balance: " + balance);
        } else {
            System.out.println(" invalid amount. Try Again!");
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        int amount = scanner.nextInt();

        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposit: +" + amount);
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: " + balance);
    }

    private static void changePin(Scanner scanner) {
        System.out.print("Enter new PIN: ");
        int newPin = scanner.nextInt();

        pin = newPin;
        System.out.println("PIN changed successfully.");
    }

    private static void viewTransactionHistory() {
        System.out.println("Transaction History:");
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}