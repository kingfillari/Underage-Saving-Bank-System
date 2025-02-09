package com.bank.tests;

import static org.junit.Assert.*;
import com.bank.model.*;
import org.junit.Test;
import java.util.Date;

public class TransactionTest {
    @Test
    public void testTransactionInitialization() {
        Transaction transaction = new Transaction("Withdrawal", 30.0);
        assertEquals("Withdrawal", transaction.getType());
        assertEquals(30.0, transaction.getAmount(), 0.001);
        assertNotNull(transaction.getDate());
    }

    @Test
    public void testApprovalStatus() {
        Transaction transaction = new Transaction("Deposit", 100.0);
        transaction.setApproved(true);
        assertTrue(transaction.isApproved());
    }
}