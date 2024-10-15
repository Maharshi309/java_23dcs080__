class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new RuntimeException("Insufficient funds for this withdrawal.");
        }
        balance -= amount;
        System.out.println("Successfully withdrew: $" + amount);
    }

    public double getBalance() {
        return balance;
    }
}

public class Per_25 {
    public static void main(String[] args) {
        try {
            
            BankAccount account = new BankAccount(900);

            System.out.println("Initial Balance: $" + account.getBalance());
          System.out.println("withdraw amount: $8000");
            
            account.withdraw(8000);
            System.out.println("Aveleble Balance: $" + account.getBalance());

        } catch (RuntimeException e) {
            
            System.out.println("Error: " + e.getMessage());
        }

       System.out.println("Program continues after exception handling.");
System.out.println("23DCS080 Maharshi Patel ");

    }

}
