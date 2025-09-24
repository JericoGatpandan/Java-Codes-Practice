package payments;

public class PayPalPayment implements Payment {
    private final String emailAddress;
    private final boolean accountVerified;
    private double accountBalance;
    private final boolean paymentRestrictions;

    public PayPalPayment(String emailAddress, boolean accountVerified, double accountBalance, boolean paymentRestrictions) {
        this.emailAddress = emailAddress;
        this.accountVerified = accountVerified;
        this.accountBalance = accountBalance;
        this.paymentRestrictions = paymentRestrictions;
    }

    @Override
    // Processes a PayPal payment
    public PaymentResult pay(double amount) {
        StringBuilder log = new StringBuilder();
        String prefix = "[PayPal] ";
        if (emailAddress == null || !emailAddress.contains("@")) {
            log.append(prefix).append("ERROR: Email address is invalid. Payment failed.");
            return new PaymentResult(false, log.toString());
        }
        if (!accountVerified) {
            log.append(prefix).append("ERROR: Account not verified. Payment failed.");
            return new PaymentResult(false, log.toString());
        }
        log.append(prefix).append("Account verified.").append(System.lineSeparator());
        if (paymentRestrictions) {
            log.append(prefix).append("ERROR: Account has payment holds or restrictions. Payment failed.");
            return new PaymentResult(false, log.toString());
        }
        if (accountBalance < amount) {
            log.append(prefix).append("ERROR: Insufficient funds. Payment failed.");
            return new PaymentResult(false, log.toString());
        }
        if (amount > 500) {
            boolean additionalVerificationPassed = performAdditionalVerification();
            if (!additionalVerificationPassed) {
                log.append(prefix).append("ERROR: Additional verification failed. Payment failed.");
                return new PaymentResult(false, log.toString());
            }
            log.append(prefix).append("Additional verification completed for high value transaction.").append(System.lineSeparator());
        }
        accountBalance -= amount;
        log.append(prefix).append("Transaction approved.").append(System.lineSeparator());
        log.append(String.format("Paid $%.2f using PayPal.", amount));
        return new PaymentResult(true, log.toString());
    }

    // Simulates extra verification for high value payment
    private boolean performAdditionalVerification() {
        return true;
    }
}
