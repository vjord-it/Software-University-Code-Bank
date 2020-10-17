package Lesson01DefiningClasses.Lab.bank_account_advanced;

class BankAccount {
    private static int bankAccountCount;

    private int id;
    private double balance;

    BankAccount() {
        this.id = ++bankAccountCount;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    int getId() {
        return id;
    }

    double getBalance() {
        return balance;
    }
}
