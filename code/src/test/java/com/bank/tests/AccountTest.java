package com.bank.tests;



import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import com.bank.model.Account;
import com.bank.model.Child;
import com.bank.model.Transaction;

class AccountTest {
    private Account account;
    private Child child;

    @BeforeEach
    void setUp() {
        child = new Child("Kidus Abebe", "C001", 10);
        account = new Account("ACC001", child);
    }

    @Test
    void testAccountInitialization() {
        assertEquals("ACC001", account.getAccountId(), "Account ID should be set correctly.");
        assertEquals(child, account.getOwner(), "Account owner should be the assigned child.");
        assertEquals(0.0, account.getBalance(), "New account should have a zero balance.");
        assertTrue(account.getTransactions().isEmpty(), "New account should have no transactions.");
    }

    @Test
    void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), "Balance should reflect the deposited amount.");
        
        List<Transaction> transactions = account.getTransactions();
        assertEquals(1, transactions.size(), "There should be one transaction after deposit.");
        assertEquals("Deposit", transactions.get(0).getType(), "Transaction type should be 'Deposit'.");
        assertEquals(100.0, transactions.get(0).getAmount(), "Transaction amount should match the deposit.");
    }

    @Test
    void testWithdrawSufficientFunds() {
        account.deposit(100.0);
        account.withdraw(50.0);
        
        assertEquals(50.0, account.getBalance(), "Balance should be updated correctly after withdrawal.");
        
        List<Transaction> transactions = account.getTransactions();

        assertEquals(2, transactions.size(), "There should be two transactions (deposit and withdrawal).");
        assertEquals("Withdrawal", transactions.get(1).getType(), "Transaction type should be 'Withdrawal'.");

        assertEquals(-50.0, transactions.get(1).getAmount(), "Transaction amount should be negative for withdrawal.");
    }

    @Test
    void testWithdrawInsufficientFunds() {
        account.withdraw(50.0);
        assertEquals(0.0, account.getBalance(), "Balance should remain unchanged if funds are insufficient scenario ");
        assertTrue(account.getTransactions().isEmpty(), "No transaction should be recorded for failed withdrawalS.");
    }
}
