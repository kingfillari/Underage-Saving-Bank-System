package com.bank.tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.model.Child;
import com.bank.model.EducationalModule;
import com.bank.model.SavingsGoal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class ChildTest {
    private Child child;

    @BeforeEach
    void setUp() {
        child = new Child("Kidus Abebe", "C001", 10);
    }

    @Test
    void testChildInitialization() {
        assertEquals("Kidus Abebe", child.getName(), "Child name should be set correctly.");
        assertEquals("C001", child.getUserId(), "User ID should be set correctly.");
        assertEquals(10, child.getAge(), "Child age should be set correctly.");
        assertTrue(child.getSavingsGoals().isEmpty(), "Child should have no savings goals initially.");
        assertTrue(child.getCompletedModules().isEmpty(), "Child should have no completed educational modules initially.");
    }

    @Test
    void testAddSavingsGoal() {
        SavingsGoal goal = new SavingsGoal("New Bike", 200.0);
        child.addSavingsGoal(goal);

        List<SavingsGoal> goals = child.getSavingsGoals();
        assertEquals(1, goals.size(), "Child should have one savings goal.");
        assertEquals(goal, goals.get(0), "The savings goal should be correctly added.");
    }

    @Test
    void testCompleteEducationalModule() {
        EducationalModule module = new EducationalModule("Budgeting Basics", "Learn how to create a simple budget", 10);
        child.completeEducationalModule(module);

        List<EducationalModule> completedModules = child.getCompletedModules();
        assertEquals(1, completedModules.size(), "Child should have one completed module.");
        assertEquals(module, completedModules.get(0), "The completed module should be correctly recorded.");
    }
}

