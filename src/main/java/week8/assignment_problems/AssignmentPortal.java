import java.time.*;

abstract class Assignment {
    String name;
    int max;
    LocalDate due;

    Assignment(String n,int m,LocalDate d){
        name=n; max=m; due=d;
    }

    abstract double penalty(int days);
}

class Coding extends Assignment {
    Coding(String n,int m,LocalDate d){ super(n,m,d); }
    double penalty(int d){ return d*10; }
}

class Written extends Assignment {
    Written(String n,int m,LocalDate d){ super(n,m,d); }
    double penalty(int d){ return d*20; }
}

class Student {
    String name;
    Student(String n){ name=n; }
}

class Submission {
    Student s;
    Assignment a;
    LocalDate date;
    boolean graded=false;

    Submission(Student s,Assignment a,LocalDate d){
        this.s=s; this.a=a; date=d;
    }

    void grade(int marks){
        if(graded){
            System.out.println("Cannot resubmit: "+a.name+
                    " has already been graded.");
            return;
        }

        long days=Math.max(0,date.toEpochDay()-a.due.toEpochDay());
        double finalMarks=marks-(marks*a.penalty((int)days)/100);

        graded=true;
        System.out.println(s.name+" graded: "+
                (int)finalMarks+"/"+a.max);
    }

    void submit(LocalDate d){
        if(graded){
            System.out.println("Cannot resubmit: "+
                    a.name+" has already been graded.");
            return;
        }
        date=d;
        System.out.println(s.name+"'s submission received.");
    }
}

public class AssignmentPortal {
    public static void main(String[] args) {
        Student a=new Student("Asha");
        Student r=new Student("Ravi");

        Assignment c=new Coding(
                "Linked List Lab",50,
                LocalDate.of(2026,3,10));

        Assignment w=new Written(
                "Design Essay",50,
                LocalDate.of(2026,3,12));

        Submission x=new Submission(a,c,
                LocalDate.of(2026,3,10));

        Submission y=new Submission(r,w,
                LocalDate.of(2026,3,14));

        x.grade(45);
        y.grade(40);
        x.submit(LocalDate.of(2026,3,11));
    }
}