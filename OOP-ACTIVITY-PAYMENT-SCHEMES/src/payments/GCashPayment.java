package payments;

public class GCashPayment implements Payment {
    private final String phoneNumber;
    private final String pin;
    private boolean active;
    private double balance;
    private final boolean sameProviderTransfer;

    public GCashPayment(String phoneNumber, String pin, boolean active, double balance, boolean sameProviderTransfer) {
        this.phoneNumber = phoneNumber;
        this.pin = pin;
        this.active = active;
        this.balance = balance;
        this.sameProviderTransfer = sameProviderTransfer;
    }

    @Override
    // Processes a GCash payment
    public PaymentResult pay(double amount) {
        StringBuilder log = new StringBuilder();
        String prefix = "[GCash] ";
        if (!isPhoneNumberValid(phoneNumber) || !isPinValid(pin)) {
            log.append(prefix).append("ERROR: Phone number or PIN invalid. Payment failed.");
            return new PaymentResult(false, log.toString());
        }
        if (!active) {
            log.append(prefix).append("ERROR: Account not active. Payment failed.");
            return new PaymentResult(false, log.toString());
        }
        log.append(prefix).append("Phone number and PIN verified.").append(System.lineSeparator());
        double serviceCharge = 0;
        if (!sameProviderTransfer) {
            serviceCharge += 15.00;
        }
        if (amount > 1000) {
            boolean oneTimePasswordVerified = verifyOneTimePassword();
            if (!oneTimePasswordVerified) {
                log.append(prefix).append("ERROR: One Time Password verification failed. Payment failed.");
                return new PaymentResult(false, log.toString());
            }
            log.append(prefix).append("OTP verification required for transaction above PHP 1000.").append(System.lineSeparator());
            serviceCharge += 10.00; 
        }
        double total = amount + serviceCharge;
        if (balance < total) {
            log.append(prefix).append("ERROR: Insufficient balance including service charges. Payment failed.");
            return new PaymentResult(false, log.toString());
        }
        balance -= total;
        if (serviceCharge > 0) {
            log.append(prefix).append(String.format("Service charge: PHP %.2f", serviceCharge));
            log.append(".").append(System.lineSeparator());
            log.append(prefix).append("Payment approved.").append(System.lineSeparator());
            log.append(String.format("Paid PHP %.2f using GCash (including service charges).", total));
        } else {
            log.append(prefix).append("Payment approved.").append(System.lineSeparator());
            log.append(String.format("Paid PHP %.2f using GCash.", amount));
        }
        return new PaymentResult(true, log.toString());
    }

    // Validates phone number format
    private boolean isPhoneNumberValid(String number) {
        return number != null && number.matches("\\d{11}");
    }

    // Validates PIN format
    private boolean isPinValid(String pin) {
        return pin != null && pin.matches("\\d{4}");
    }

    // Simulates OTP verification
    private boolean verifyOneTimePassword() {
        return true;
    }
}
