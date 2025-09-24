package payments;

import java.time.YearMonth;

public class CreditCardPayment implements Payment {
    private final String cardNumber;
    private final YearMonth expiration;
    private final String cvv;
    private final String billingAddress;
    private final double creditLimit;
    private double currentBalance;

    public CreditCardPayment(String cardNumber, YearMonth expiration, String cvv, String billingAddress, double creditLimit, double currentBalance) {
        this.cardNumber = cardNumber;
        this.expiration = expiration;
        this.cvv = cvv;
        this.billingAddress = billingAddress;
        this.creditLimit = creditLimit;
        this.currentBalance = currentBalance;
    }

    @Override
    // Processes a credit card payment
    public PaymentResult pay(double amount) {
        StringBuilder log = new StringBuilder();
        String prefix = "[Credit Card] ";

        if (!isCardNumberValid(cardNumber)) {
            log.append(prefix).append("ERROR: Card number is invalid. Payment failed.");
            return new PaymentResult(false, log.toString());
        }
        if (YearMonth.now().isAfter(expiration)) {
            log.append(prefix).append("ERROR: Card is expired. Payment failed.");
            return new PaymentResult(false, log.toString());
        }
        if (!isCvvValid(cvv)) {
            log.append(prefix).append("ERROR: CVV is invalid. Payment failed.");
            return new PaymentResult(false, log.toString());
        }
        if (billingAddress == null || billingAddress.isBlank()) {
            log.append(prefix).append("ERROR: Billing address is missing. Payment failed.");
            return new PaymentResult(false, log.toString());
        }
        double availableCredit = creditLimit - currentBalance;
        if (amount > availableCredit) {
            log.append(prefix).append("ERROR: Insufficient available credit. Payment failed.");
            return new PaymentResult(false, log.toString());
        }
        log.append(prefix).append("Card details verified.").append(System.lineSeparator());

        if (amount > 1000) {
            boolean threeDomainSecurePassed = performThreeDomainSecureAuthentication();
            if (!threeDomainSecurePassed) {
                log.append(prefix).append("ERROR: 3D Secure authentication failed. Payment failed.");
                return new PaymentResult(false, log.toString());
            } else {
                log.append(prefix).append("3D Secure authentication required for amount above $1000.").append(System.lineSeparator());
            }
        }
        currentBalance += amount;
        log.append(prefix).append("Payment approved by ").append(detectNetwork()).append(" Network.").append(System.lineSeparator());
        log.append(String.format("Paid $%.2f using Credit Card.", amount));
        return new PaymentResult(true, log.toString());
    }

    // Checks basic card number format
    private boolean isCardNumberValid(String number) {
        if (number == null) return false;
        if (number.length() < 12 || number.length() > 19) return false;
        for (char c : number.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    // Checks basic CVV format
    private boolean isCvvValid(String cvv) {
        if (cvv == null) return false;
        if (cvv.length() != 3 && cvv.length() != 4) return false;
        for (char c : cvv.toCharArray()) {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    // Simulates 3D Secure process
    private boolean performThreeDomainSecureAuthentication() {
        return true;
    }

    // Simple network detection based on first digit
    private String detectNetwork() {
        if (cardNumber == null || cardNumber.isEmpty()) return "Card";
        char first = cardNumber.charAt(0);
        switch (first) {
            case '4': return "Visa";
            case '5': return "MasterCard";
            case '3': return "American Express";
            case '6': return "Discover";
            default: return "Card";
        }
    }
}
