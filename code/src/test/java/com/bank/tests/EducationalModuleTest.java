package com.bank.tests;

import static org.junit.Assert.*;
import com.bank.model.*;
import org.junit.Test;

public class EducationalModuleTest {
    @Test
    public void testConstructorAndGetters() {
        EducationalModule module = new EducationalModule("History", "Ancient", 12);
        assertEquals("History", module.getTitle());
        assertEquals("Ancient", module.getContent());
        assertEquals(12, module.getAgeGroup());
    }
}