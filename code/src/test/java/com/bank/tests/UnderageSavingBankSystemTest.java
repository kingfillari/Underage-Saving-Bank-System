package com.bank.tests;

import static org.junit.Assert.*;
import com.bank.UnderageSavingBankSystem;
import com.bank.model.*;
import org.junit.Before;
import org.junit.Test;

public class UnderageSavingBankSystemTest {
    private UnderageSavingBankSystem system;
    private Parent parent;
    private Child child;

    @Before
    public void setUp() {
        system = new UnderageSavingBankSystem();
        parent = new Parent("John Doe", "P001");
        child = new Child("Jane Doe", "C001", 10);
        parent.addChild(child);
        system.addUser(parent);
        system.addUser(child);
    }

    @Test
    public void testCreateAccountForChild() {
        system.createAccount(child);
        assertNotNull("Account should exist", system.getAccountForChild(child));
    }

    @Test
    public void testAddEducationalModule() {
        EducationalModule module = new EducationalModule("Math", "Basics", 10);
        system.addEducationalModule(module);
        assertEquals(1, system.getEducationalModules().size());
    }

    @Test
    public void testNoAccountForInvalidChild() {
        Child invalidChild = new Child("Alice", "C002", 12);
        assertNull("Account should not exist", system.getAccountForChild(invalidChild));
    }
}