// Class to represent the user's bank account
class BankAccount {
     private double balance;
 
     // Constructor
     public BankAccount(double initialBalance) {
         this.balance = initialBalance;
     }
 
     // Method to get the account balance
     public double getBalance() {
         return balance;
     }
 
     // Method to deposit money
     public void deposit(double amount) {
         if (amount > 0) {
             balance += amount;
             System.out.println("Successfully deposited: $" + amount);
         } else {
             System.out.println("Invalid deposit amount.");
         }
     }
 
     // Method to withdraw money
     public boolean withdraw(double amount) {
         if (amount > 0 && amount <= balance) {
             balance -= amount;
             System.out.println("Successfully withdrawn: $" + amount);
             return true;
         } else if (amount > balance) {
             System.out.println("Insufficient balance.");
         } else {
             System.out.println("Invalid withdrawal amount.");
         }
         return false;
     }
 }
 
 // Class to represent the ATM machine
 class ATM {
     private BankAccount account;
 
     // Constructor
     public ATM(BankAccount account) {
         this.account = account;
     }
 
     // Method to display ATM menu
     public void displayMenu() {
         System.out.println("\nWelcome to the ATM");
         System.out.println("1. Check Balance");
         System.out.println("2. Deposit Money");
         System.out.println("3. Withdraw Money");
         System.out.println("4. Exit");
         System.out.print("Enter your choice: ");
     }
 
     // Method to handle user choices
     public void handleUserChoice(int choice) {
         java.util.Scanner scanner = new java.util.Scanner(System.in);
 
         switch (choice) {
             case 1:
                 System.out.println("Your current balance is: $" + account.getBalance());
                 break;
 
             case 2:
                 System.out.print("Enter the amount to deposit: ");
                 double depositAmount = scanner.nextDouble();
                 account.deposit(depositAmount);
                 break;
 
             case 3:
                 System.out.print("Enter the amount to withdraw: ");
                 double withdrawAmount = scanner.nextDouble();
                 account.withdraw(withdrawAmount);
                 break;
 
             case 4:
                 System.out.println("Thank you for using the ATM. Goodbye!");
                 System.exit(0);
                 break;
 
             default:
                 System.out.println("Invalid choice. Please try again.");
         }
     }
 }
 
 // Main class to test the ATM system
 public class Task3 {
     public static void main(String[] args) {
         java.util.Scanner scanner = new java.util.Scanner(System.in);
 
         // Initialize the user's bank account with an initial balance
         BankAccount userAccount = new BankAccount(1000); // Initial balance $1000
 
         // Create an ATM instance
         ATM atm = new ATM(userAccount);
 
         while (true) {
             atm.displayMenu();
             int choice = scanner.nextInt();
             atm.handleUserChoice(choice);
         }
     }
 }
 