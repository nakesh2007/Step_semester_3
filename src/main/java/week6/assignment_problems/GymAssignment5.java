class GymMemberE {
    private static int membersEnrolled = 0;
    private final String membershipNumber;
    protected int monthlyFee;
    private int feesPaid;

    public GymMemberE(int monthlyFee) {
        this.monthlyFee = monthlyFee;
        membersEnrolled++;
        membershipNumber = "GYM-" + (2000 + membersEnrolled);
    }

    public void payFee(int amount) {
        feesPaid += amount;
    }

    public void payFee(int amount, String mode) {
        payFee(amount);
    }

    public int getFeesPaid() {
        return feesPaid;
    }

    public String getMembershipNumber() {
        return membershipNumber;
    }

    public static boolean isValidReferralCode(String code) {
        if (code == null || code.length() != 4) {
            return false;
        }

        return code.charAt(0) == 'G'
                && Character.isDigit(code.charAt(1))
                && Character.isDigit(code.charAt(2))
                && Character.isUpperCase(code.charAt(3));
    }

    public static int getMembersEnrolled() {
        return membersEnrolled;
    }
}

class GroupClassMemberE extends GymMemberE {
    private String className;

    public GroupClassMemberE(int monthlyFee, String className) {
        super(monthlyFee);
        this.className = className;
    }
}

public class GymAssignment5 {

    public static String processWeeklyCheckIn(GymMemberE[] members) {
        int processed = 0;
        int nullSkipped = 0;
        int group = 0;
        int individual = 0;

        for (GymMemberE member : members) {
            if (member == null) {
                nullSkipped++;
                continue;
            }

            processed++;

            if (member instanceof GroupClassMemberE) {
                group++;
            } else {
                individual++;
            }
        }

        return processed + " processed | " +
                nullSkipped + " null skipped | " +
                group + " group | " +
                individual + " individual";
    }

    public static void main(String[] args) {
        GymMemberE m1 = new GymMemberE(1000);

        System.out.println(m1.getMembershipNumber());
        System.out.println(GymMemberE.getMembersEnrolled());

        System.out.println(GymMemberE.isValidReferralCode("G45B"));
        System.out.println(GymMemberE.isValidReferralCode("G4B"));
        System.out.println(GymMemberE.isValidReferralCode("X45B"));

        m1.payFee(500);
        m1.payFee(500, "UPI");

        System.out.println(m1.getFeesPaid());

        GymMemberE[] members = {
                new GroupClassMemberE(1500, "Zumba"),
                null,
                new GymMemberE(1000)
        };

        System.out.println(GymAssignment5.processWeeklyCheckIn(members));
    }
}