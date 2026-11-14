import java.util.*;

public class SectionTimetables {

    static class Timetable {

        String name;
        List<String> periods;

        Timetable(String name, List<String> periods) {
            this.name = name;
            this.periods = new ArrayList<>(periods);
        }

        Timetable copy(String newName) {

            return new Timetable(newName,
                                 new ArrayList<>(periods));
        }

        void setPeriod(int period, String subject) {

            periods.set(period - 1, subject);
        }

        void display() {

            System.out.println(name + ": " + periods);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String originalName = sc.nextLine();

        int n = sc.nextInt();
        sc.nextLine();

        List<String> subjects = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            subjects.add(sc.nextLine());
        }

        Timetable original = new Timetable(originalName, subjects);

        String newName = sc.nextLine();

        Timetable copy = original.copy(newName);

        int period = sc.nextInt();
        sc.nextLine();

        String newSubject = sc.nextLine();

        copy.setPeriod(period, newSubject);

        original.display();
        copy.display();
    }
}