class LibraryMember {
    protected String memberId;
    protected int borrowLimit;
    protected int booksBorrowed;

    public LibraryMember(String memberId, int borrowLimit) {
        if (memberId == null || memberId.trim().length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        if (borrowLimit <= 0) {
            throw new IllegalArgumentException("Invalid borrow limit");
        }

        this.memberId = memberId;
        this.borrowLimit = borrowLimit;
    }

    public void borrowBook() {
        if (booksBorrowed < borrowLimit) {
            booksBorrowed++;
        }
    }

    public int getBooksBorrowed() {
        return booksBorrowed;
    }

    public void displayInfo() {
        System.out.print("General | Books: " + booksBorrowed);
    }
}

class StudentMember extends LibraryMember {
    private String course;

    public StudentMember(String memberId, int borrowLimit, String course) {
        super(memberId, borrowLimit);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public void displayInfo() {
        System.out.print("Student | Course: " + course +
                " | Books: " + booksBorrowed);
    }
}

public class WeeklyCirculation {
    public static String batchPrint(LibraryMember[] members) {
        StringBuilder result = new StringBuilder();

        for (LibraryMember member : members) {
            member.displayInfo();

            if (member instanceof StudentMember) {
                StudentMember student = (StudentMember) member;
                result.append("Student | Course: ")
                      .append(student.getCourse())
                      .append(" | Books: ")
                      .append(student.getBooksBorrowed())
                      .append(" [Course via downcast: ")
                      .append(student.getCourse())
                      .append("] | ");
            } else {
                result.append("General | Books: ")
                      .append(member.getBooksBorrowed())
                      .append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        LibraryMember[] members = {
            new LibraryMember("LB5", 3),
            new StudentMember("STU6", 3, "ECE")
        };

        System.out.println(batchPrint(members));
    }
}