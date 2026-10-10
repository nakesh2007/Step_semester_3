
import java.util.*;
import java.util.regex.*;

public class MarksAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<int[]> marksList = new ArrayList<>();

        Pattern p = Pattern.compile(
            "\\s*(\\S+)\\s*\\[\\s*(\\d+)\\s*,\\s*(\\d+)\\s*,\\s*(\\d+)\\s*\\]"
        );

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Matcher m = p.matcher(line);

            if (m.matches()) {
                names.add(m.group(1));
                marksList.add(new int[]{
                    Integer.parseInt(m.group(2)),
                    Integer.parseInt(m.group(3)),
                    Integer.parseInt(m.group(4))
                });
            }
        }

        int n = names.size();

        if (n == 0) {
            sc.close();
            return;
        }

        int[] total = new int[n];
        double[] sum = new double[3];
        int topper = 0;

        for (int i = 0; i < n; i++) {
            int[] marks = marksList.get(i);

            for (int j = 0; j < 3; j++) {
                total[i] += marks[j];
                sum[j] += marks[j];
            }

            if (total[i] > total[topper])
                topper = i;
        }

        System.out.print("Totals ");

        for (int i = 0; i < n; i++) {
            if (i > 0)
                System.out.print(", ");

            System.out.print(names.get(i) + " " + total[i]);
        }

        System.out.printf("%naverages %.2f, %.2f, %.2f%n",
                sum[0] / n, sum[1] / n, sum[2] / n);

        System.out.println("topper " + names.get(topper)
                + " (" + total[topper] + ")");

        sc.close();
    }
}
