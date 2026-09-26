abstract class Wash {
    abstract int time();
    abstract int charge();
}

class Quick extends Wash {
    int time(){ return 30; }
    int charge(){ return 20; }
}

class Normal extends Wash {
    int time(){ return 45; }
    int charge(){ return 30; }
}

class Heavy extends Wash {
    int time(){ return 60; }
    int charge(){ return 45; }
}

class Student {
    String name;
    Student(String n){ name=n; }
}

class Machine {
    String id;
    boolean free=true;

    Machine(String id){ this.id=id; }

    void start(Student s, Wash w) {
        if(!free){
            System.out.println(id+" is currently busy");
            return;
        }
        free=false;
        System.out.println(w.getClass().getSimpleName()+
                " wash started on "+id+" for "+s.name);
        System.out.println("Charge: ₹"+w.charge());
    }

    void complete() {
        free=true;
        System.out.println(id+" cycle completed. "+id+" is now free.");
    }
}

public class Laundry {
    public static void main(String[] args) {
        Student a=new Student("Asha");
        Student r=new Student("Ravi");
        Student n=new Student("Neha");

        Machine m1=new Machine("M1");
        Machine m2=new Machine("M2");

        m1.start(a,new Quick());
        m1.start(r,new Heavy());
        m2.start(r,new Heavy());
        m1.complete();
        m1.start(n,new Normal());
    }
}