
import java.util.*;

class Student {
    String roll, name;

    Student(String roll, String name) {
        this.roll = roll;
        this.name = name;
    }
}

public class ClubRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<String[]> operations = new ArrayList<>();

        while (sc.hasNext()) {
            String op = sc.next();
            String roll = sc.next();
            String name = sc.next();

            operations.add(new String[]{op, roll, name});
        }

        for (String[] o : operations) {
            if (o[0].equals("ADD")) {
                boolean found = false;

                for (Student s : students) {
                    if (s.roll.equals(o[1])) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    System.out.println("duplicate rejected");
                } else {
                    students.add(new Student(o[1], o[2]));
                    System.out.println("Added");
                }
            }
        }

        System.out.println("member count " + students.size());

        for (String[] o : operations) {
            if (o[0].equals("CONTAINS")) {
                boolean found = false;

                for (Student s : students) {
                    if (s.roll.equals(o[1])) {
                        found = true;
                        break;
                    }
                }

                System.out.println("contains: " + found);
            }
        }

        sc.close();
    }
}
