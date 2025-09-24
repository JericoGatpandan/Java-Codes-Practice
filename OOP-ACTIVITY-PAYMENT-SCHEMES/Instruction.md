# OOP ACTIVITY [ INTERFACE] - PAYMENT SCHEMES

OBJECTIVES
create and implement a Payment interface with different payment methods (e.g., Credit Card, PayPal, GCash, Bank Transfer) and use polymorphism to execute payments.

1. Create an Interface named Payment with the pay(double amount) method.
2. Create at least three classes that implement the Payment interface. Each should provide a specific implementation of the pay method.
3. In the Main class, do the following:
Prompt the user to choose a payment method.
Ask for the amount to pay.
Use the appropriate class (based on user choice) to make the payment.
Sample OUTPUT:

Choose a payment method:
   1. Credit Card
   2. PayPal
   3. GCash
   4. Bank Transfer

Enter option: 2
Enter amount to pay: 250.75
Paid $250.75 using PayPal.

4. Requirement
Use Scanner to get user input.
Apply interface and polymorphism.
Follow clean code practices (class names, method names, indentation).
Bonus: Add a Bank Transfer payment method.
5. Conditions

PaypalAuthentication Conditions:
PayPal account must be verified (e.g., linked to a bank or card).
Payment Conditions:
The payment can only proceed if the PayPal account has sufficient funds.
If the transaction exceeds a certain amount (e.g., $500), additional verification may be required (e.g., 2FA or identity confirmation).
Success Conditions:
The payment is successful if the transaction is approved by PayPal.
The account does not have any payment holds or restrictions.
Gcash
Authentication Conditions:
User must provide valid phone number and PIN.
The GCash account must be active (not locked or suspended).
Payment Conditions:
For payments above a certain amount (e.g., PHP 1,000), OTP (One-Time Password) must be verified.
The account must have sufficient balance to complete the transaction.
PHP 15.00 service charge applies to each transaction, unless the payment is being made from one GCash account to another GCash account (GCash to GCash).
If the transaction exceeds PHP 1,000, an additional service charge will be applied, even for GCash to GCash transfers.
Success Conditions:
The payment is successful if the transaction is approved by GCash.
The funds are deducted from the account and the transaction is confirmed as completed.
Bank Transfer
Authentication Conditions:
User must provide valid bank credentials (e.g., username/password or multi-factor authentication).
Bank account must be active (not frozen or inactive).
Payment Conditions:
The account balance must be sufficient to cover the transaction.
Transactions exceeding a certain limit (e.g., 10,000 PHP) may require manual approval or additional verification.
A PHP 25.00 service charge will be applied if the transaction is made from a different bank. For example, transferring from Bank  to GCASH will incur the additional PHP 25 charge.
Success Conditions:
Payment is successful if the bank confirms the transaction.
Bank provides a transaction reference number upon successful processing.
Credit Card
Authentication Conditions:
User must provide valid credit card details (number, expiration date, CVV).
The credit card must be authorized (not expired, not blocked, etc.).
Address verification (AVS check) may be required to match the billing address.
Payment Conditions:
The credit card must have sufficient credit or funds available to cover the payment.
If the payment exceeds a certain amount (e.g., $1,000), 3D Secure authentication may be required.
Credit cards  have limits (1, 000, 000 PHP card Limit).
Success Conditions:
Payment is successful if the credit card network (Visa, MasterCard, etc.) approves the transaction.
If the credit card exceeds its limit, is expired, or has incorrect details, the payment will fail.