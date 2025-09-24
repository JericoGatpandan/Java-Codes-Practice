package payments;

public class BankTransferPayment implements Payment {
    private final String bankName;
    private final String username;
    private final String password;
    private final boolean multiFactorAuthenticated;
    private boolean active;
    private double balance;
    private final boolean sameBankTransfer;

    public BankTransferPayment(String bankName, String username, String password, boolean multiFactorAuthenticated, boolean active, double balance, boolean sameBankTransfer) {
        this.bankName = bankName;
        this.username = username;
        this.password = password;
        this.multiFactorAuthenticated = multiFactorAuthenticated;
        this.active = active;
        this.balance = balance;
        this.sameBankTransfer = sameBankTransfer;
    }

    @Override
    // Processes a bank transfer payment
    public PaymentResult pay(double amount) {
        StringBuilder log = new StringBuilder();
        String prefix = "[Bank] ";
        if (!areCredentialsValid()) {
            log.append(prefix).append("ERROR: User credentials invalid. Payment failed.");
            return new PaymentResult(false, log.toString());
        }
        log.append(prefix).append("User credentials authenticated.").append(System.lineSeparator());
        if (!active) {
            log.append(prefix).append("ERROR: Account not active. Payment failed.");
            return new PaymentResult(false, log.toString());
        }
        log.append(prefix).append("Account active.").append(System.lineSeparator());
        double serviceCharge = 0;
        if (!sameBankTransfer) {
            serviceCharge += 25.00;
            log.append(prefix).append("Transfer fee applied: PHP 25.00 (different bank).").append(System.lineSeparator());
        }
        boolean additionalVerificationRequired = amount > 10000;
        if (additionalVerificationRequired) {
            boolean manualApprovalGranted = requestManualApproval();
            if (!manualApprovalGranted) {
                log.append(prefix).append("ERROR: Manual approval not granted. Payment failed.");
                return new PaymentResult(false, log.toString());
            }
            log.append(prefix).append("Manual approval granted for amount above PHP 10000.").append(System.lineSeparator());
        }
        double total = amount + serviceCharge;
        if (balance < total) {
            log.append(prefix).append("ERROR: Insufficient balance including service charges. Payment failed.");
            return new PaymentResult(false, log.toString());
        }
        balance -= total;
        String referenceNumber = generateReferenceNumber();
        log.append(prefix).append("Transaction reference: ").append(referenceNumber).append(".").append(System.lineSeparator());
        log.append(String.format("Paid PHP %.2f using Bank Transfer.", total));
        return new PaymentResult(true, log.toString());
    }

    // Validates credentials with basic checks
    private boolean areCredentialsValid() {
        return username != null && !username.isBlank() && password != null && password.length() >= 6 && multiFactorAuthenticated;
    }

    // Simulates manual approval step
    private boolean requestManualApproval() {
        return true;
    }

    // Generates a simple reference number
    private String generateReferenceNumber() {
        return bankName.substring(0, Math.min(3, bankName.length())).toUpperCase() + System.currentTimeMillis();
    }
}
