package Lesson01DefiningClasses.Lab.bank_account;

public class BankAccount {
    private int id;
    private double balance;

    BankAccount(int id) {
        super();
        this.id = id;
        this.balance = 0d;
    }

    boolean deposit(double amount) {
        if (amount < 0d) {
            return false;
        }
        this.balance += amount;
        return true;
    }

    boolean withdraw(double amount) {
        if (this.balance - amount < 0d) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

    String getAccountDetails() {
        return String.format("Account ID%d, balance %.2f", this.id, this.balance);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
