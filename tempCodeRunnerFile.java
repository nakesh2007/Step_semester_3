import java.util.Scanner;

class Wallet {
    private String walletId;
    private String customerName;
    private double balance;

    Wallet(String walletId, String customerName, double balance) {
        this.walletId = walletId;
        this.customerName = customerName;
        this.balance = balance;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit Successful");
        } else {
            System.out.println("Invalid Deposit Amount");
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Withdrawal Amount");
        } else if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Successful");
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    void getBalance() {
        System.out.println("Final Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Wallet ID: ");
        String walletId = sc.nextLine();

        System.out.print("Enter Customer Name: ");
        String customerName = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        Wallet wallet = new Wallet(walletId, customerName, balance);

        System.out.print("Enter Deposit Amount: ");
        double depositAmount = sc.nextDouble();
        wallet.deposit(depositAmount);

        System.out.print("Enter Withdrawal Amount: ");
        double withdrawalAmount = sc.nextDouble();
        wallet.withdraw(withdrawalAmount);

        wallet.getBalance();

        sc.close();
    }
}