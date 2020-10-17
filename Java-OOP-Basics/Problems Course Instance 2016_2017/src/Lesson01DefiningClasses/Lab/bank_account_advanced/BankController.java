package Lesson01DefiningClasses.Lab.bank_account_advanced;

import java.util.Scanner;

class BankController {

    private Bank bank;

    BankController() {
        bank = new Bank();
    }

    void start() {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (!"end".equals(input = scanner.nextLine().toLowerCase())) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command) {
            case "create":
                create();
                break;
            case "deposit":
                deposit(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                break;
            case "setinterest":
                setInterest(Double.parseDouble(tokens[1]));
                break;
            case "getinterest":
                getInterest(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
                break;
            default:
                break;
            }
        }
    }

    private void getInterest(int id, int years) {
        try {
            System.out.printf("%.2f%n", bank.getInterest(id, years));
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private void setInterest(double interestRate) {
        Bank.setInterestRate(interestRate);
    }

    private void deposit(int id, int amount) {
        try {
            bank.getAccount(id).deposit(amount);
            System.out.printf("Deposited %d to ID%d%n", amount, id);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }

    private void create() {
        BankAccount account = bank.createAccount();
        System.out.printf("Account ID%d created%n", account.getId());
    }
}
