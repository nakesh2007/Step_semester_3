class GymMemberD {
    protected String memberId;
    protected int monthlyFee;
    protected int sessionsAttended;

    public GymMemberD(String memberId, int monthlyFee) {
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
        System.out.print("Standard | Sessions: " + sessionsAttended);
    }
}

class PremiumMemberD extends GymMemberD {
    private String trainerName;

    public PremiumMemberD(String memberId, int monthlyFee, String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    public void displayInfo() {
        System.out.print("Premium | Trainer: " + trainerName +
                " | Sessions: " + sessionsAttended);
    }

    public String getTrainerName() {
        return trainerName;
    }
}

public class GymAssignment4 {

    public static String batchPrint(GymMemberD[] members) {
        StringBuilder result = new StringBuilder();

        for (GymMemberD member : members) {
            member.displayInfo();

            if (member instanceof PremiumMemberD) {
                PremiumMemberD premium = (PremiumMemberD) member;
                result.append("Premium | Trainer: ")
                        .append(premium.getTrainerName())
                        .append(" | Sessions: ")
                        .append(premium.getSessionsAttended())
                        .append(" [Trainer via downcast: ")
                        .append(premium.getTrainerName())
                        .append("] | ");
            } else {
                result.append("Standard | Sessions: ")
                        .append(member.getSessionsAttended())
                        .append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        GymMemberD[] members = {
                new GymMemberD("MEM6", 1000),
                new PremiumMemberD("MEM7", 2000, "Coach Riya")
        };

        System.out.println(batchPrint(members));
    }
}