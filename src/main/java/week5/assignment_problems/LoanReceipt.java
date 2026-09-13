import java.util.Arrays;

public final class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        this.bookIds = Arrays.copyOf(bookIds, bookIds.length);
    }

    public String[] getBookIds() {
        return Arrays.copyOf(bookIds, bookIds.length);
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] updatedIds = Arrays.copyOf(bookIds, bookIds.length);
        updatedIds[index] = newId;
        return new LoanReceipt(memberId, updatedIds);
    }
}