# Payment Schemes OOP Activity

This project demonstrates the use of an interface (`Payment`) and multiple concrete implementations to process different kinds of payments. It applies polymorphism, clean code principles, and user input handling with `Scanner`.

## Payment Methods Implemented
- Credit Card
- PayPal
- GCash
- Bank Transfer

Each implementation enforces realistic authentication, payment, service charge, and success conditions derived from the activity instructions.

## Source Structure
```
src/
  Main.java
  payments/
    Payment.java
    PaymentResult.java
    CreditCardPayment.java
    PayPalPayment.java
    GCashPayment.java
    BankTransferPayment.java
```

Compiled bytecode is placed in the separate `out` directory.

## Compile
Use the Java compiler with the `-d` flag to place class files in the `out` directory (created automatically if missing).

```
javac -d out src/payments/*.java src/Main.java
```

## Run
Run the program by referencing the output directory on the class path.

```
java -cp out Main
```

## Example Interaction
```
Choose a payment method:
  1. Credit Card
  2. PayPal
  3. GCash
  4. Bank Transfer
Enter option: 2
Enter amount to pay: 250.75
Enter PayPal email address: user@example.com
Is the account verified? (yes/no): yes
Enter current PayPal balance: 500
Does the account have payment restrictions or holds? (yes/no): no
Paid 250.75 United States dollars using PayPal.
```

## Notes
- All monetary values for Philippine peso denominated methods print "Philippine pesos" for clarity.
- PayPal output uses US dollars wording as PayPal is typically denominated internationally.
- Additional verification steps are simulated (they always pass) and can be extended to include real logic.
