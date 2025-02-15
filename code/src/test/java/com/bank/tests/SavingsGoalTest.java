package com.bank.tests;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bank.model.SavingsGoal;

import static org.junit.jupiter.api.Assertions.*;

class SavingsGoalTest {
    private SavingsGoal savingsGoal;

    @BeforeEach
    void setUp() {
        savingsGoal = new SavingsGoal("New Bike", 200.0);
    }

    @Test
    void testSavingsGoalInitialization() {
        assertEquals("New Bike", savingsGoal.getName(), "Savings goal name should be set correctly.");
        assertEquals(200.0, savingsGoal.getTargetAmount(), "Target amount should be set correctly.");
        assertEquals(0.0, savingsGoal.getCurrentAmount(), "Current amount should start at 0.");
    }

    @Test
    void testAddSavings() {
        savingsGoal.addSavings(50.0);
        assertEquals(50.0, savingsGoal.getCurrentAmount(), "Current amount should be updated correctly.");

        savingsGoal.addSavings(150.0);
        assertEquals(200.0, savingsGoal.getCurrentAmount(), "Current amount should match the target after reaching goal.");
    }

    @Test
    void testGoalCompletion() {
        savingsGoal.addSavings(200.0);
        assertEquals(200.0, savingsGoal.getCurrentAmount(), "Savings goal should be fully funded.");
    }
}

