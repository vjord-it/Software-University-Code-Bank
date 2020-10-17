package Lesson01DefiningClasses.Lab.person;

class BankAccount {
    private double balance;

    BankAccount(Double deposit) {
        super();
        this.balance = deposit;
    }

    double getBalance() {
        return this.balance;
    }
}
