
import java.util.*;

class Vehicle {
    String type, pass, owner;
    int fee;
    boolean electric;

    Vehicle(String type, String pass, String owner) {
        this.type = type;
        this.pass = pass;
        this.owner = owner;

        if (type.equals("Bike") || type.equals("EBike")
                || type.equals("E-Bike"))
            fee = 300;
        else
            fee = 1000;

        electric = type.equals("EBike") || type.equals("E-Bike")
                || type.equals("ECar") || type.equals("E-Car");
    }
}

public class VehiclePass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Vehicle> list = new ArrayList<>();

        while (sc.hasNext()) {
            String op = sc.next();

            if (op.equals("PASS")) {
                String type = sc.next();
                String pass = sc.next();
                String owner = sc.next();

                Vehicle v = new Vehicle(type, pass, owner);
                list.add(v);

                System.out.println(v.pass + " (" + v.type
                        + ") pass fee " + v.fee);

            } else if (op.equals("CHARGE")) {
                String pass = sc.next();
                boolean found = false;

                for (Vehicle v : list) {
                    if (v.pass.equals(pass)) {
                        if (v.electric)
                            System.out.println(pass
                                    + " charging bay allotted");
                        else
                            System.out.println(pass
                                    + " rejected: charging unsupported");

                        found = true;
                        break;
                    }
                }

                if (!found)
                    System.out.println("Vehicle not found");
            }
        }

        sc.close();
    }
}
