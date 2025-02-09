package com.bank.tests;

import static org.junit.Assert.*;
import com.bank.model.*;
import org.junit.Test;

public class SavingsGoalTest {
    @Test
    public void testAddSavings() {
        SavingsGoal goal = new SavingsGoal("Phone", 500.0);
        goal.addSavings(200.0);
        assertEquals(200.0, goal.getCurrentAmount(), 0.001);
    }

    @Test
    public void testReachTargetAmount() {
        SavingsGoal goal = new SavingsGoal("Laptop", 1000.0);
        goal.addSavings(1000.0);
        assertEquals(1000.0, goal.getCurrentAmount(), 0.001);
    }

    @Test
    public void testNegativeSavings() {
        SavingsGoal goal = new SavingsGoal("Book", 50.0);
        goal.addSavings(-10.0); // Invalid, ignored
        assertEquals(0.0, goal.getCurrentAmount(), 0.001);
    }
}