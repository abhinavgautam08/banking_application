import java.util.Scanner;
import java.util.InputMismatchException;


class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private String email;
    private String phoneNumber;

    public Account(int accountNumber, String accountHolderName, double initialDeposit,
                   String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! Current balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! Current balance: " + balance);
        }
    }
    public void displayAccountDetails() {
        System.out.println("\n=== Account Details ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
    }
    public void updateContactDetails(String email, String phoneNumber) {
        if (isValidEmail(email) && isValidPhone(phoneNumber)) {
            this.email = email;
            this.phoneNumber = phoneNumber;
            System.out.println("Contact details updated successfully.");
        } else {
            System.out.println("Invalid email or phone number format.");
        }
    }
    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }
    private boolean isValidPhone(String phone) {
        return phone.matches("\\d{10}");
    }
    public class Main {
    // Data storage
    private static Account[] accounts = new Account[100];
    private static int accountCount = 0;
    private static int nextAccountNumber = 1001;
    private static Scanner sc = new Scanner(System.in);

    // Entry point
    public static void main(String[] args) {
        System.out.println("Welcome to the Banking Application!");
        mainMenu();
    }
}