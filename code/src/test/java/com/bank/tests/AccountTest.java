package com.bank.tests;

import static org.junit.Assert.*;
import com.bank.model.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class AccountTest {
    private Account account;
    private Child child;

    @Before
    public void setUp() {
        child = new Child("Test Child", "C001", 10);
        account = new Account("ACC001", child);
    }

    @Test
    public void testDepositUpdatesBalance() {
        account.deposit(50.0);
        assertEquals(50.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawSufficientFunds() {
        account.deposit(100.0);
        account.withdraw(30.0);
        assertEquals(70.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        account.deposit(20.0);
        account.withdraw(30.0);
        assertEquals(20.0, account.getBalance(), 0.001); // Balance unchanged
    }

    @Test
    public void testTransactionHistory() {
        account.deposit(50.0);
        account.withdraw(20.0);
        List<Transaction> transactions = account.getTransactions();
        assertEquals(2, transactions.size());
    }
}