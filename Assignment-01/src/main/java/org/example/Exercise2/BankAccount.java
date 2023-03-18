package org.example.Exercise2;

import org.example.Exercise2.exceptions.BalanceNotEnoughException;
import org.example.Exercise2.utility.TransactionIdGenerator;

import java.util.*;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private Integer balance;
    private String accountType;

    private List<Transaction> transactions = new LinkedList<>();

    public BankAccount(String accountNumber, String accountHolderName, Integer balance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Integer getBalance() {
        return this.balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer deposit(Integer amount) {
        this.setBalance(this.balance + amount);
        String transaction_id = (new TransactionIdGenerator()).createId();
        Transaction transaction = new Transaction(transaction_id, new Date(), amount, "deposit");
        this.transactions.add(transaction);
        System.out.println("Deposit "+amount+" success");
        return this.getBalance();
    }

    public Boolean isWithdrawable(Integer amount) {
        if (this.balance - amount > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Integer withdraw(Integer amount) throws BalanceNotEnoughException {
        if (isWithdrawable(amount)) {
            setBalance(this.balance - amount);
            String transaction_id = (new TransactionIdGenerator()).createId();
            Transaction transaction = new Transaction(transaction_id, new Date(), amount, "withdrawal");
            transactions.add(transaction);
            System.out.println("withdraw "+amount+" success");

        } else {
            throw new BalanceNotEnoughException("Current Balance is not enough");
        }
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void showTransactionHistory() {
        System.out.println("\u001B[34m"+"-----Transaction history-----"+"\u001B[0m");

        for (Transaction transaction : transactions) {
            transaction.showTransaction();
        }
    }

    public void showSummery() {
        System.out.println("\033[1m \u001B[34m"+"----Bank Account Details of "+this.getAccountHolderName()+"----\u001B[0m \033[0m");
        System.out.println("accountNumber " +this.accountNumber);
        System.out.println("accountNumber " +this.accountNumber);
        System.out.println("accountHolderName " +this.accountHolderName);
        System.out.println("balance " +this.balance);
        System.out.println("accountType " +this.accountType);
        System.out.println("\033[1m \u001B[34m ------------------- \u001B[0m \033[0m");
    }

}
