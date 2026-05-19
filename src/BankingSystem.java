class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {         super(message);
    }
}

//class BankAccount {     private String accountHolder;     private double balance;
//
//    // Constructor
//    public BankAccount(String accountHolder, double balance) {         this.accountHolder = accountHolder;         this.balance = balance;
//}
//
// Method to withdraw money
//public void withdraw(double amount) throws InsufficientBalanceException {         if (amount > balance) {             throw new InsufficientBalanceException(
//        "Withdrawal failed! Insufficient balance. Available balance: Rs. " + balance
//);         }
//    balance -= amount;
//    System.out.println("Withdrawal successful! Rs. " + amount + " withdrawn.");
//}
//
//
//public void displayBalance() {
//    System.out.println("Current Balance: Rs. " + balance);     }
// }
//
//// Method to withdraw money
//public void withdraw(double amount) throws InsufficientBalanceException {         if (amount > balance) {             throw new InsufficientBalanceException(
//        "Withdrawal failed! Insufficient balance. Available balance: Rs. " + balance
//);         }
//    balance -= amount;
//    System.out.println("Withdrawal successful! Rs. " + amount + " withdrawn.");
//}
//
//
//public void displayBalance() {
//    System.out.println("Current Balance: Rs. " + balance);     }
// }

class BankAccount {     private String accountHolder;     private double balance;

    // Constructor
    public BankAccount(String accountHolder, double balance) {         this.accountHolder = accountHolder;         this.balance = balance;
}

// Method to withdraw money
public void withdraw(double amount) throws InsufficientBalanceException {         if (amount > balance) {             throw new InsufficientBalanceException(
        "Withdrawal failed! Insufficient balance. Available balance: Rs. " + balance
);         }
    balance -= amount;
    System.out.println("Withdrawal successful! Rs. " + amount + " withdrawn.");
}


public void displayBalance() {
    System.out.println("Current Balance: Rs. " + balance);     }
 }

class CustomExceptionDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Prejina", 5000);
        account.displayBalance();
        try {
            account.withdraw(6000); // Trying to withdraw more than  balance
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception Caught: " + e.getMessage());         }
        account.displayBalance();
    }
}
