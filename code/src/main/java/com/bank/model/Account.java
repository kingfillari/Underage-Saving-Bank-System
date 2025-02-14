package com.bank.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountId;
    private Child owner;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountId, Child owner) {
        this.accountId = accountId;
        this.owner = owner;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction("Withdrawal", -amount));
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public String getAccountId() {
        return accountId;
    }

    public Child getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
