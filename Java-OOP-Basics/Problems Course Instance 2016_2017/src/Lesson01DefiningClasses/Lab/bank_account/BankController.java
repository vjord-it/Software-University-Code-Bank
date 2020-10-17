package Lesson01DefiningClasses.Lab.bank_account;

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
            int id = Integer.parseInt(tokens[1]);
            double amount = 0d;
            if (tokens.length == 3) {
                amount = Double.parseDouble(tokens[2]);
            }

            switch (command) {
            case "create":
                create(id);
                break;
            case "deposit":
                deposit(id, amount);
                break;
            case "withdraw":
                withdraw(id, amount);
                break;
            case "print":
                printAccountInfo(id);
                break;
            default:
                break;
            }
        }
    }

    private void printAccountInfo(int id) {
        if (accountValidation(id)) {
            System.out.println(bank.getAccount(id).getAccountDetails());
        }
    }

    private void withdraw(int id, double amount) {
        if (accountValidation(id)) {
            if (!bank.getAccount(id).withdraw(amount)) {
                System.out.println("Insufficient balance");
            }
        }
    }

    private void deposit(int id, double amount) {
        if (accountValidation(id)) {
            if (!bank.getAccount(id).deposit(amount)) {
                System.out.println("Invalid operation");
            }
        }
    }

    private boolean accountValidation(int id) {
        if (!bank.hasAccount(id)) {
            System.out.println("Account does not exist");
            return false;
        }
        return true;
    }

    private void create(int id) {
        if (!bank.createAccount(id)) {
            System.out.println("Account already exists");
        }
    }
}
