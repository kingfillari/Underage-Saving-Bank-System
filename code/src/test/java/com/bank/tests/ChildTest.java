package com.bank.tests;

import static org.junit.Assert.*;
import com.bank.model.*;
import org.junit.Test;

public class ChildTest {
    @Test
    public void testAddSavingsGoal() {
        Child child = new Child("Alice", "C002", 12);
        SavingsGoal goal = new SavingsGoal("Bike", 200.0);
        child.addSavingsGoal(goal);
        assertEquals(1, child.getSavingsGoals().size());
    }

    @Test
    public void testCompleteEducationalModule() {
        Child child = new Child("Bob", "C003", 11);
        EducationalModule module = new EducationalModule("Science", "Basics", 10);
        child.completeEducationalModule(module);
        assertEquals(1, child.getCompletedModules().size());
    }

    @Test
    public void testAgeGetter() {
        Child child = new Child("Charlie", "C004", 9);
        assertEquals(9, child.getAge());
    }
}