package com.bank.tests;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.UnderageSavingBankSystem;
import com.bank.model.Account;
import com.bank.model.Child;
import com.bank.model.EducationalModule;
import com.bank.model.Parent;
import com.bank.model.SavingsGoal;
import com.bank.model.User;

class UnderageSavingBankSystemTest {
    private UnderageSavingBankSystem system;
    private Parent parent;
    private Child child;

    @BeforeEach
    void setUp() {
        system = new UnderageSavingBankSystem();

        // Create users
        parent = new Parent("Abebe Bekele", "P001");
        child = new Child("Kidus Abebe", "C001", 10);
        parent.addChild(child);

        system.addUser(parent);
        system.addUser(child);

        // Create account for child
        system.createAccount(child);
    }

    @Test
    void testUserAddedSuccessfully() {
        List<User> users = system.getUsers();
        assertEquals(2, users.size(), "There should be 2 users (parent and child) in the system.");
    }

    @Test
    void testAccountCreation() {
        Account childAccount = system.getAccountForChild(child);
        assertNotNull(childAccount, "Child account should be created successfully.");
        assertEquals(0.0, childAccount.getBalance(), "Newly created account should have a zero balance.");
    }

    @Test
    void testDepositFunctionality() {
        Account childAccount = system.getAccountForChild(child);
        assertNotNull(childAccount);

        childAccount.deposit(50.0);
        assertEquals(50.0, childAccount.getBalance(), "Account balance should be updated after deposit.");
    }

    @Test
    void testSavingsGoalProgress() {
        SavingsGoal goal = new SavingsGoal("New Bike", 100.0);
        child.addSavingsGoal(goal);

        goal.addSavings(50.0);
        assertEquals(50.0, goal.getCurrentAmount(), "Savings goal should reflect the correct amount saved.");
    }

    @Test
    void testEducationalModuleCompletion() {
        EducationalModule module = new EducationalModule("Budgeting Basics", "Learn how to create a simple budget", 10);
        system.addEducationalModule(module);

        child.completeEducationalModule(module);

        List<EducationalModule> completedModules = child.getCompletedModules();
        assertEquals(1, completedModules.size(), "Child should have completed one educational module.");
        assertTrue(completedModules.contains(module), "The completed module list should contain the added module.");
    }
}
