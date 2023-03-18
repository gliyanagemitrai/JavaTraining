package org.example.Exercise2;

import java.util.*;

public class Bank {
    Set<Customer> customers = new LinkedHashSet<>( ) ;
    Map<String,BankAccount> bankAccounts = new HashMap<>();
    void addCustomer(Customer customer){
        customers.add(customer);
    }
    void removeCustomer(Customer customer){
        customers.remove(customer);
    }
    void addBankAccount(BankAccount bankAccount){

        bankAccounts.put(bankAccount.getAccountNumber(),bankAccount);
        if(bankAccount.getBalance()>0){
            int opening_balance = bankAccount.getBalance();
            bankAccount.setBalance(0);//initial amount start with 0
            bankAccount.deposit(opening_balance);//deposit amount when opening a account
        }
    }
    void removeBankAccount(BankAccount bankAccount){
        bankAccounts.remove(bankAccount.getAccountNumber());
    }
    void displayCustomerDetails(Customer customer){
        System.out.println("Customer Details");
        System.out.println("customerId"+customer.getCustomerId());
        System.out.println("customerName"+ customer.getCustomerName());
        System.out.println("emailAddress"+ customer.getEmailAddress());
        System.out.println("phoneNumber"+ customer.getPhoneNumber());
        System.out.println("_____________________________");
    }
    void displayAllTheCustomers(){
        for (Customer c:customers) {
            displayCustomerDetails(c);
        }
    }
    void displayBankAccountDetails(BankAccount bankAccount){
        System.out.println("\033[1m \u001B[34m"+"----Bank Account Details of "+bankAccount.getAccountHolderName()+"----\u001B[0m \033[0m");
        System.out.println("accountNumber "+bankAccount.getAccountNumber());
        System.out.println("accountType "+bankAccount.getAccountType());
        System.out.println("Balance "+bankAccount.getBalance());
        System.out.println("_____________________________");
    }

}
