class FeeAccount_2 {

    String name;

    FeeAccount(String name) {
        this.name = name;
    }
}

class HostelFeeAccount extends FeeAccount {

    HostelFeeAccount(String name) {
        super(name);
    }
}

class PaymentProcessor {

    void processPayment(FeeAccount account, double amount) {

        if (account instanceof HostelFeeAccount) {

            System.out.println(
                "Paid in two installments (hostel account)"
            );
        }
        else {

            System.out.println(
                "Paid in one go (day-scholar account)"
            );
        }
    }
}

class Main {

    public static void main(String[] args) {

        FeeAccount[] accounts = {

            new HostelFeeAccount("Ravi"),
            new HostelFeeAccount("Meera"),
            new FeeAccount("Karthik"),
            new FeeAccount("Divya")
        };

        double amount = 60000;

        PaymentProcessor processor =
            new PaymentProcessor();

        int hostelCount = 0;
        int dayScholarCount = 0;

        for (int i = 0; i < accounts.length; i++) {

            processor.processPayment(
                accounts[i],
                amount
            );

            if (accounts[i] instanceof HostelFeeAccount) {
                hostelCount++;
            }
            else {
                dayScholarCount++;
            }
        }

        System.out.println(
            "Hostel accounts processed: " + hostelCount
            + " | Day-scholar accounts: " + dayScholarCount
        );
    }
}
