package org.example.Exercise2;

public class Customer {
    private String customerId;
    private String customerName;
    private String emailAddress;
    private String phoneNumber;

    public Customer(String customerId, String customerName, String emailAddress, String phoneNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

