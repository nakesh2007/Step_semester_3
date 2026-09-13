import java.util.*;

class AccessChecker {

    static String classifyAccess(String modifier, String context) {

        if (modifier.equals("public"))
            return "ALLOWED";

        if (modifier.equals("private"))
            return context.equals("SAME_CLASS") ? "ALLOWED" : "DENIED";

        if (modifier.equals("default"))
            return context.equals("SAME_CLASS") ||
                   context.equals("SAME_PACKAGE") ? "ALLOWED" : "DENIED";

        if (modifier.equals("protected"))
            return context.equals("DIFFERENT_PACKAGE") ? "DENIED" : "ALLOWED";

        return "DENIED";
    }

    static String summarizeBatch(String[][] attempts) {

        int allowed = 0;
        int denied = 0;

        for (String[] a : attempts) {
            if (classifyAccess(a[0], a[1]).equals("ALLOWED"))
                allowed++;
            else
                denied++;
        }

        return "Allowed: " + allowed + " | Denied: " + denied;
    }

    public static void main(String[] args) {

        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));

        String[][] attempts = {
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(summarizeBatch(attempts));
    }
}

class MovieTicket {
    private String seatNumber;
    String screenId;
    protected double ticketPrice;
    public String movieTitle;
}