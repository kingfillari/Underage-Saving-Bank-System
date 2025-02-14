package com.bank.model;

import java.util.Date;

public class Transaction {
    private String type;
    private double amount;
    private Date date;
    private boolean approved;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
        this.approved = false;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }
}
