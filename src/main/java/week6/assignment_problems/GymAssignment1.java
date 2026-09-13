class GymMemberA {
    protected String memberId;
    protected int monthlyFee;
    private int sessionsAttended;

    public GymMemberA(String memberId, int monthlyFee) {
        if (memberId == null || memberId.trim().isEmpty() || memberId.length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }
        if (monthlyFee <= 0) {
            throw new IllegalArgumentException("Invalid monthly fee");
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

    public static String signUpBatch(String[] memberIds, int monthlyFee) {
        int signedUp = 0;
        int rejected = 0;

        for (String id : memberIds) {
            try {
                new GymMemberA(id, monthlyFee);
                signedUp++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }

        return "Signed Up: " + signedUp + " | Rejected: " + rejected;
    }
}

class PremiumMemberA extends GymMemberA {
    private String trainerName;

    public PremiumMemberA(String memberId, int monthlyFee, String trainerName) {
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

public class GymAssignment1 {
    public static void main(String[] args) {
        PremiumMemberA p = new PremiumMemberA("MEM01", 2000, "Coach Riya");

        p.attendSession();
        p.attendSession();

        System.out.println(p.getSessionsAttended());

        String[] members = {"MEM1", "GM1", "MEM2", " ", "MEM3"};
        System.out.println(GymMemberA.signUpBatch(members, 1000));
    }
}