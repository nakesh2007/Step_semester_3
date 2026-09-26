abstract class Plan {
    abstract double fee();
}

class Monthly extends Plan {
    double fee(){ return 1000; }
}

class Quarterly extends Plan {
    double fee(){ return 2700; }
}

class Annual extends Plan {
    double fee(){ return 9000; }
}

enum Status {
    ACTIVE,FROZEN,EXPIRED
}

class Member {
    String name;
    Membership membership;

    Member(String n){ name=n; }

    void buy(Plan p){
        membership=new Membership(p);
        System.out.println(
            membership.status+" membership created for "+name);
        System.out.println("Fee: ₹"+p.fee());
    }
}

class Membership {
    Plan plan;
    Status status=Status.ACTIVE;

    Membership(Plan p){ plan=p; }

    void checkIn(String name){
        if(status==Status.ACTIVE)
            System.out.println(name+" checked in successfully.");
        else
            System.out.println("Check-in denied: "+name+
                    "'s membership is "+status);
    }

    void freeze(){
        if(status!=Status.ACTIVE){
            System.out.println("Cannot freeze an "+status+
                    " membership.");
            return;
        }
        status=Status.FROZEN;
        System.out.println("Membership frozen. Status: "+status);
    }

    void unfreeze(){
        if(status!=Status.FROZEN){
            System.out.println("Cannot unfreeze "+status);
            return;
        }
        status=Status.ACTIVE;
    }

    void expire(){
        status=Status.EXPIRED;
        System.out.println("Membership expired. Status: "+status);
    }
}

public class FitZone {
    public static void main(String[] args) {
        Member a=new Member("Asha");
        Member r=new Member("Ravi");

        a.buy(new Quarterly());
        r.buy(new Monthly());

        a.membership.checkIn(a.name);
        a.membership.freeze();
        a.membership.checkIn(a.name);

        r.membership.expire();
        r.membership.freeze();
    }
}