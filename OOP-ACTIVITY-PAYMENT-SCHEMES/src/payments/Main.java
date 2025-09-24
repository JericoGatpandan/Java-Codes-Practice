package payments;
import java.time.YearMonth;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        int option = readOption();
        double amount = readPositiveDouble("Enter amount to pay: ");
        Payment payment = selectPayment(option);
        PaymentResult result = payment.pay(amount);
        System.out.println();
        System.out.println(result.getMessage());
    }

    // Reads and validates the chosen payment option
    private static int readOption() {
        while (true) {
            System.out.println("Choose a payment method:");
            System.out.println("  1. Credit Card");
            System.out.println("  2. PayPal");
            System.out.println("  3. GCash");
            System.out.println("  4. Bank Transfer");
            System.out.print("Enter option: ");
            String line = SCANNER.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value < 1 || value > 4) {
                    System.out.println("Invalid option. Please enter a number between 1 and 4.\n");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric option.\n");
            }
        }
    }

    // Reads a positive payment amount
    private static double readPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim();
            try {
                double value = Double.parseDouble(line);
                if (value <= 0) {
                    System.out.println("Amount must be greater than zero. Please try again.\n");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Please enter a valid number.\n");
            }
        }
    }

    // Reads a yes or no answer
    private static boolean readYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim().toLowerCase();
            if (line.equals("yes") || line.equals("y")) return true;
            if (line.equals("no") || line.equals("n")) return false;
            System.out.println("Invalid response. Please answer yes or no.\n");
        }
    }

    // Chooses the payment implementation
    private static Payment selectPayment(int option) {
        switch (option) {
            case 1: return createCreditCardPayment();
            case 2: return createPayPalPayment();
            case 3: return createGCashPayment();
            case 4: return createBankTransferPayment();
            default: throw new IllegalStateException("Unexpected value: " + option);
        }
    }

    // Builds a credit card payment instance
    private static Payment createCreditCardPayment() {
        String cardNumber = readMatching("Enter credit card number: ", "[0-9]{12,19}", "Card number must be 12 to 19 digits.");
        int year = (int) readNumericRange("Enter expiration year (e.g., 2028): ", 2023, 2100, "Year must be current year or later.");
        int month = (int) readNumericRange("Enter expiration month (1-12): ", 1, 12, "Month must be between 1 and 12.");
        String cvv = readMatching("Enter CVV (3 or 4 digits): ", "[0-9]{3,4}", "CVV must be 3 or 4 digits.");
        String billingAddress = readNonBlank("Enter billing address: ");
        double currentBalance = readPositiveOrZeroDouble("Enter current outstanding balance (0 if none): ");
        return new CreditCardPayment(cardNumber, YearMonth.of(year, month), cvv, billingAddress, 1_000_000.00, currentBalance);
    }

    // Builds a PayPal payment instance
    private static Payment createPayPalPayment() {
        String email = readMatching("Enter PayPal email address: ", ".+@.+\\..+", "Email address format is invalid.");
        boolean verified = readYesNo("Is the account verified? (yes/no): ");
        double balance = readPositiveOrZeroDouble("Enter current PayPal balance: ");
        boolean restrictions = readYesNo("Does the account have payment restrictions or holds? (yes/no): ");
        return new PayPalPayment(email, verified, balance, restrictions);
    }

    // Builds a GCash payment instance
    private static Payment createGCashPayment() {
        String phone = readMatching("Enter eleven digit phone number: ", "[0-9]{11}", "Phone number must be exactly 11 digits.");
        String pin = readMatching("Enter four digit personal identification number: ", "[0-9]{4}", "PIN must be exactly 4 digits.");
        boolean active = readYesNo("Is the account active? (yes/no): ");
        double balance = readPositiveOrZeroDouble("Enter current GCash balance: ");
        boolean sameProvider = readYesNo("Is this a GCash to GCash transfer? (yes/no): ");
        return new GCashPayment(phone, pin, active, balance, sameProvider);
    }

    // Builds a bank transfer payment instance
    private static Payment createBankTransferPayment() {
        String bank = readNonBlank("Enter bank name: ");
        String username = readNonBlank("Enter username: ");
        String password = readMatching("Enter password (minimum six characters): ", ".{6,}", "Password must have at least six characters.");
        boolean mfa = readYesNo("Is multi factor authentication completed? (yes/no): ");
        boolean active = readYesNo("Is the bank account active? (yes/no): ");
        double balance = readPositiveOrZeroDouble("Enter current bank balance: ");
        boolean sameBank = readYesNo("Is this a transfer within the same bank? (yes/no): ");
        return new BankTransferPayment(bank, username, password, mfa, active, balance, sameBank);
    }

    // Reads non blank text input
    private static String readNonBlank(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim();
            if (!line.isEmpty()) return line;
            System.out.println("Value cannot be blank. Please try again.\n");
        }
    }

    // Reads text matching a pattern
    private static String readMatching(String prompt, String regex, String error) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim();
            if (line.matches(regex)) return line;
            System.out.println(error + " Please try again.\n");
        }
    }

    // Reads a non negative double value
    private static double readPositiveOrZeroDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim();
            try {
                double value = Double.parseDouble(line);
                if (value < 0) {
                    System.out.println("Value cannot be negative. Please try again.\n");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter a valid numeric value.\n");
            }
        }
    }

    // Reads a number within a defined range
    private static long readNumericRange(String prompt, long min, long max, String error) {
        while (true) {
            System.out.print(prompt);
            String line = SCANNER.nextLine().trim();
            try {
                long value = Long.parseLong(line);
                if (value < min || value > max) {
                    System.out.println(error + " Range: " + min + " - " + max + ".\n");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.\n");
            }
        }
    }
}
