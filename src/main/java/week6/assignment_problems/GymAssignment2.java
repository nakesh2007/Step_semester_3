class GymMemberB {
    protected String memberId;
    protected int monthlyFee;
    private int sessionsAttended;

    public GymMemberB(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }
        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public void displayInfo() {
        System.out.println("Standard Member | Sessions: " + sessionsAttended);
    }
}

class PremiumMemberB extends GymMemberB {
    protected String trainerName;

    public PremiumMemberB(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public void displayInfo() {
        System.out.println("Premium Member | Trainer: " + trainerName +
                " | Sessions: " + getSessionsAttended());
    }

    public String getTrainerName() {
        return trainerName;
    }
}

class EliteMemberB extends PremiumMemberB {
    private String lockerNumber;

    public EliteMemberB(String memberId, int monthlyFee, String trainerName, String lockerNumber) {
        super(memberId, monthlyFee, trainerName);
        this.lockerNumber = lockerNumber;
    }

    public void displayInfo() {
        System.out.println("Elite Member | Trainer: " + trainerName +
                " | Locker: " + lockerNumber +
                " | Sessions: " + getSessionsAttended());
    }
}

class GroupClassMemberB extends GymMemberB {
    private String className;

    public GroupClassMemberB(String memberId, int monthlyFee, String className) {
        super(memberId, monthlyFee);
        this.className = className;
    }

    public void displayInfo() {
        System.out.println("Group Class Member | Class: " + className +
                " | Sessions: " + getSessionsAttended());
    }
}

public class GymAssignment2 {

    public static String classifyGeneration(GymMemberB member) {
        if (member instanceof EliteMemberB) {
            return "Multilevel descendant (3 generations deep)";
        }

        if (member instanceof GroupClassMemberB) {
            return "Hierarchical sibling (independent branch)";
        }

        if (member instanceof PremiumMemberB) {
            return "Second generation";
        }

        return "Base generation";
    }

    public static int getTotalSessionsAttended(GymMemberB[] members) {
        int total = 0;

        for (GymMemberB member : members) {
            total += member.getSessionsAttended();
        }

        return total;
    }

    public static void main(String[] args) {
        GymMemberB member1 = new GymMemberB("MEM1", 1000);
        PremiumMemberB member2 = new PremiumMemberB("MEM2", 2000, "Coach Riya");
        EliteMemberB member3 = new EliteMemberB("MEM3", 3000, "Coach Arjun", "L12");
        GroupClassMemberB member4 = new GroupClassMemberB("MEM4", 1500, "Zumba");

        member1.displayInfo();
        member2.displayInfo();
        member3.displayInfo();
        member4.displayInfo();

        System.out.println(classifyGeneration(member3));
        System.out.println(classifyGeneration(member4));

        member2.attendSession();
        member2.attendSession();
        member2.attendSession();

        member3.attendSession();
        member3.attendSession();

        member4.attendSession();
        member4.attendSession();
        member4.attendSession();
        member4.attendSession();

        GymMemberB[] members = {member2, member3, member4};

        System.out.println(getTotalSessionsAttended(members));
    }
}