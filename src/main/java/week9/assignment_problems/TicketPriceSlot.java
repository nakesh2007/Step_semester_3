import java.util.*;

public class TicketPriceSlot {
    public static int findSlot(int[] prices, int newPrice) {
        int low = 0;
        int high = prices.length;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (prices[mid] < newPrice) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] prices = {120, 150, 200, 260};
        int newPrice = 210;

        System.out.println(findSlot(prices, newPrice));
    }
}