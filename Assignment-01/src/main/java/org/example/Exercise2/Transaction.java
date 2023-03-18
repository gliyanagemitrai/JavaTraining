package org.example.Exercise2;

import java.util.Date;

public class Transaction {
    private String transactionID;
    private Date transactionDate;
    private Integer transactionAmount;
    private String transactionType;

    public Transaction(String transactionID, Date transactionDate, Integer transactionAmount, String transactionType) {
        this.transactionID = transactionID;
        this.transactionDate = transactionDate;
        this.transactionAmount = transactionAmount;
        this.transactionType = transactionType;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Integer getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Integer transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void showTransaction(){
        System.out.println("");
        System.out.println("transactionID "+ transactionID);
        System.out.println("transactionDate "+ transactionDate);
        System.out.println("transactionAmount "+ transactionAmount);
        System.out.println("transactionType "+ transactionType);
        System.out.println("------");

    }


}
