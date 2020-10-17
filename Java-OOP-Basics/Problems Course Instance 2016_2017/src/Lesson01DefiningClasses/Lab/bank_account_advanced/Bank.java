package Lesson01DefiningClasses.Lab.bank_account_advanced;

import java.util.HashMap;
import java.util.Map;

class Bank {
    private final static double DEFAULT_INTEREST = 0.02;

    private static double rate = DEFAULT_INTEREST;
    private Map<Integer, BankAccount> accounts;

    Bank() {
        super();
        this.accounts = new HashMap<>();
    }

    static void setInterestRate(double newInterestRate) {
        rate = newInterestRate;
    }

    private boolean hasAccount(int id) {
        return this.accounts.containsKey(id);
    }

    BankAccount createAccount() {
        BankAccount account = new BankAccount();
        this.accounts.put(account.getId(), account);
        return account;
    }

    BankAccount getAccount(int id) {
        if (!this.hasAccount(id)) {
            throw new IllegalArgumentException("Account does not exist");
        }
        return this.accounts.get(id);
    }

    double getInterest(int id, int years) {
        return this.getAccount(id).getBalance() * rate * years;
    }
}
