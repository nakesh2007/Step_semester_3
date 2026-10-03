import java.util.*;

public class PopularOrderFinder {
    public static String[] mostPopular(String[] orders) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String item : orders) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        String bestItem = orders[0];
        int bestCount = map.get(bestItem);

        for (String item : orders) {
            if (map.get(item) > bestCount) {
                bestItem = item;
                bestCount = map.get(item);
            }
        }

        return new String[]{bestItem, String.valueOf(bestCount)};
    }

    public static void main(String[] args) {
        String[] orders = {
            "dosa", "idli", "vada", "dosa",
            "idli", "dosa", "tea"
        };

        String[] result = mostPopular(orders);
        System.out.println("(" + result[0] + ", " + result[1] + ")");
    }
}