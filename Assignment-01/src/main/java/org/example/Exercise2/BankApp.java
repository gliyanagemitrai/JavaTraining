package org.example.Exercise2;

import org.example.Exercise2.Enum.AccountType;
import org.example.Exercise2.Enum.Input;
import org.example.Exercise2.exceptions.BalanceNotEnoughException;
import org.example.Exercise2.exceptions.ValidationException;
import org.example.Exercise2.utility.AccountNumberGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BankApp {

    public static void main(String[] args) {
        Bank bank = new Bank();
        BankAccount bankAccount;
        Scanner input = new Scanner(System.in);  //create scanner
        // print main menu
        System.out.println("Welcome to Bank App");

        while (true) {
            System.out.println("Press [1] for Add bank account ");
            System.out.println("Press [2] for perform transaction");
            System.out.println("Press [3] for exit");

            String operations = input.next(); // read any token from the input as String
            switch (operations) {
                case "1":
                    try {
                        createAcccountForCustomer(bank, input);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "2": {
                    performTransaction(bank, input);
                    break;
                }
                case "3":
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input. Please try again");
            }
        }
    }

    private static void performTransaction(Bank bank, Scanner input) {
        BankAccount bankAccount;
        String accountNum = getStringUserInput(input, "Please Enter Account Number :");
        if (bank.bankAccounts.containsKey(accountNum)) {
            bankAccount = bank.bankAccounts.get(accountNum);
            Integer bankAccountAction =
                    getIntUserInput(input, "Account summery [1] perform transaction [2] transaction history [3] ");
            switch (bankAccountAction) {
                case 1: {
                    bankAccount.showSummery();
                    break;
                }
                case 2: {
                    doTransactions(bankAccount, input);
                    break;
                }
                case 3: {
                    bankAccount.showTransactionHistory();
                    break;
                }
            }
        } else {
            System.out.println("Account number is not found.. Please try again");
        }
    }

    private static void createAcccountForCustomer(Bank bank, Scanner input) {
        BankAccount bankAccount;
        String customerId = getStringUserInput(input, "Customer Id :");
        String customerName = getStringUserInput(input, "Customer Name :");
        String emailAddress = getStringUserInput(input, "Email Address :", Input.EMAIL);
        String phoneNumber = getStringUserInput(input, "Phone Number :");

        Integer balance = getIntUserInput(input, "Balance :", Input.POSITIVE_INTEGER);

        System.out.println("Account Types");
        Arrays.stream(AccountType.values()).forEach(type -> {
            System.out.println(type.name + " [" + type.id + "]");
        });

        Integer accountTypeID = getIntUserInput(input, "Please enter Account Type : ", Input.IN, Arrays.asList(1, 2, 3));

        String accountType = Arrays.stream(AccountType.values()).filter(a -> a.id == accountTypeID).findFirst().get().name;
        String save = getStringUserInput(input, "Press [y] for save customer,to cancel enter any other key");

        if (save.equals("y")) {

            String accountNumberGenerator = (new AccountNumberGenerator()).createAccountNumber();
            bankAccount = new BankAccount(accountNumberGenerator, customerName, balance, accountType);

            System.out.println("Created Bank account");
            bank.addBankAccount(bankAccount);
            bankAccount.showSummery();

            doTransactions(bankAccount, input);

            bankAccount.showTransactionHistory();

            Customer customer = new Customer(customerId, customerName, emailAddress, phoneNumber);
            bank.addCustomer(customer);

            bank.displayBankAccountDetails(bankAccount);
            System.out.println("saved");
        }
    }

    static String getStringUserInput(Scanner input, String message) {
        System.out.println(message);
        return input.next();
    }

    static String getStringUserInput(Scanner input, String message, Input type) {
        String output = null;
        boolean error = true;
        do {
            error = false;
            System.out.println(message);
            try {
                input.nextLine();
                output = input.next();

                if (Objects.requireNonNull(type) == Input.EMAIL) {
                    boolean isValid = Pattern.matches("^(.+)@(\\S+)$", output);
                    if (!isValid) {
                        throw new ValidationException("Invalid Email");
                    }
                }
            } catch (Exception e) {
                error = true;
                if (e instanceof ValidationException) {
                    System.out.println(e.getMessage());
                } else {
                    System.out.println("invalid input");
                }
            }
        } while (error);
        return output;
    }

    static int getIntUserInput(Scanner input, String message) {
        System.out.println(message);
        int output;
        try {
            output = input.nextInt();
        } catch (Exception e) {
            output = 99; //for default go back
        }
        return output;
    }

    static int getIntUserInput(Scanner input, String message, Input type) {

        int output = 0;
        boolean error = true;
        input.nextLine();
        do {
            error = false;
            System.out.println(message);
            try {
                String output2 = input.next();
                switch (type) {
                    case POSITIVE_INTEGER: {
                        output = Integer.parseInt(output2);
                        if (output < 1) {
                            throw new ValidationException("Should be greater than zero");
                        }
                        break;
                    }

                    case ACCOUNT_TYPE: {
                        if (output < 1) {
                            throw new ValidationException("Should be greater than zero");
                        }
                        break;
                    }
                }
            } catch (Exception e) {
                error = true;
                if (e instanceof ValidationException) {
                    System.out.println(e.getMessage());
                } else {
                    System.out.println("invalid input");
                }
            }
        } while (error);
        return output;
    }

    static int getIntUserInput(Scanner input, String message, Input type, List inArray) {
        int output = 0;
        boolean error = true;

        input.nextLine();
        do {
            error = false;
            System.out.println(message);
            try {
                String output2 = input.nextLine();
                switch (type) {
                    case IN: {
                        output = Integer.parseInt(output2);

                        if (!inArray.contains(output)) {
                            throw new ValidationException("Invalid Account type");
                        }
                        break;
                    }
                }
            } catch (Exception e) {
                error = true;
                if (e instanceof ValidationException) {
                    System.out.println(e.getMessage());
                } else {
                    System.out.println("invalid input");
                }
            }
        } while (error);
        return output;
    }


    private static void doTransactions(BankAccount bankAccount, Scanner input) {
        Integer transaction_options = getIntUserInput(input, "Press [1] to perform any transaction : Any other number to go back");
        if (transaction_options.equals(1)) {
            do {
                Integer transaction_type = getIntUserInput(input, "Press [1] to Deposit " + "\r\n" + "Press [2] to Withdraw"+ "\r\n"+"Any other number to go back", Input.POSITIVE_INTEGER);
                if (!Arrays.asList(1, 2).contains(transaction_type)) {
                    break;
                } else {
                    Integer amount = getIntUserInput(input, "Amount :", Input.POSITIVE_INTEGER);
                    String save_transaction = getStringUserInput(input, "Save [y] :");

                    if (save_transaction.equals("y")) {
                        if (transaction_type == 1) {
                            bankAccount.deposit(amount);
                        } else if (transaction_type == 2) {
                            try {
                                bankAccount.withdraw(amount);
                            } catch (BalanceNotEnoughException e) {
                                System.out.println("\u001B[31m" + "balance is not sufficient" + "\u001B[0m");
                            }
                        }


                        //doTransactions(bankAccount,input);

                    }
                }
            } while (transaction_options.equals(1));
        }
    }
}
