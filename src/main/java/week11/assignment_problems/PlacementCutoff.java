public class PlacementCutoff {
    static int kthHighest(int[] marks, int k) {
        int target = marks.length - k;
        int left = 0, right = marks.length - 1;
        while (left <= right) {
            int pivotIndex = partition(marks, left, right);
            if (pivotIndex == target) return marks[pivotIndex];
            if (pivotIndex < target) left = pivotIndex + 1;
            else right = pivotIndex - 1;
        }
        return -1;
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] marks = {72, 95, 60, 88, 79};
        System.out.println(kthHighest(marks, 2));
    }
}

// Average time: O(n), worst case: O(n^2) | Extra space: O(1) | Stable: No
