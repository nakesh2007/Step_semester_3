import java.time.*;
import java.util.*;

abstract class Room {
    int no;

    Room(int no) {
        this.no = no;
    }

    abstract double price(int days);
}

class Standard extends Room {
    Standard(int no) {
        super(no);
    }

    double price(int days) {
        return days * 100;
    }
}

class Deluxe extends Room {
    Deluxe(int no) {
        super(no);
    }

    double price(int days) {
        return days * 180;
    }
}

class Reservation {
    Room room;
    LocalDate start, end;
    boolean cancelled = false;

    Reservation(Room r, LocalDate s, LocalDate e) {
        room = r;
        start = s;
        end = e;
    }

    boolean overlap(LocalDate s, LocalDate e) {
        return s.isBefore(end) && e.isAfter(start);
    }
}

public class HotelBookingSystem {
    static List<Reservation> list = new ArrayList<>();

    static boolean available(
            Room r,
            LocalDate s,
            LocalDate e) {

        for (Reservation x : list)
            if (!x.cancelled &&
                x.room == r &&
                x.overlap(s,e))
                return false;

        return true;
    }

    static Reservation book(
            Room r,
            LocalDate s,
            LocalDate e) {

        if (!available(r,s,e)) {
            System.out.println("Room unavailable");
            return null;
        }

        Reservation x = new Reservation(r,s,e);
        list.add(x);

        int days = (int)(e.toEpochDay()-s.toEpochDay());

        System.out.println("Booking confirmed");
        System.out.println("Price: $" + r.price(days));

        return x;
    }

    public static void main(String[] args) {
        Room r1 = new Standard(101);
        Room r2 = new Deluxe(201);

        Reservation r =
            book(
                r1,
                LocalDate.of(2026,1,1),
                LocalDate.of(2026,1,5)
            );

        book(
            r1,
            LocalDate.of(2026,1,3),
            LocalDate.of(2026,1,7)
        );

        if (r != null) {
            r.cancelled = true;
            System.out.println("Reservation cancelled");
        }

        book(
            r2,
            LocalDate.of(2026,2,10),
            LocalDate.of(2026,2,12)
        );
    }
}