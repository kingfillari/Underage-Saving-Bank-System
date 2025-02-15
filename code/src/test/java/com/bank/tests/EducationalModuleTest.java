package com.bank.tests;


import org.junit.jupiter.api.Test;

import com.bank.model.EducationalModule;

import static org.junit.jupiter.api.Assertions.*;

class EducationalModuleTest {

    @Test
    void testEducationalModuleInitialization() {
        EducationalModule module = new EducationalModule("Budgeting Basics", "Learn how to create a simple budget", 10);

        assertEquals("Budgeting Basics", module.getTitle(), "Title should be set correctly.");
        assertEquals("Learn how to create a simple budget", module.getContent(), "Content should be set correctly.");
        assertEquals(10, module.getAgeGroup(), "Age group should be set correctly.");
    }
}

