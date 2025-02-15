package com.bank.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.model.Transaction;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

class TransactionTest {
    private Transaction transaction;

    @BeforeEach
    void setUp() {
        transaction = new Transaction("Deposit", 100.0);
    }

    @Test
    void testTransactionInitialization() {
        assertEquals("Deposit", transaction.getType(), "Transaction type should be set correctly.");
        assertEquals(100.0, transaction.getAmount(), "Transaction amount should be set correctly.");
        assertNotNull(transaction.getDate(), "Transaction date should be initialized.");
        assertFalse(transaction.isApproved(), "Transaction should not be approved initially.");
    }

    @Test
    void testApproveTransaction() {
        transaction.setApproved(true);
        assertTrue(transaction.isApproved(), "Transaction should be approved after calling setApproved(true).");
    }
}

