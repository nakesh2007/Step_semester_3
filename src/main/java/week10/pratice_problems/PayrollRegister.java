
import java.util.*;

class Payslip {
    String name, type;
    int pay;

    Payslip(String name, String type, int pay) {
        this.name = name;
        this.type = type;
        this.pay = pay;
    }

    public String toString() {
        return "Payslip[name=" + name + ", type=" + type
                + ", pay=" + pay + "]";
    }
}

public class PayrollRegister {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Payslip> list = new ArrayList<>();

        int total = 0;
        int top = 0;

        while (sc.hasNext()) {
            String type = sc.next();
            String name = sc.next();
            int pay;

            if (type.equals("FullTime")) {
                pay = sc.nextInt();
            } else if (type.equals("PartTime")) {
                int hours = sc.nextInt();
                int rate = sc.nextInt();
                pay = hours * rate;
            } else if (type.equals("Intern")) {
                pay = sc.nextInt();
            } else {
                continue;
            }

            list.add(new Payslip(name, type, pay));
        }

        for (int i = 0; i < list.size(); i++) {
            Payslip p = list.get(i);
            System.out.println(p);

            total += p.pay;

            if (p.pay > list.get(top).pay)
                top = i;
        }

        System.out.println("Total " + total);

        if (!list.isEmpty())
            System.out.println("top earner " + list.get(top).name);

        sc.close();
    }
}
