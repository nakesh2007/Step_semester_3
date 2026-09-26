import java.util.*;

interface Channel {
    void send(Student s,String msg);
}

class Email implements Channel {
    public void send(Student s,String m){
        System.out.println("[Email → "+s.name+"] "+m);
    }
}

class SMS implements Channel {
    public void send(Student s,String m){
        System.out.println("[SMS → "+s.name+"] "+m);
    }
}

class App implements Channel {
    public void send(Student s,String m){
        System.out.println("[App → "+s.name+"] "+m);
    }
}

class Student {
    String name,dept;
    List<Channel> channels=new ArrayList<>();

    Student(String n,String d){
        name=n; dept=d;
    }

    void add(Channel c){
        channels.add(c);
    }
}

class Notice {
    String title;
    Set<String> depts;

    Notice(String t,String... d){
        title=t;
        depts=new HashSet<>(Arrays.asList(d));
    }
}

class NoticeBoard {
    List<Student> students=new ArrayList<>();

    void add(Student s){
        students.add(s);
    }

    void post(Notice n){
        if(n.title==null || n.title.isEmpty()){
            System.out.println("Cannot post notice: Title required");
            return;
        }

        if(n.depts.isEmpty()){
            System.out.println(
                "Cannot post notice: At least one target department is required.");
            return;
        }

        System.out.println("Notice '"+n.title+"' posted.");

        for(Student s:students)
            if(n.depts.contains(s.dept))
                for(Channel c:s.channels)
                    c.send(s,n.title);
    }
}

public class NoticeBroadcaster {
    public static void main(String[] args) {
        Student a=new Student("Asha","CSE");
        a.add(new Email());
        a.add(new App());

        Student r=new Student("Ravi","ECE");
        r.add(new SMS());

        NoticeBoard board=new NoticeBoard();
        board.add(a);
        board.add(r);

        board.post(new Notice("Lab Closed Tomorrow","CSE"));
        board.post(new Notice("Fee Deadline Extended","CSE","ECE"));
        board.post(new Notice("Sports Day"));
    }
}