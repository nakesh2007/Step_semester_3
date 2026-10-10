
import java.util.*;

class Account {
    String type, id;
    int balance;

    Account(String type, String id, int balance) {
        this.type = type;
        this.id = id;
        this.balance = balance;
    }

    void withdraw(int amount) {
        if (type.equals("Savings") && balance - amount < 1000) {
            System.out.println(id + " rejected: minimum balance 1000");
        } else if (type.equals("Current") && balance - amount < -5000) {
            System.out.println(id + " rejected: overdraft limit 5000");
        } else {
            balance -= amount;
            System.out.println(id + " balance " + balance);
        }
    }
}

public class BankAccount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();

        while (sc.hasNext()) {
            String op = sc.next();

            if (op.equals("Savings") || op.equals("Current")) {
                String id = sc.next();
                int balance = sc.nextInt();
                accounts.add(new Account(op, id, balance));
            } else if (op.equals("WITHDRAW")) {
                String id = sc.next();
                int amount = sc.nextInt();
                boolean found = false;

                for (Account a : accounts) {
                    if (a.id.equals(id)) {
                        a.withdraw(amount);
                        found = true;
                        break;
                    }
                }

                if (!found)
                    System.out.println("Account not found");
            }
        }

        sc.close();
    }
}
