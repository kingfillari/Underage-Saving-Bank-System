package com.bank.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.model.Child;
import com.bank.model.Parent;
import com.bank.model.Transaction;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ParentTest {
    private Parent parent;
    private Child child;

    @BeforeEach
    void setUp() {
        parent = new Parent("Abebe Bekele", "P001");
        child = new Child("Kidus Abebe", "C001", 10);
    }

    @Test
    void testParentInitialization() {
        assertEquals("Abebe Bekele", parent.getName(), "Parent name should be set correctly.");
        assertEquals("P001", parent.getUserId(), "Parent user ID should be set correctly.");
        assertTrue(parent.getChildren().isEmpty(), "Parent should have no children initially.");
    }

    @Test
    void testAddChild() {
        parent.addChild(child);
        List<Child> children = parent.getChildren();

        assertEquals(1, children.size(), "Parent should have one child.");
        assertEquals(child, children.get(0), "The added child should be in the list.");
    }

    @Test
    void testApproveTransaction() {
        Transaction transaction = new Transaction("Deposit", 50.0);
        assertFalse(transaction.isApproved(), "Transaction should not be approved initially.");

        parent.approveTransaction(transaction);

        assertTrue(transaction.isApproved(), "Transaction should be approved after parent approval.");
    }
}
