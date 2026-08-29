class feeAccount2 {
}

class HostelFeeAccount extends feeAccount2 {
}

class PaymentProcessor {
    int hostelCount = 0;
    int dayScholarCount = 0;

    void processPayment(feeAccount2 account, double amount) {
        if (account instanceof HostelFeeAccount) {
            System.out.println("Paid in two installments (hostel account)");
            hostelCount++;
        } else {
            System.out.println("Paid in one go (day-scholar account)");
            dayScholarCount++;
        }
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount(),
            new HostelFeeAccount(),
            new feeAccount2(),
            new feeAccount2()
        };

        PaymentProcessor processor = new PaymentProcessor();

        for (feeAccount2 account : accounts) {
            processor.processPayment(account, 60000);
        }

        System.out.println("Hostel accounts processed: " +
                processor.hostelCount + " | Day-scholar accounts processed: " +
                processor.dayScholarCount);
    }
}