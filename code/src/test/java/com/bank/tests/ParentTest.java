package com.bank.tests;

import static org.junit.Assert.*;
import com.bank.model.*;
import org.junit.Test;

public class ParentTest {
    @Test
    public void testAddChild() {
        Parent parent = new Parent("John", "P001");
        Child child = new Child("Diana", "C005", 8);
        parent.addChild(child);
        assertEquals(1, parent.getChildren().size());
    }

    @Test
    public void testApproveTransaction() {
        Parent parent = new Parent("Mary", "P002");
        Transaction transaction = new Transaction("Deposit", 100.0);
        parent.approveTransaction(transaction);
        assertTrue(transaction.isApproved());
    }
}