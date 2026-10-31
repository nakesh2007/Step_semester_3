public class ContestLeaderboard {
    static class Entry {
        String name;
        int marks;
        Entry(String name, int marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    static Entry[] leaderboard(Entry[] entries) {
        int[] count = new int[101];
        Entry[] result = new Entry[entries.length];

        for (Entry entry : entries) count[100 - entry.marks]++;
        for (int i = 1; i < 101; i++) count[i] += count[i - 1];

        for (int i = entries.length - 1; i >= 0; i--) {
            int key = 100 - entries[i].marks;
            result[--count[key]] = entries[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Entry[] entries = {
            new Entry("Asha", 90), new Entry("Ravi", 75),
            new Entry("Neha", 90), new Entry("Kiran", 100),
            new Entry("Meera", 75)
        };
        Entry[] result = leaderboard(entries);
        for (Entry entry : result)
            System.out.println(entry.name + " " + entry.marks);
    }
}

// Time: O(n + 101) | Extra space: O(n + 101) | Stable: Yes
