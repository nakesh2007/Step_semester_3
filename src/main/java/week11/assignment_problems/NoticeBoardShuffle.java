public class NoticeBoardShuffle {
    static int[] bubbleStats(int[] scores) {
        int passes = 0, swaps = 0;
        for (int i = 0; i < scores.length - 1; i++) {
            boolean swapped = false;
            passes++;
            for (int j = 0; j < scores.length - 1 - i; j++) {
                if (scores[j] > scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                    swaps++;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        System.out.print("Sorted: ");
        for (int value : scores) System.out.print(value + " ");
        System.out.println();
        return new int[]{passes, swaps};
    }

    public static void main(String[] args) {
        int[] scores = {5, 1, 4, 2, 8};
        int[] result = bubbleStats(scores);
        System.out.println("Passes = " + result[0]);
        System.out.println("Swaps = " + result[1]);
    }
}

// Time: O(n^2) worst case | Extra space: O(1) | Stable: Yes
