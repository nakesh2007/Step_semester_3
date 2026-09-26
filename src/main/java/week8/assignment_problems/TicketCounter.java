import java.util.*;

abstract class Seat {
    String id;
    Seat(String i){ id=i; }
    abstract int price();
}

class Regular extends Seat {
    Regular(String i){ super(i); }
    int price(){ return 150; }
}

class Premium extends Seat {
    Premium(String i){ super(i); }
    int price(){ return 250; }
}

class Recliner extends Seat {
    Recliner(String i){ super(i); }
    int price(){ return 400; }
}

class Customer {
    String name;
    Customer(String n){ name=n; }
}

class Show {
    Set<String> booked=new HashSet<>();

    boolean available(Seat s){
        return !booked.contains(s.id);
    }

    void book(Seat s){
        booked.add(s.id);
    }

    void release(Seat s){
        booked.remove(s.id);
    }
}

class Booking {
    Customer c;
    Show show;
    List<Seat> seats=new ArrayList<>();

    Booking(Customer c,Show s){ this.c=c; show=s; }

    void add(Seat s){
        if(seats.size()==6){
            System.out.println("Maximum 6 seats allowed");
            return;
        }

        if(!show.available(s)){
            System.out.println("Seat "+s.id+" is already booked");
            return;
        }

        seats.add(s);
        show.book(s);
    }

    void total(){
        int sum=0;
        for(Seat s:seats) sum+=s.price();
        System.out.println("Booking confirmed for "+c.name);
        System.out.println("Total: ₹"+sum);
    }

    void cancel(){
        for(Seat s:seats) show.release(s);
        seats.clear();
        System.out.println(c.name+"'s booking cancelled");
    }
}

public class TicketCounter {
    public static void main(String[] args) {
        Show show=new Show();

        Customer a=new Customer("Asha");
        Customer r=new Customer("Ravi");
        Customer n=new Customer("Neha");

        Booking b=new Booking(a,show);
        b.add(new Regular("A1"));
        b.add(new Regular("A2"));
        b.add(new Premium("F5"));
        b.total();

        Booking r1=new Booking(r,show);
        r1.add(new Regular("A2"));
        r1.add(new Recliner("R1"));
        r1.total();

        b.cancel();

        Booking n1=new Booking(n,show);
        n1.add(new Regular("A2"));
        n1.total();
    }
}