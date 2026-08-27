import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully.");
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class ATMInterface {
    private BankAccount account;
    private Scanner input;

    public ATMInterface() {
        account = new BankAccount(10000);
        input = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;

        do {
            System.out.println("\n===== ATM INTERFACE =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = input.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = input.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);
    }

    public static void main(String[] args) {
        ATMInterface atm = new ATMInterface();
        atm.showMenu();
    }
}